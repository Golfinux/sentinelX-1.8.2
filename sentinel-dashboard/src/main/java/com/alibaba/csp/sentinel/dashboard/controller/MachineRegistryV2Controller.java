package com.alibaba.csp.sentinel.dashboard.controller;

import com.alibaba.csp.sentinel.dashboard.datasource.Constants;
import com.alibaba.csp.sentinel.dashboard.datasource.management.DataSourceMachineInfo;
import com.alibaba.csp.sentinel.dashboard.datasource.management.DataSourceManagement;
import com.alibaba.csp.sentinel.dashboard.discovery.AppManagement;
import com.alibaba.csp.sentinel.dashboard.discovery.MachineDiscovery;
import com.alibaba.csp.sentinel.dashboard.domain.Result;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/16 16:13
 */
@RestController
@RequestMapping(value = "/registryV2", produces = MediaType.APPLICATION_JSON_VALUE)
public class MachineRegistryV2Controller {

    private final Logger logger = LoggerFactory.getLogger(MachineRegistryV2Controller.class);

    @Autowired
    private AppManagement appManagement;

    @Autowired
    private Map<String, DataSourceManagement> managementMap;

    @GetMapping("/machine")
    public Result<?> receiveHeartBeat(String info, String v) {
        JSONObject jsonObject = JSONObject.parseObject(info);
        String dataSourceType = jsonObject.getString("dataSourceType");
        String managementName = dataSourceType + Constants.MANAGEMENT;
        DataSourceManagement dataSourceManagement = managementMap.get(managementName);
        DataSourceMachineInfo dataSourceMachineInfo = dataSourceManagement.transfer(jsonObject);
        if (dataSourceMachineInfo.getApp() == null) {
            dataSourceMachineInfo.setApp(MachineDiscovery.UNKNOWN_APP_NAME);
        }
        if (dataSourceMachineInfo.getIp() == null) {
            return Result.ofFail(-1, "ip can't be null");
        }
        if (dataSourceMachineInfo.getPort() == null) {
            return Result.ofFail(-1, "port can't be null");
        }
        if (dataSourceMachineInfo.getPort() == -1) {
            logger.info("Receive heartbeat from {} but port not set yet", dataSourceMachineInfo.getIp());
            return Result.ofFail(-1, "your port not set yet");
        }
        String sentinelVersion = StringUtil.isEmpty(v) ? "unknown" : v;
        String version = dataSourceMachineInfo.getVersion();
        try {
            dataSourceMachineInfo.setHeartbeatVersion(Long.parseLong(version));
            dataSourceMachineInfo.setLastHeartbeat(System.currentTimeMillis());
            dataSourceMachineInfo.setVersion(sentinelVersion);
            dataSourceManagement.getOrCreateClient(dataSourceMachineInfo);
            appManagement.addMachine(dataSourceMachineInfo);
            return Result.ofSuccessMsg("success");
        } catch (Exception e) {
            logger.error("Receive heartbeat error", e);
            return Result.ofFail(-1, e.getMessage());
        }
    }
}
