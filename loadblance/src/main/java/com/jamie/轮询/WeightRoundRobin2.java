package com.jamie.轮询;

import com.jamie.ServerIps;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jamie
 * @version 1.0.0
 * @date 2020/12/5 14:13
 * @description 动态权重
 *      A:5
 *      B:1
 *      C:1
 *
 *      AABACAA
 *      服务器
 *      1. ip
 *      2. weigth           --静态权重，5，1，1
 *      3. currentWeight    --动态权重，0，0，0
 *     currentWeigth = currentWeigth+ weigth max(currentWeigth) return  max(currentWeigth) = currentWeigth - totalWeight(7)
 * 1   5,1,1                                 5                  A       -2,1,1
 * 2   3,2,2                                 3                  A       -4,2,2
 * 3   1,3,3                                 3                  B       1,-4,3
 * 4   6,-3,4                                6                  A       -1,-3,4
 * 5   4,-2,5                                5                  C       4,-2,-2
 * 6   9,-1,-1                               9                  A       2,-1-1
 * 7   7,0,0                                 7                  A       0,0,0
 */
public class WeightRoundRobin2 {
    private static Map<String, Weight> weigths = new HashMap<String, Weight>();

    public static String getService(){
        int totalWeight = 0;
        for (Integer weight: ServerIps.WIGHT_LIST.values()) {
            totalWeight += weight;
        }
        if(weigths.isEmpty()){
            ServerIps.WIGHT_LIST.forEach((ip, weight) -> {
                weigths.put(ip, new Weight(ip, weight, 0));
            });
        }

        for (Weight weight: weigths.values()) {
            weight.setCurrentWight(weight.getCurrentWight() + weight.getWeight());
        }
        Weight maxCurrWeight = null;
        for (Weight weight: weigths.values()) {
            if(maxCurrWeight == null||weight.getCurrentWight() > maxCurrWeight.getCurrentWight()){
                maxCurrWeight = weight;
            }
        }
        maxCurrWeight.setCurrentWight(maxCurrWeight.getCurrentWight() - totalWeight);
        return maxCurrWeight.getIp();
    }
    public static void main(String[] args) {
        System.out.println("------轮询算法------");
        for (int i = 0; i < 10; i++) {
            System.out.println(getService());
        }
    }
}
