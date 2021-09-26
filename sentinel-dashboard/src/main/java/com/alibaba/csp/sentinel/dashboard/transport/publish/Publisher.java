package com.alibaba.csp.sentinel.dashboard.transport.publish;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 18:57
 */
public interface Publisher<T> {

    boolean publish(String app, String ip, int port);
}
