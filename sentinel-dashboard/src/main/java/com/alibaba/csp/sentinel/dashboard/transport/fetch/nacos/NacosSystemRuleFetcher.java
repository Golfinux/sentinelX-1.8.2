package com.alibaba.csp.sentinel.dashboard.transport.fetch.nacos;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import static com.alibaba.csp.sentinel.dashboard.datasource.Constants.*;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 23:26
 */
@Component(DATASOURCE_NACOS + SYSTEM_RULE + FETCHER)
@ConditionalOnProperty(name = "disableNacos", havingValue = "false", matchIfMissing = true)
public class NacosSystemRuleFetcher extends NacosFetchAdapter<SystemRuleEntity>{
}
