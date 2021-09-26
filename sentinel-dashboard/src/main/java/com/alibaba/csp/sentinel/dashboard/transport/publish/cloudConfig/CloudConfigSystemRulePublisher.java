package com.alibaba.csp.sentinel.dashboard.transport.publish.cloudConfig;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.*;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/18 22:23
 */
@Component(DATASOURCE_CLOUD_CONFIG + SYSTEM_RULE + PUBLISHER)
@ConditionalOnProperty(name = "disableCloudConfig", havingValue = "false", matchIfMissing = true)
public class CloudConfigSystemRulePublisher extends CloudConfigPublishAdapter<SystemRuleEntity> {
}
