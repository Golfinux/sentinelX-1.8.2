package com.alibaba.csp.sentinel.dashboard.transport.fetch.apollo;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.*;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 23:18
 */
@Component(DATASOURCE_APOLLO + FLOW_RULE + FETCHER)
@ConditionalOnProperty(name = "disableApollo", havingValue = "false", matchIfMissing = true)
public class ApolloFlowRuleFetcher extends ApolloFetchAdapter<FlowRuleEntity>{
}
