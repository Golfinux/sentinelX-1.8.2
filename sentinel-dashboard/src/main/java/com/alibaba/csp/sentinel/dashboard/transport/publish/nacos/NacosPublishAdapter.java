package com.alibaba.csp.sentinel.dashboard.transport.publish.nacos;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.RuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.management.NacosMachineInfo;
import com.alibaba.csp.sentinel.dashboard.transport.publish.PublishAdapter;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 23:27
 */
public abstract class NacosPublishAdapter<T extends RuleEntity> extends PublishAdapter<T, ConfigService, NacosMachineInfo> {

    private static final Logger logger = LoggerFactory.getLogger(NacosPublishAdapter.class);

    @Override
    protected boolean publish(ConfigService configService, NacosMachineInfo nacosMachineInfo) {
        boolean result = false;
        try {
            result = configService.publishConfig(getKey(nacosMachineInfo), nacosMachineInfo.getGroup(),
                    processRules(findRules(nacosMachineInfo)));
        } catch (NacosException e) {
            logger.error("[Nacos] publish rules to nacos failed, rules key:{}, reason:{}", getKey(nacosMachineInfo), e);
        }
        return result;
    }
}
