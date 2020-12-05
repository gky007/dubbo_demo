package provider.impl;

import provider.api.FiestService;

/**
 * @author jamie
 * @version 1.0.0
 * @date 2020/12/4 16:37
 * @description
 */
public class FiestServiceImpl implements FiestService {
    @Override
    public String hi(String s) {
        return "hi "+s;
    }
}
