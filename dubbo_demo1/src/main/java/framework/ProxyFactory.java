package framework;

import protocol.http.HttpProtocol;
import register.RemoteMapRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author jamie
 * @version 1.0.0
 * @date 2020/12/4 15:53
 * @description
 */
public class ProxyFactory {
    public static <T> T getProxy(final Class interfaceClass){
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Protocol protocol = ProtocolFactory.getProtocol();
                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), method.getParameterTypes(), args);
                URL url = RemoteMapRegister.random(interfaceClass.getName());
                String result = protocol.send(url, invocation);
                return result;
            }
        });
    }
}
