package com.alibaba.csp.sentinel.dashboard.provider.fetch;

import com.alibaba.csp.sentinel.dashboard.datasource.Constants;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import org.springframework.stereotype.Component;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 23:05
 */
@Component
public class FlowRuleFetcherProvider extends FetcherProviderAdapter<FlowRuleEntity>{

    @Override
    protected String getType() {
        return Constants.FLOW_RULE;
    }
}
