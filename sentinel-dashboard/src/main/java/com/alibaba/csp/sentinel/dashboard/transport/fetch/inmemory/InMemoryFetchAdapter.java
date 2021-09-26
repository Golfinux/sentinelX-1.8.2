package com.alibaba.csp.sentinel.dashboard.transport.fetch.inmemory;

import com.alibaba.csp.sentinel.dashboard.client.SentinelApiClient;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.RuleEntity;
import com.alibaba.csp.sentinel.dashboard.transport.fetch.Fetcher;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 20:05
 */
public abstract class InMemoryFetchAdapter<T extends RuleEntity> implements Fetcher<T> {

    protected SentinelApiClient sentinelApiClient;

    protected InMemoryFetchAdapter(SentinelApiClient sentinelApiClient) {
        this.sentinelApiClient = sentinelApiClient;
    }
}
