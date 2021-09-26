package com.alibaba.csp.sentinel.dashboard.transport.fetch;

import java.util.List;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 19:37
 */
public interface Fetcher<T> {

    /**
     * fetch rules
     *
     * @param app project name
     * @param ip project deployment IP
     * @param port project deployment port
     * @return boolean
     */
    List<T> fetch(String app, String ip, int port);
}
