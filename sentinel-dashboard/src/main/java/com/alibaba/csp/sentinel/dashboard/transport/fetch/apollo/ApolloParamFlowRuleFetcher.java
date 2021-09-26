package com.alibaba.csp.sentinel.dashboard.transport.fetch.apollo;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.*;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 23:19
 */
@Component(DATASOURCE_APOLLO + PARAM_FLOW_RULE + FETCHER)
@ConditionalOnProperty(name = "disableApollo", havingValue = "false", matchIfMissing = true)
public class ApolloParamFlowRuleFetcher extends ApolloFetchAdapter<ParamFlowRuleEntity>{
}
