package com.alibaba.csp.sentinel.dashboard.util;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 16:24
 */
@Component
public class ProfileUtil implements ApplicationContextAware {

    private static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        ProfileUtil.context = applicationContext;
    }

    // 获取当前环境参数  exp: dev,prod,test
    public static String getActiveProfile() {
        String []profiles = context.getEnvironment().getActiveProfiles();
        if( ! ArrayUtils.isEmpty(profiles)){
            return profiles[0];
        }
        return "dev";
    }
}
