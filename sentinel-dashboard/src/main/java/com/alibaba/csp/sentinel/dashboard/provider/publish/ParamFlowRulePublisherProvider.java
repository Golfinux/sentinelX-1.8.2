package com.alibaba.csp.sentinel.dashboard.provider.publish;

import com.alibaba.csp.sentinel.dashboard.datasource.Constants;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import org.springframework.stereotype.Component;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 23:12
 */
@Component
public class ParamFlowRulePublisherProvider extends PublisherProviderAdapter<ParamFlowRuleEntity>{

    @Override
    protected String getType() {
        return Constants.PARAM_FLOW_RULE;
    }
}
