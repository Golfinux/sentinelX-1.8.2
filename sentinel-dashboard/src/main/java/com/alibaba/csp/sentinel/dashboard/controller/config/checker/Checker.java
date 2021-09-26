package com.alibaba.csp.sentinel.dashboard.controller.config.checker;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 19:31
 */
public interface Checker {

    boolean checkOperator(String operator, String app, String ip, Integer port);
}
