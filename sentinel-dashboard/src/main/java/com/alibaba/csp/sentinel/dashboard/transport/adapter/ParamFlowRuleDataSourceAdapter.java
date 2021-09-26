package com.alibaba.csp.sentinel.dashboard.transport.adapter;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.management.DataSourceMachineInfo;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRule;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 18:50
 */
@Component
public class ParamFlowRuleDataSourceAdapter implements DataSourceAdapter<ParamFlowRuleEntity> {

    @Override
    public String getKey(DataSourceMachineInfo dataSourceMachineInfo) {
        return dataSourceMachineInfo.getParamFlowRulesKey();
    }

    @Override
    public List<ParamFlowRuleEntity> convert(String app, String ip, int port, String value) {
        return Optional.ofNullable(value)
                .map(rules -> JSON.parseArray(rules, ParamFlowRule.class))
                .map(rules -> rules.stream()
                        .map(e -> ParamFlowRuleEntity.fromParamFlowRule(app, ip, port, e))
                        .collect(Collectors.toList()))
                .orElse(null);
    }

    @Override
    public String processRules(List<ParamFlowRuleEntity> rules) {
        return JSON.toJSONString(rules.stream().map(ParamFlowRuleEntity::toRule).collect(Collectors.toList()));
    }
}
