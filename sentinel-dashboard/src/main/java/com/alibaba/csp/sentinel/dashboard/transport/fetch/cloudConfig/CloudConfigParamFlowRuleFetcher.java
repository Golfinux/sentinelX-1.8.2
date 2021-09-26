package com.alibaba.csp.sentinel.dashboard.transport.fetch.cloudConfig;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.*;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/18 15:59
 */
@Component(DATASOURCE_CLOUD_CONFIG + PARAM_FLOW_RULE + FETCHER)
@ConditionalOnProperty(name = "disableCloudConfig", havingValue = "false", matchIfMissing = true)
public class CloudConfigParamFlowRuleFetcher extends CloudConfigFetchAdapter<ParamFlowRuleEntity>{
}
