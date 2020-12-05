package com.jamie.spi;

import com.jamie.spi.api.CarInterface;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author jamie
 * @version 1.0.0
 * @date 2020/12/4 19:05
 * @description
 */
public class CarDemo {
    public static void main(String[] args) {
        ServiceLoader<CarInterface> serviceLoader = ServiceLoader.load(CarInterface.class);
        Iterator<CarInterface> iterator = serviceLoader.iterator();
        //java spi不能单独获取某个实现类
        //java spi没有IOC和AOP机制
        while (iterator.hasNext()){
            CarInterface carInterface = iterator.next();
//            carInterface.getColor();
        }
    }
}
