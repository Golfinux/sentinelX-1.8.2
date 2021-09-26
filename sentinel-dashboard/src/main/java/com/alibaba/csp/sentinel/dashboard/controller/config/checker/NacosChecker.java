package com.alibaba.csp.sentinel.dashboard.controller.config.checker;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.CONFIG_CHANGE_CHECKER;
import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.DATASOURCE_NACOS;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 19:32
 */
@Component(DATASOURCE_NACOS + CONFIG_CHANGE_CHECKER)
@ConditionalOnProperty(name = "disableNacos", havingValue = "false", matchIfMissing = true)
public class NacosChecker implements Checker {

    @Override
    public boolean checkOperator(String operator, String app, String ip, Integer port) {
        return true;
    }
}
