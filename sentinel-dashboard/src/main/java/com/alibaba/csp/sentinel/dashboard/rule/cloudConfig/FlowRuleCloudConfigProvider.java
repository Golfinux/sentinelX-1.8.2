package com.alibaba.csp.sentinel.dashboard.rule.cloudConfig;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.datasource.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 17:46
 */
@Component("flowRuleCloudConfigProvider")
public class FlowRuleCloudConfigProvider implements DynamicRuleProvider<List<FlowRuleEntity>> {

    @Autowired
    private Converter<String, List<FlowRuleEntity>> converter;


    @Override
    public List<FlowRuleEntity> getRules(String appName) throws Exception {
        return null;
    }
}
