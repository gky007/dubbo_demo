package com.jamie.轮询;

import com.jamie.ServerIps;

/**
 * @author jamie
 * @version 1.0.0
 * @date 2020/12/5 13:59
 * @description
 */
public class RoundRobin {
    public static Integer pos = 0;
    public static String getService(){
        if (pos>ServerIps.LIST.size()) {
            pos = 0;
        }
        String ip = ServerIps.LIST.get(pos);
        pos++;
        return ip;
    }

    public static void main(String[] args) {
        System.out.println("------轮询算法------");
        for (int i = 0; i < 10; i++) {
            System.out.println(getService());
        }
    }
}
