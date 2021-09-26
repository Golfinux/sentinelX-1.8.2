package com.alibaba.csp.sentinel.dashboard.rule.cloudConfig;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.dashboard.util.ProfileUtil;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.log.RecordLog;
import com.alibaba.csp.sentinel.transport.config.TransportConfig;
import com.alibaba.csp.sentinel.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 14:41
 */
@Component("flowRuleCloudConfigPublisher")
public class FlowRuleCloudConfigPublisher implements DynamicRulePublisher<List<FlowRuleEntity>> {

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private Converter<List<FlowRuleEntity>, String> converter;


    @Override
    public void publish(String app, List<FlowRuleEntity> rules) throws Exception {
        AssertUtil.notEmpty(app, "app name cannot be empty");
        if (rules == null) {
            return;
        }
        String profile = TransportConfig.getSentinelProfile();
        String label = TransportConfig.getSentinelLabel();
        String url = TransportConfig.getConfigServer() + "/scca-config-server/saveRuleProperties?application={1}&profile={2}&label={3}";
        Integer rows = restTemplate.postForObject(url, converter.convert(rules), Integer.class, app+"_sentinel", profile, label);
        RecordLog.info("add {}-{}-{} rows {}", app, profile, label, rows);
    }
}
