package com.alibaba.csp.sentinel.dashboard.transport.publish.apollo;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.*;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 23:36
 */
@Component(DATASOURCE_APOLLO + DEGRADE_RULE + PUBLISHER)
@ConditionalOnProperty(name = "disableApollo", havingValue = "false", matchIfMissing = true)
public class ApolloDegradeRulePublisher extends ApolloPublishAdapter<DegradeRuleEntity> {
}
