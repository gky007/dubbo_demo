package protocol.http;

import framework.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author jamie
 * @version 1.0.0
 * @date 2020/12/4 14:28
 * @description
 */
public class HttpClient {
    public String send(String hostname, Integer port, Invocation invocation) {
        ObjectOutputStream oos = null;
        try {
            URL url = new URL("http", hostname, port, "/");
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            oos = new ObjectOutputStream(outputStream);
            oos.writeObject(invocation);

            InputStream inputStream = httpURLConnection.getInputStream();
            String result = IOUtils.toString(inputStream);

            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos!=null) {
                try {
                    oos.flush();
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
