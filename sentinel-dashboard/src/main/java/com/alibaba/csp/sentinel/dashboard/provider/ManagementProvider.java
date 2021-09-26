package com.alibaba.csp.sentinel.dashboard.provider;

import com.alibaba.csp.sentinel.dashboard.datasource.Constants;
import com.alibaba.csp.sentinel.dashboard.datasource.management.DataSourceManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 19:29
 */
@Component
public class ManagementProvider extends ServiceProviderAdapter implements ServiceProvider<DataSourceManagement> {

    @Autowired
    private Map<String, DataSourceManagement> managementMap;

    @Override
    public DataSourceManagement get(String app, String ip, Integer port) {
        String dataSourceType = getDataSourceType(app, ip, port);
        return managementMap.get(dataSourceType + Constants.MANAGEMENT);
    }
}
