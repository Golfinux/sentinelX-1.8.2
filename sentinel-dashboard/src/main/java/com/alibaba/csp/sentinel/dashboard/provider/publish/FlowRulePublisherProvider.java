package com.alibaba.csp.sentinel.dashboard.provider.publish;

import com.alibaba.csp.sentinel.dashboard.datasource.Constants;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import org.springframework.stereotype.Component;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 23:13
 */
@Component
public class FlowRulePublisherProvider extends PublisherProviderAdapter<FlowRuleEntity>{

    @Override
    protected String getType() {
        return Constants.FLOW_RULE;
    }
}
