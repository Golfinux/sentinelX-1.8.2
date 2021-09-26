package com.alibaba.csp.sentinel.dashboard.transport.fetch.apollo;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.RuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.management.ApolloMachineInfo;
import com.alibaba.csp.sentinel.dashboard.transport.fetch.FetchAdapter;
import com.ctrip.framework.apollo.openapi.client.ApolloOpenApiClient;
import com.ctrip.framework.apollo.openapi.dto.OpenItemDTO;

import java.util.Optional;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 23:17
 */
public abstract class ApolloFetchAdapter<T extends RuleEntity> extends FetchAdapter<T, ApolloOpenApiClient, ApolloMachineInfo> {

    @Override
    protected String getConfig(ApolloOpenApiClient apolloClient, ApolloMachineInfo apolloMachineInfo) {
        OpenItemDTO item = apolloClient.getItem(apolloMachineInfo.getAppId(), apolloMachineInfo.getEnv(), apolloMachineInfo.getClusterName(),
                apolloMachineInfo.getNamespace(), getKey(apolloMachineInfo));
        return Optional.ofNullable(item)
                .map(OpenItemDTO::getValue)
                .orElse(null);
    }
}
