package com.alibaba.csp.sentinel.dashboard.datasource.management;

import com.alibaba.fastjson.JSONObject;
import com.ctrip.framework.apollo.openapi.client.ApolloOpenApiClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.DATASOURCE_APOLLO;
import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.MANAGEMENT;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 22:33
 */
@Component(DATASOURCE_APOLLO + MANAGEMENT)
@ConditionalOnProperty(name = "disableApollo", havingValue = "false", matchIfMissing = true)
public class ApolloManagement implements DataSourceManagement<ApolloOpenApiClient> {

    private Map<String, ApolloOpenApiClient> clientPool = new ConcurrentHashMap<>(16);

    @Override
    public ApolloOpenApiClient getOrCreateClient(DataSourceMachineInfo dataSourceMachineInfo) {
        return getOrCreateClient((ApolloMachineInfo) dataSourceMachineInfo);
    }

    @Override
    public DataSourceMachineInfo transfer(JSONObject jsonObject) {
        return jsonObject.toJavaObject(ApolloMachineInfo.class);
    }

    private ApolloOpenApiClient getOrCreateClient(ApolloMachineInfo apolloMachineInfo){
        return getOrCreate(apolloMachineInfo.getPortalUrl(), apolloMachineInfo.getToken(), apolloMachineInfo.getConnectTimeout(), apolloMachineInfo.getReadTimeout());
    }

    private ApolloOpenApiClient getOrCreate(String portalUrl, String token, int connectTimeout, int readTimeout) {
        return clientPool.computeIfAbsent(portalUrl, e -> ApolloOpenApiClient.newBuilder()
                .withPortalUrl(portalUrl)
                .withConnectTimeout(connectTimeout)
                .withReadTimeout(readTimeout)
                .withToken(token)
                .build());
    }
}
