package com.jamie;

import java.util.*;

/**
 * @author jamie
 * @version 1.0.0
 * @date 2020/12/5 12:00
 * @description
 */
public class ServerIps {
    public static final List<String> LIST = Arrays.asList(
        "192.168.0.1",
        "192.168.0.2",
        "192.168.0.3",
        "192.168.0.4",
        "192.168.0.5",
        "192.168.0.6",
        "192.168.0.7",
        "192.168.0.8",
        "192.168.0.9",
        "192.168.0.10"
    );

    public static final Map<String, Integer> WIGHT_LIST = new LinkedHashMap<String, Integer>();
    static {
        WIGHT_LIST.put("A", 5);
        WIGHT_LIST.put("B", 1);
        WIGHT_LIST.put("C", 1);
//        WIGHT_LIST.put("192.168.0.4", 6);
//        WIGHT_LIST.put("192.168.0.5", 5);
//        WIGHT_LIST.put("192.168.0.6", 5);
//        WIGHT_LIST.put("192.168.0.7", 4);
//        WIGHT_LIST.put("192.168.0.8", 7);
//        WIGHT_LIST.put("192.168.0.9", 2);
//        WIGHT_LIST.put("192.168.0.10", 9);
    }
}
