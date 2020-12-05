package framework;

/**
 * @author jamie
 * @version 1.0.0
 * @date 2020/12/4 16:53
 * @description 协议
 */
public interface Protocol {
    void start(URL url);
    String send(URL url, Invocation invocation);
}
