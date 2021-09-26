package com.alibaba.csp.sentinel.dashboard.transport.fetch.inmemory;

import com.alibaba.csp.sentinel.dashboard.client.SentinelApiClient;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.*;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 20:05
 */
@Component(DATASOURCE_IN_MEMORY + SYSTEM_RULE + FETCHER)
@ConditionalOnProperty(name = "disableInMemory", havingValue = "false", matchIfMissing = true)
public class InMemorySystemRuleFetcher extends InMemoryFetchAdapter<SystemRuleEntity>{

    public InMemorySystemRuleFetcher(SentinelApiClient sentinelApiClient) {
        super(sentinelApiClient);
    }

    @Override
    public List<SystemRuleEntity> fetch(String app, String ip, int port) {
        return sentinelApiClient.fetchSystemRuleOfMachine(app, ip, port);
    }
}
