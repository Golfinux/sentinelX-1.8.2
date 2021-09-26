package com.alibaba.csp.sentinel.dashboard.transport.publish.immemory;

import com.alibaba.csp.sentinel.dashboard.client.SentinelApiClient;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import com.alibaba.csp.sentinel.dashboard.repository.rule.InMemoryRuleRepositoryAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.*;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 19:06
 */
@Component(DATASOURCE_IN_MEMORY + SYSTEM_RULE + PUBLISHER)
@ConditionalOnProperty(name = "disableInMemory", havingValue = "false", matchIfMissing = true)
public class InMemorySystemRulePublisher extends InMemoryPublishAdapter<SystemRuleEntity>{

    public InMemorySystemRulePublisher(InMemoryRuleRepositoryAdapter<SystemRuleEntity> repository, SentinelApiClient sentinelApiClient) {
        super(repository, sentinelApiClient);
    }

    @Override
    protected boolean publish(String app, String ip, int port, List<SystemRuleEntity> rules) {
        return sentinelApiClient.setSystemRuleOfMachine(app, ip, port, rules);
    }
}
