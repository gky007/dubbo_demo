package provider;

import framework.Protocol;
import framework.ProtocolFactory;
import framework.URL;
import protocol.http.HttpProtocol;
import protocol.http.HttpServer;
import provider.api.FiestService;
import provider.api.HelloService;
import provider.impl.HelloServiceImp;
import register.RemoteMapRegister;

/**
 * @author jamie
 * @version 1.0.0
 * @date 2020/12/4 11:17
 * @description
 */
public class Provider {
    public static void main(String[] args) {
        //1.本地注册
        //(域名，实现类)
        LocalRegister.regist(HelloService.class.getName(),  HelloServiceImp.class);

        //2.远程注册
        //(服务器)
        URL url = new URL("localhost", 8080);
        RemoteMapRegister.register(HelloService.class.getName(), url);
        RemoteMapRegister.register(FiestService.class.getName(), url);
        //3.启动tomcat
        Protocol protocol = ProtocolFactory.getProtocol();
        protocol.start(url);
    }
}
