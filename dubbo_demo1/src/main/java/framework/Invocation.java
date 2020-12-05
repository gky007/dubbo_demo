package framework;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jamie
 * @version 1.0.0
 * @date 2020/12/4 14:30
 * @description
 */
@Data
@AllArgsConstructor
public class Invocation implements Serializable {
    private  String interfaceName;
    private String methodName;
    private Class[] paramTypes;
    private Object[] params;
}
