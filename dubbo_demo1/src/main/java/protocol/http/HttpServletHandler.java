package protocol.http;

import framework.Invocation;
import org.apache.commons.io.IOUtils;
import provider.LocalRegister;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author jamie
 * @version 1.0.0
 * @date 2020/12/4 12:00
 * @description
 */
public class HttpServletHandler {
    public void handler(HttpServletRequest req, HttpServletResponse resp){
        //核心处理请求，返回结果
        try {
            InputStream inputStream = req.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            Invocation invocation = (Invocation)ois.readObject();
            Class impClass = LocalRegister.get(invocation.getInterfaceName());
            Method method = impClass.getMethod(invocation.getMethodName(),invocation.getParamTypes());
            String result =(String) method.invoke(impClass.newInstance(), invocation.getParams());
            IOUtils.write(result, resp.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
