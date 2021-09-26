package com.alibaba.csp.sentinel.dashboard.transport.publish.nacos;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.*;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 23:29
 */
@Component(DATASOURCE_NACOS + PARAM_FLOW_RULE + PUBLISHER)
@ConditionalOnProperty(name = "disableNacos", havingValue = "false", matchIfMissing = true)
public class NacosParamFlowRulePublisher extends NacosPublishAdapter<ParamFlowRuleEntity>{
}
