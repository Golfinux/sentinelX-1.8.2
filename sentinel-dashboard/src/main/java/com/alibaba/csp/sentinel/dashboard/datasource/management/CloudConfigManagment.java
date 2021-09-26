package com.alibaba.csp.sentinel.dashboard.datasource.management;

import com.alibaba.csp.sentinel.dashboard.client.SentinelApiClient;
import com.alibaba.fastjson.JSONObject;
import com.ctrip.framework.apollo.openapi.client.ApolloOpenApiClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.*;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/17 15:48
 */
@Qualifier
@Component(DATASOURCE_CLOUD_CONFIG + MANAGEMENT)
@ConditionalOnProperty(name = "disableCloudConfig", havingValue = "false", matchIfMissing = true)
public class CloudConfigManagment implements DataSourceManagement<SentinelApiClient> {

    private Map<String, SentinelApiClient> clientPool = new ConcurrentHashMap<>(16);

    @Override
    public SentinelApiClient getOrCreateClient(DataSourceMachineInfo dataSourceMachineInfo) {
        return new SentinelApiClient();
    }

    @Override
    public DataSourceMachineInfo transfer(JSONObject jsonObject) {
        return jsonObject.toJavaObject(CloudConfigMachineInfo.class);
    }
}
