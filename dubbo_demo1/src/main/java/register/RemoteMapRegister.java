package register;

import framework.URL;

import java.io.*;
import java.util.*;

/**
 * @author jamie
 * @version 1.0.0
 * @date 2020/12/4 13:44
 * @description
 */
public class RemoteMapRegister {
    private static Map<String, List<URL>> REGISTER = new HashMap<String, List<URL>>();

    public static void register(String interfaceName, URL url){
        REGISTER.put(interfaceName, Collections.singletonList(url));
        System.out.println("注册的服务名称为：" + interfaceName+"/"+url.getHostName()+":"+url.getPort());
        saveFile();
    }

    public static URL random(String interfaceName){
        REGISTER = getFile();
        List<URL> list = REGISTER.get(interfaceName);
        Random random = new Random();
        int n = random.nextInt(list.size());
        return list.get(n);
    }

    private static void saveFile(){
        try {
            FileOutputStream fileInputStream = new FileOutputStream("/temp.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileInputStream);
            objectOutputStream.writeObject(REGISTER);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, List<URL>> getFile(){
        try {
            FileInputStream fileInputStream = new FileInputStream("/temp.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String, List<URL>> )objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
