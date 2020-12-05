package framework;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jamie
 * @version 1.0.0
 * @date 2020/12/4 13:46
 * @description
 */
@Data
@AllArgsConstructor
public class URL implements Serializable {

    private String hostName;

    private int port;
}
