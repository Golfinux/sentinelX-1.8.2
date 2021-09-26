package com.alibaba.csp.sentinel.dashboard.datasource.management;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 22:25
 */
public class NacosMachineInfo extends DataSourceMachineInfo{

    private String properties;
    private String group;
    private long timeoutMs;

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public long getTimeoutMs() {
        return timeoutMs;
    }

    public void setTimeoutMs(long timeoutMs) {
        this.timeoutMs = timeoutMs;
    }

    @Override
    public String toString() {
        return new StringBuilder("NacosMachineInfo{")
                .append(super.toString())
                .append(", properties='").append(properties).append('\'')
                .append(", group='").append(group).append('\'')
                .append(", timeoutMs=").append(timeoutMs).toString();
    }
}
