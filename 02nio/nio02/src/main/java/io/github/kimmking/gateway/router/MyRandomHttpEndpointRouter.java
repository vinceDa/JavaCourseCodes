package io.github.kimmking.gateway.router;

import java.util.*;

/**
 * 加权轮询策略
 * @author vince
 */
public class MyRandomHttpEndpointRouter implements HttpRoundRobinRouter {

    private List<Node> nodes = null;

    @Override
    public String route(List<String> endpoints) {
        if (nodes == null) {
            nodes = new ArrayList<>();
            for (int i = 0; i < endpoints.size(); i++) {
                Node node = new Node(i + 1, endpoints.get(i));
                nodes.add(node);
            }
        }
        /*int totalWeight = nodes.stream().mapToInt(Node::getWeight).sum();
        nodes.forEach(single -> single.setCurrentWeight(single.getWeight() + single.getCurrentWeight()));
        Node maxNode = nodes.stream().max(Comparator.comparingInt(single -> single.getWeight() + single.getCurrentWeight())).get();
        maxNode.setCurrentWeight(maxNode.getCurrentWeight() - totalWeight);*/
        int totalWeight = 0 ;
        Node maxNode = null ;
        int maxWeight = 0 ;

        for (Node n : nodes) {
            totalWeight += n.getWeight();

            // 每个节点的当前权重要加上原始的权重
            n.setCurrentWeight(n.getCurrentWeight() + n.getWeight());

            // 保存当前权重最大的节点
            if (maxNode == null || maxWeight < n.getCurrentWeight()) {
                maxNode = n;
                maxWeight = n.getCurrentWeight();
            }
        }
        // 被选中的节点权重减掉总权重
        maxNode.setCurrentWeight(maxNode.getCurrentWeight() - totalWeight);
        return maxNode.getServer();
    }
}
