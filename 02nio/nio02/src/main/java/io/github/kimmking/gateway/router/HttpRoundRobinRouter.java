package io.github.kimmking.gateway.router;

import java.util.List;

/**
 * @author vince
 */
public interface HttpRoundRobinRouter {
    
    String route(List<String> endpoints);
    
    // Load Balance
    // Random
    // RoundRibbon 
    // Weight
    // - server01,20
    // - server02,30
    // - server03,50
    
}
