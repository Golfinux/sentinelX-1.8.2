package com.alibaba.csp.sentinel.dashboard.transport.fetch.nacos;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.RuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.management.NacosMachineInfo;
import com.alibaba.csp.sentinel.dashboard.transport.fetch.FetchAdapter;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 23:23
 */
public abstract class NacosFetchAdapter<T extends RuleEntity> extends FetchAdapter<T, ConfigService, NacosMachineInfo> {

    private static final Logger logger = LoggerFactory.getLogger(NacosFetchAdapter.class);

    @Override
    protected String getConfig(ConfigService configService, NacosMachineInfo nacosMachineInfo) {
        try {
            return configService.getConfig(getKey(nacosMachineInfo), nacosMachineInfo.getGroup(), nacosMachineInfo.getTimeoutMs());
        } catch (NacosException e) {
            logger.error("[Nacos] fetch rules from nacos failed, rules key:{}, reason:{}", getKey(nacosMachineInfo), e);
        }
        return null;
    }
}
