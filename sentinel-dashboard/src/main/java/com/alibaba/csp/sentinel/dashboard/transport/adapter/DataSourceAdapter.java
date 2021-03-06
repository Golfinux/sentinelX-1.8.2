package com.alibaba.csp.sentinel.dashboard.transport.adapter;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.RuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.management.DataSourceMachineInfo;

import java.util.List;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 18:39
 */
public interface DataSourceAdapter<T extends RuleEntity> {

    /**
     * Get the key of the rule to be published
     *
     * @param dataSourceMachineInfo third-party data source machine information
     * @return key
     */
    String getKey(DataSourceMachineInfo dataSourceMachineInfo);

    /**
     * Convert to the corresponding rules
     *
     * @param app project name
     * @param ip project deployment IP
     * @param port project deployment port
     * @param value rules fetched from third-party data sources
     * @return java.util.List<T>
     */
    List<T> convert(String app, String ip, int port, String value);

    /**
     * Process rules let them store to third party data source
     *
     * @param rules rules to prepare for processing
     * @return java.lang.String
     */
    String processRules(List<T> rules);
}
