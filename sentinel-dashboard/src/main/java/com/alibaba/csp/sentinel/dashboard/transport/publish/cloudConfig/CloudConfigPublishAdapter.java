package com.alibaba.csp.sentinel.dashboard.transport.publish.cloudConfig;

import com.alibaba.csp.sentinel.dashboard.client.SentinelApiClient;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.RuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.management.CloudConfigMachineInfo;
import com.alibaba.csp.sentinel.dashboard.transport.publish.PublishAdapter;
import com.alibaba.nacos.api.exception.NacosException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 19:09
 */
public abstract class CloudConfigPublishAdapter<T extends RuleEntity> extends PublishAdapter<T, SentinelApiClient, CloudConfigMachineInfo> {

    private static final Logger logger = LoggerFactory.getLogger(CloudConfigPublishAdapter.class);

    @Override
    protected boolean publish(SentinelApiClient sentinelApiClient, CloudConfigMachineInfo cloudConfigMachineInfo) {
        boolean result = false;
        try {
            Map<String, String> map = new HashMap<>();
            map.put(getKey(cloudConfigMachineInfo), processRules(findRules(cloudConfigMachineInfo)));
            result = sentinelApiClient.publishConfigProperties(cloudConfigMachineInfo.getApplication(), cloudConfigMachineInfo.getProfile(), cloudConfigMachineInfo.getLabel(), cloudConfigMachineInfo.getUri(), map);
        } catch (Exception e) {
            logger.error("[Nacos] publish rules to cloud config failed, rules key:{}, reason:{}", getKey(cloudConfigMachineInfo), e);
        }
        return result;
    }
}
