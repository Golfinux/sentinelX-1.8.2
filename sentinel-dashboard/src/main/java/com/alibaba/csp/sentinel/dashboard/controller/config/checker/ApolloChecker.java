package com.alibaba.csp.sentinel.dashboard.controller.config.checker;

import com.alibaba.csp.sentinel.dashboard.datasource.management.ApolloMachineInfo;
import com.alibaba.csp.sentinel.dashboard.discovery.AppManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.CONFIG_CHANGE_CHECKER;
import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.DATASOURCE_APOLLO;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 19:33
 */
@Component(DATASOURCE_APOLLO + CONFIG_CHANGE_CHECKER)
@ConditionalOnProperty(name = "disableApollo", havingValue = "false", matchIfMissing = true)
public class ApolloChecker implements Checker{

    @Autowired
    private AppManagement appManagement;

    @Override
    public boolean checkOperator(String operator, String app, String ip, Integer port) {
        return Optional.ofNullable(appManagement.getDetailApp(app))
                .filter(appInfo -> Objects.nonNull(operator))
                .flatMap(appInfo -> appInfo.getMachine(ip, port))
                .map(machineInfo -> !operator.equals(((ApolloMachineInfo) machineInfo).getOperator()))
                .orElse(false);
    }
}
