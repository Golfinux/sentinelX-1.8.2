package com.alibaba.csp.sentinel.dashboard.transport.publish.immemory;

import com.alibaba.csp.sentinel.dashboard.client.SentinelApiClient;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import com.alibaba.csp.sentinel.dashboard.repository.rule.InMemoryRuleRepositoryAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.*;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 19:02
 */
@Component(DATASOURCE_IN_MEMORY + AUTHORITY_RULE + PUBLISHER)
@ConditionalOnProperty(name = "disableInMemory", havingValue = "false", matchIfMissing = true)
public class InMemoryAuthorityRulePublisher extends InMemoryPublishAdapter<AuthorityRuleEntity> {

    public InMemoryAuthorityRulePublisher(InMemoryRuleRepositoryAdapter<AuthorityRuleEntity> repository, SentinelApiClient sentinelApiClient) {
        super(repository, sentinelApiClient);
    }

    @Override
    protected boolean publish(String app, String ip, int port, List<AuthorityRuleEntity> rules) {
        return sentinelApiClient.setAuthorityRuleOfMachine(app, ip, port, rules);
    }
}
