package com.jamie.随机;

import com.jamie.ServerIps;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jamie
 * @version 1.0.0
 * @date 2020/12/5 11:56
 * @description 负载均衡随机算法
 */
public class Random {
    public static String getService(){
        List<String> list = ServerIps.LIST;
        java.util.Random random = new java.util.Random();
        int randomPos = random.nextInt(list.size());
        return list.get(randomPos);
    }

    public static String getService1(){
        List<String> ips = new ArrayList<>();
        for (String ip : ServerIps.WIGHT_LIST.keySet()) {
            Integer wight = ServerIps.WIGHT_LIST.get(ip);
            for (int i = 0; i < wight; i++) {
                ips.add(ip);
            }
        }
        java.util.Random random = new java.util.Random();
        int randomPos = random.nextInt(ips.size());
        return ips.get(randomPos);
    }

    public static String getService2(){
        int totalWeight = 0;
        for (Integer weight: ServerIps.WIGHT_LIST.values()) {
            totalWeight += weight;
        }

        java.util.Random random = new java.util.Random();
        int pos = random.nextInt(totalWeight);

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
        Random random = new Random();
        System.out.println("一般随机算法：" + random.getService());
        System.out.println("加权随机算法1：" + random.getService1());
        System.out.println("加权随机算法2：" + random.getService2());
    }
}
