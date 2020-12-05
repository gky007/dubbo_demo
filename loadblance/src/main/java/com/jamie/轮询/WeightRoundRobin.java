package com.jamie.轮询;

import com.jamie.ServerIps;

/**
 * @author jamie
 * @version 1.0.0
 * @date 2020/12/5 14:13
 * @description
 */
public class WeightRoundRobin {

    public static String getService(){
        int totalWeight = 0;
        for (Integer weight: ServerIps.WIGHT_LIST.values()) {
            totalWeight += weight;
        }
        Integer requestId = RequestId.getAndIncrement();
        int pos = requestId % totalWeight;

        for (String ip : ServerIps.WIGHT_LIST.keySet()) {
            Integer wight = ServerIps.WIGHT_LIST.get(ip);
            if(pos < wight){
                return ip;
            }
            pos = pos - wight;
        }

        return "";
    }
    public static void main(String[] args) {
        System.out.println("------轮询算法------");
        for (int i = 0; i < 100; i++) {
            System.out.println(getService());
        }
    }
}
