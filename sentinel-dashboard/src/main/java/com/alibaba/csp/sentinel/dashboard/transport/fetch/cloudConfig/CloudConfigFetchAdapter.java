package com.alibaba.csp.sentinel.dashboard.transport.fetch.cloudConfig;

import com.alibaba.csp.sentinel.dashboard.client.SentinelApiClient;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.RuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.management.CloudConfigMachineInfo;
import com.alibaba.csp.sentinel.dashboard.transport.fetch.FetchAdapter;
import com.alibaba.csp.sentinel.dashboard.transport.fetch.Fetcher;
import com.alibaba.csp.sentinel.dashboard.transport.fetch.nacos.NacosFetchAdapter;
import com.alibaba.nacos.api.exception.NacosException;
import com.ctrip.framework.apollo.core.utils.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/18 11:18
 */
public abstract class CloudConfigFetchAdapter<T extends RuleEntity> extends FetchAdapter<T, SentinelApiClient, CloudConfigMachineInfo> {

    private static final Logger logger = LoggerFactory.getLogger(CloudConfigFetchAdapter.class);

    @Override
    protected String getConfig(SentinelApiClient sentinelApiClient, CloudConfigMachineInfo cloudConfigMachineInfo) {
        try {
            String result =sentinelApiClient.fetchFlowRuleProperties(cloudConfigMachineInfo.getApplication(), cloudConfigMachineInfo.getUri(), cloudConfigMachineInfo.getProfile(), cloudConfigMachineInfo.getLabel());
            logger.info("[CloudConfig] fetch all rules from SCCA, rules key:{}, value:{}", getKey(cloudConfigMachineInfo), result);
            Yaml yaml = new Yaml();
            Map<String, Object> map = yaml.loadAs(new ByteArrayInputStream(result.getBytes()), Map.class);

            if(map.containsKey(getKey(cloudConfigMachineInfo))){
                String prop = map.get(getKey(cloudConfigMachineInfo))+"";

                logger.info("[CloudConfig] fetch rules from SCCA, rules key:{}, value:{}", getKey(cloudConfigMachineInfo), prop);
                return prop;
            }
            return null;
        } catch (Exception e) {
            logger.error("[Nacos] fetch rules from nacos failed, rules key:{}, reason:{}", getKey(cloudConfigMachineInfo), e);
        }
        return null;
    }
}
