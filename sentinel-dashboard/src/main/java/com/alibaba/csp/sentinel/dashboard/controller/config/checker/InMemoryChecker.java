package com.alibaba.csp.sentinel.dashboard.controller.config.checker;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.CONFIG_CHANGE_CHECKER;
import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.DATASOURCE_IN_MEMORY;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 19:31
 */
@Component(DATASOURCE_IN_MEMORY + CONFIG_CHANGE_CHECKER)
@ConditionalOnProperty(name = "disableInMemory", havingValue = "false", matchIfMissing = true)
public class InMemoryChecker implements Checker{

    @Override
    public boolean checkOperator(String operator, String app, String ip, Integer port) {
        return true;
    }
}
