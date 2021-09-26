package com.alibaba.csp.sentinel.dashboard.transport.fetch.inmemory;

import com.alibaba.csp.sentinel.dashboard.client.SentinelApiClient;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.log.RecordLog;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.*;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 20:09
 */
@Component(DATASOURCE_IN_MEMORY + PARAM_FLOW_RULE + FETCHER)
@ConditionalOnProperty(name = "disableInMemory", havingValue = "false", matchIfMissing = true)
public class InMemoryParamFlowRuleFetcher extends InMemoryFetchAdapter<ParamFlowRuleEntity>{

    public InMemoryParamFlowRuleFetcher(SentinelApiClient sentinelApiClient) {
        super(sentinelApiClient);
    }

    @Override
    public List<ParamFlowRuleEntity> fetch(String app, String ip, int port) {
        try {
            return sentinelApiClient.fetchParamFlowRulesOfMachine(app, ip, port).get();
        } catch (InterruptedException e) {
            RecordLog.warn("[InMemoryParamFlowRulePublisher] Error when publish with InterruptedException ", e);
        } catch (ExecutionException e) {
            RecordLog.warn("[InMemoryParamFlowRulePublisher] Error when publish with ExecutionException ", e);
        }
        return new ArrayList<>();
    }
}
