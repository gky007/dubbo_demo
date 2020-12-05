package protocol.http;

import framework.Invocation;
import framework.Protocol;
import framework.URL;

/**
 * @author jamie
 * @version 1.0.0
 * @date 2020/12/4 16:55
 * @description
 */
public class HttpProtocol implements Protocol {
    @Override
    public void start(URL url) {
        new HttpServer().start(url.getHostName(), url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
        return new HttpClient().send(url.getHostName(), url.getPort(), invocation);
    }
}
