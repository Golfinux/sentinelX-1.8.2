package com.alibaba.csp.sentinel.dashboard.datasource.management;

import com.alibaba.csp.sentinel.dashboard.discovery.MachineInfo;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 19:13
 */
public class CloudConfigMachineInfo extends DataSourceMachineInfo {

    private String application;

    private String label;

    private String profile;

    private String uri;

    private long timeoutMs;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public long getTimeoutMs() {
        return timeoutMs;
    }

    public void setTimeoutMs(long timeoutMs) {
        this.timeoutMs = timeoutMs;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "CloudConfigMachineInfo{" +
                "application='" + application + '\'' +
                ", label='" + label + '\'' +
                ", profile='" + profile + '\'' +
                ", uri='" + uri + '\'' +
                ", timeoutMs=" + timeoutMs +
                '}';
    }
}
