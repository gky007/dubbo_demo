package com.jamie.轮询;

/**
 * @author jamie
 * @version 1.0.0
 * @date 2020/12/5 14:12
 * @description
 */
public class RequestId {
    public static Integer num = 0;

    public static Integer getAndIncrement(){
        return num++;
    }
}
