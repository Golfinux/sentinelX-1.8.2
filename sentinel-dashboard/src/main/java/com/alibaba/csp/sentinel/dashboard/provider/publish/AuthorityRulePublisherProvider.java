package com.alibaba.csp.sentinel.dashboard.provider.publish;

import com.alibaba.csp.sentinel.dashboard.datasource.Constants;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import org.springframework.stereotype.Component;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 23:15
 */
@Component
public class AuthorityRulePublisherProvider extends PublisherProviderAdapter<AuthorityRuleEntity>{

    @Override
    protected String getType() {
        return Constants.AUTHORITY_RULE;
    }
}
