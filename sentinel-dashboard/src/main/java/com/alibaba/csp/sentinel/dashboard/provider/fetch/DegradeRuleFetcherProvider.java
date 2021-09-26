package com.alibaba.csp.sentinel.dashboard.provider.fetch;

import com.alibaba.csp.sentinel.dashboard.datasource.Constants;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import org.springframework.stereotype.Component;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 23:07
 */
@Component
public class DegradeRuleFetcherProvider extends FetcherProviderAdapter<DegradeRuleEntity>{

    @Override
    protected String getType() {
        return Constants.DEGRADE_RULE;
    }
}
