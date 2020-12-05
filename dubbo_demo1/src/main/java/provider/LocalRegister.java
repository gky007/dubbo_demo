package provider;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jamie
 * @version 1.0.0
 * @date 2020/12/4 12:09
 * @description 本地服务注册类，保存服务地主，端口
 */
public class LocalRegister {
    private static Map<String, Class> map = new HashMap<String, Class>();
    public static void regist(String intrtfaceName, Class implClass){
        map.put(intrtfaceName, implClass);
    }
    public static Class get(String interfaceName){
        return map.get(interfaceName);
    }

}
