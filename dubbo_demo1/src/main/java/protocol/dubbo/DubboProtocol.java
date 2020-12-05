package protocol.dubbo;

import framework.Invocation;
import framework.Protocol;
import framework.URL;

/**
 * @author jamie
 * @version 1.0.0
 * @date 2020/12/4 17:10
 * @description
 */
public class DubboProtocol implements Protocol {
    @Override
    public void start(URL url) {

    }

    @Override
    public String send(URL url, Invocation invocation) {
        return null;
    }
}
