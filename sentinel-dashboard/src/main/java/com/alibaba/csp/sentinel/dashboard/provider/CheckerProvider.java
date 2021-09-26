package com.alibaba.csp.sentinel.dashboard.provider;

import com.alibaba.csp.sentinel.dashboard.controller.config.checker.Checker;
import com.alibaba.csp.sentinel.dashboard.datasource.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 19:30
 */
@Component
public class CheckerProvider extends ServiceProviderAdapter implements ServiceProvider<Checker> {

    @Autowired
    private Map<String, Checker> checkerMap;

    @Override
    public Checker get(String app, String ip, Integer port) {
        String dataSourceType = getDataSourceType(app, ip, port);
        return checkerMap.get(dataSourceType + Constants.CONFIG_CHANGE_CHECKER);
    }
}
