package framework;

import protocol.dubbo.DubboProtocol;
import protocol.http.HttpProtocol;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author jamie
 * @version 1.0.0
 * @date 2020/12/4 17:02
 * @description
 */
public class ProtocolFactory {
    public static Protocol getProtocol() {
        // java spi      只能用其中一个，用起来不方便
        ServiceLoader<Protocol> serviceLoader = ServiceLoader.load(Protocol.class);
        Iterator<Protocol> iterator = serviceLoader.iterator();
        return iterator.next();
        //工厂模式
//        String name = System.getProperty("protocolName");
//        if (name == null || name.equals("")) {
//            name = "http";
//        }
//        switch (name) {
//            case "http":
//                return new HttpProtocol();
//            case "dubbo":
//                return new DubboProtocol();
//            default:
//                break;
//        }
//        return new HttpProtocol();
    }
}
