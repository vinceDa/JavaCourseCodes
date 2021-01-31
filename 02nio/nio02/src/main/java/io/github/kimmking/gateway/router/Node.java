package io.github.kimmking.gateway.router;

/**
 * 服务节点
 * @author ohYoung
 * @date 2021/1/31 19:39
 */
public class Node {

    /**
     *  权重, 一开始就确定的
     */
    private final int weight;
    /**
     *  服务名称(地址)
     */
    private final String server;
    /**
     *  当前权重(权重随着轮询过程变化)
     */
    private int currentWeight;

    public Node(int weight, String server) {
        this.weight = weight;
        this.server = server;
        this.currentWeight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getServer() {
        return server;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }
}
