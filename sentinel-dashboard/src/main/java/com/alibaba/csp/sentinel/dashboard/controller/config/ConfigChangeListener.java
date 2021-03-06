package com.alibaba.csp.sentinel.dashboard.controller.config;

import com.alibaba.csp.sentinel.dashboard.controller.config.checker.Checker;
import com.alibaba.csp.sentinel.dashboard.datasource.Constants;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.RuleEntity;
import com.alibaba.csp.sentinel.dashboard.discovery.MachineInfo;
import com.alibaba.csp.sentinel.dashboard.domain.Result;
import com.alibaba.csp.sentinel.dashboard.provider.ServiceProvider;
import com.alibaba.csp.sentinel.dashboard.provider.TypeServiceProvider;
import com.alibaba.csp.sentinel.dashboard.repository.rule.InMemoryRuleRepositoryAdapter;
import com.alibaba.csp.sentinel.dashboard.transport.fetch.Fetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 19:36
 */
@RestController
@RequestMapping(value = "configChange", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConfigChangeListener {

    @Autowired
    private ServiceProvider<Checker> checkerProvider;

    @Autowired
    private Map<String, InMemoryRuleRepositoryAdapter> repositoryMap;

    @Autowired
    private TypeServiceProvider<Fetcher> fetcherProvider;

    @PutMapping("flowRules")
    public Result<Boolean> flowRulesOnChange(String operator, String app, String ip, Integer port) {
        return Result.ofSuccess(processOnChange(operator, app, ip, port, Constants.FLOW_RULE, Constants.IN_MEM_FLOW_RULE_STORE));
    }

    @PutMapping("degradeRules")
    public Result<Boolean> degradeRulesOnChange(String operator, String app, String ip, Integer port) {
        return Result.ofSuccess(processOnChange(operator, app, ip, port, Constants.DEGRADE_RULE, Constants.IN_MEM_DEGRADE_RULE_STORE));
    }

    @PutMapping("authorityRules")
    public Result<Boolean> authorityRulesOnChange(String operator, String app, String ip, Integer port) {
        return Result.ofSuccess(processOnChange(operator, app, ip, port, Constants.AUTHORITY_RULE, Constants.IN_MEM_AUTHORITY_RULE_STORE));
    }

    @PutMapping("systemRules")
    public Result<Boolean> systemRulesOnChange(String operator, String app, String ip, Integer port) {
        return Result.ofSuccess(processOnChange(operator, app, ip, port, Constants.SYSTEM_RULE, Constants.IN_MEM_SYSTEM_RULE_STORE));
    }

    @PutMapping("paramFlowRules")
    public Result<Boolean> paramFlowRulesOnChange(String operator, String app, String ip, Integer port) {
        return Result.ofSuccess(processOnChange(operator, app, ip, port, Constants.PARAM_FLOW_RULE, Constants.IN_MEM_PARAM_FLOW_RULE_STORE));
    }

    private Boolean processOnChange(String operator, String app, String ip, Integer port, String ruleType, String repositoryName) {
        Checker checker = checkerProvider.get(app, ip, port);
        boolean checkResult = checker.checkOperator(operator, app, ip, port);
        if (checkResult) {
            Fetcher fetcher = fetcherProvider.get(app, ip, port, ruleType);
            InMemoryRuleRepositoryAdapter repository = repositoryMap.get(repositoryName);
            List<RuleEntity> rules = fetcher.fetch(app, ip, port);
            repository.deleteByMachine(MachineInfo.of(app, ip, port));
            repository.saveAll(rules);
        }
        return checkResult;
    }
}
