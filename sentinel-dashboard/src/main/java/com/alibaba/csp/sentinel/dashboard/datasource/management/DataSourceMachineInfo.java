package com.alibaba.csp.sentinel.dashboard.datasource.management;

import com.alibaba.csp.sentinel.dashboard.discovery.MachineInfo;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 18:42
 */
public class DataSourceMachineInfo extends MachineInfo {

    private String degradeRulesKey;
    private String flowRulesKey;
    private String authorityRulesKey;
    private String systemRulesKey;
    private String paramFlowRulesKey;
    private DataSourceType dataSourceType;

    public String getDegradeRulesKey() {
        return degradeRulesKey;
    }

    public void setDegradeRulesKey(String degradeRulesKey) {
        this.degradeRulesKey = degradeRulesKey;
    }

    public String getFlowRulesKey() {
        return flowRulesKey;
    }

    public void setFlowRulesKey(String flowRulesKey) {
        this.flowRulesKey = flowRulesKey;
    }

    public String getAuthorityRulesKey() {
        return authorityRulesKey;
    }

    public void setAuthorityRulesKey(String authorityRulesKey) {
        this.authorityRulesKey = authorityRulesKey;
    }

    public String getSystemRulesKey() {
        return systemRulesKey;
    }

    public void setSystemRulesKey(String systemRulesKey) {
        this.systemRulesKey = systemRulesKey;
    }

    public String getParamFlowRulesKey() {
        return paramFlowRulesKey;
    }

    public void setParamFlowRulesKey(String paramFlowRulesKey) {
        this.paramFlowRulesKey = paramFlowRulesKey;
    }

    public DataSourceType getDataSourceType() {
        return dataSourceType;
    }

    public void setDataSourceType(DataSourceType dataSourceType) {
        this.dataSourceType = dataSourceType;
    }

    @Override
    public String toString() {
        return new StringBuilder("DataSourceMachineInfo{")
                .append(super.toString())
                .append(", degradeRulesKey='").append(degradeRulesKey).append('\'')
                .append(", flowRulesKey='").append(flowRulesKey).append('\'')
                .append(", authorityRulesKey='").append(authorityRulesKey).append('\'')
                .append(", systemRulesKey='").append(systemRulesKey).append('\'')
                .append(", paramFlowRulesKey='").append(paramFlowRulesKey).append('\'')
                .append(", dataSourceType='").append(dataSourceType).append('\'')
                .append('}').toString();
    }
}
