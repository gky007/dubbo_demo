package protocol.http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jamie
 * @version 1.0.0
 * @date 2020/12/4 11:59
 * @description 处理请求
 */
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new HttpServletHandler().handler(req, resp);
    }
}
