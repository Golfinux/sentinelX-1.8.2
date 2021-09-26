package com.alibaba.csp.sentinel.dashboard.transport.publish.immemory;

import com.alibaba.csp.sentinel.dashboard.client.SentinelApiClient;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.repository.rule.InMemoryRuleRepositoryAdapter;
import com.alibaba.csp.sentinel.log.RecordLog;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.*;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 19:05
 */
@Component(DATASOURCE_IN_MEMORY + PARAM_FLOW_RULE + PUBLISHER)
@ConditionalOnProperty(name = "disableInMemory", havingValue = "false", matchIfMissing = true)
public class InMemoryParamFlowRulePublisher extends InMemoryPublishAdapter<ParamFlowRuleEntity> {

    public InMemoryParamFlowRulePublisher(InMemoryRuleRepositoryAdapter<ParamFlowRuleEntity> repository, SentinelApiClient sentinelApiClient) {
        super(repository, sentinelApiClient);
    }

    @Override
    protected boolean publish(String app, String ip, int port, List<ParamFlowRuleEntity> rules) {
        try {
            sentinelApiClient.setParamFlowRuleOfMachine(app, ip, port, rules).get();
            return true;
        } catch (InterruptedException e) {
            RecordLog.warn("[InMemoryParamFlowRulePublisher] Error when publish with InterruptedException ", e);
        } catch (ExecutionException e) {
            RecordLog.warn("[InMemoryParamFlowRulePublisher] Error when publish with ExecutionException ", e);
        }
        return false;
    }
}
