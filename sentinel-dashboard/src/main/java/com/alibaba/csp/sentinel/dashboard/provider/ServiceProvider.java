package com.alibaba.csp.sentinel.dashboard.provider;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 19:26
 */
public interface ServiceProvider<T> {

    /**
     * get service
     *
     * @param app project name
     * @param ip project deployment IP
     * @param port project deployment port
     * @return T which service you need
     */
    T get(String app, String ip, Integer port);
}
