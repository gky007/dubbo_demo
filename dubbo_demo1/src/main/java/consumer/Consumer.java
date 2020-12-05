package consumer;

import framework.Invocation;
import framework.ProxyFactory;
import protocol.http.HttpClient;
import provider.api.HelloService;
import provider.impl.HelloServiceImp;

/**
 * @author jamie
 * @version 1.0.0
 * @date 2020/12/4 14:56
 * @description
 */
public class Consumer {
    public static void main(String[] args) {
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String result = helloService.sayHello("jamie");
        System.out.println("result = " + result);
    }
}
