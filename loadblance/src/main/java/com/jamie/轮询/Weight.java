package com.jamie.轮询;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author jamie
 * @version 1.0.0
 * @date 2020/12/5 14:29
 * @description
 */
@Data
@AllArgsConstructor
public class Weight {
    private String ip;
    private Integer weight;
    private Integer currentWight;
}
