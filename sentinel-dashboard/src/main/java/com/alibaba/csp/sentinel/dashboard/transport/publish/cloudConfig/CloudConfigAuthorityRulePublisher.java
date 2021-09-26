package com.alibaba.csp.sentinel.dashboard.transport.publish.cloudConfig;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.*;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/18 22:18
 */
@Component(DATASOURCE_CLOUD_CONFIG + AUTHORITY_RULE + PUBLISHER)
@ConditionalOnProperty(name = "disableCloudConfig", havingValue = "false", matchIfMissing = true)
public class CloudConfigAuthorityRulePublisher extends CloudConfigPublishAdapter<AuthorityRuleEntity> {
}
