package com.alibaba.csp.sentinel.dashboard.transport.fetch.inmemory;

import com.alibaba.csp.sentinel.dashboard.client.SentinelApiClient;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.*;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 20:06
 */
@Component(DATASOURCE_IN_MEMORY + AUTHORITY_RULE + FETCHER)
@ConditionalOnProperty(name = "disableInMemory", havingValue = "false", matchIfMissing = true)
public class InMemoryAuthorityRuleFetcher extends InMemoryFetchAdapter<AuthorityRuleEntity>{

    public InMemoryAuthorityRuleFetcher(SentinelApiClient sentinelApiClient) {
        super(sentinelApiClient);
    }

    @Override
    public List<AuthorityRuleEntity> fetch(String app, String ip, int port) {
        return sentinelApiClient.fetchAuthorityRulesOfMachine(app, ip, port);
    }
}
