package com.alibaba.csp.sentinel.dashboard.controller.config.checker;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.*;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/23 14:48
 */
@Component(DATASOURCE_CLOUD_CONFIG + CONFIG_CHANGE_CHECKER)
@ConditionalOnProperty(name = "disableCloudConfig", havingValue = "false", matchIfMissing = true)
public class CloudConfigChecker implements Checker {
    @Override
    public boolean checkOperator(String operator, String app, String ip, Integer port) {
        return true;
    }
}
