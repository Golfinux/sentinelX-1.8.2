package com.alibaba.csp.sentinel.dashboard.provider.fetch;

import com.alibaba.csp.sentinel.dashboard.datasource.Constants;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import org.springframework.stereotype.Component;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 23:08
 */
@Component
public class AuthorityRuleFetcherProvider extends FetcherProviderAdapter<AuthorityRuleEntity>{

    @Override
    protected String getType() {
        return Constants.AUTHORITY_RULE;
    }
}
