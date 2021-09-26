package com.alibaba.csp.sentinel.dashboard.transport.adapter;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.management.DataSourceMachineInfo;
import com.alibaba.csp.sentinel.slots.system.SystemRule;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 18:51
 */
@Component
public class SystemRuleDataSourceAdapter implements DataSourceAdapter<SystemRuleEntity> {

    @Override
    public String getKey(DataSourceMachineInfo dataSourceMachineInfo) {
        return dataSourceMachineInfo.getSystemRulesKey();
    }

    @Override
    public List<SystemRuleEntity> convert(String app, String ip, int port, String value) {
        return Optional.ofNullable(value)
                .map(rules -> JSON.parseArray(rules, SystemRule.class))
                .map(rules -> rules.stream()
                        .map(e -> SystemRuleEntity.fromSystemRule(app, ip, port, e))
                        .collect(Collectors.toList()))
                .orElse(null);
    }

    @Override
    public String processRules(List<SystemRuleEntity> rules) {
        return JSON.toJSONString(rules.stream().map(SystemRuleEntity::toRule).collect(Collectors.toList()));
    }
}
