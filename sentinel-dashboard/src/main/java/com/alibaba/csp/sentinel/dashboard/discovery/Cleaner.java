package com.alibaba.csp.sentinel.dashboard.discovery;

import com.alibaba.csp.sentinel.dashboard.repository.rule.InMemoryRuleRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 22:37
 */
@Component
public class Cleaner {

    @Autowired
    private List<InMemoryRuleRepositoryAdapter> repositories;

    public void cleanMachineResource(MachineInfo machineInfo) {
        repositories.forEach(repository -> repository.deleteByMachine(machineInfo));
    }

    public void cleanAppResource(AppInfo appInfo) {
        repositories.forEach(repository -> repository.deleteByApp(appInfo));
    }
}
