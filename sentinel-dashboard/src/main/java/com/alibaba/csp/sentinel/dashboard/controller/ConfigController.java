package com.alibaba.csp.sentinel.dashboard.controller;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/17 1:39
 */
@Controller
@RequestMapping("config")
public class ConfigController {

    @ResponseBody
    @RequestMapping("/get")
    public Map getConfig() throws NacosException, InterruptedException {
        // 用以演示用，页面返回数据展示
        Map map = new HashMap();
        //  服务地址。本机演示故写localhost。请根据实际情况替换对应IP
        String serverAddr = "127.0.0.1:8848";
        String dataId = "nacos-spring";
        String group = "bilaisheng";
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
        // 创建ConfigService，此处通过Properties方式进行创建，另一种演示serviceaddr获取configService.
        // 原理上都是通过 ConfigFactory.createConfigService()去进行创建
        ConfigService configService = NacosFactory.createConfigService(properties);
        // ConfigService configService = NacosFactory.createConfigService(serverAddr);

        String content = configService.getConfig(dataId, group, 5000);
        System.out.println("config : " + content);
        map.put("content", content);
        // 添加Listener，用以演示receive获取数据结果
        configService.addListener(dataId, group, new Listener() {
            @Override
            public void receiveConfigInfo(String configInfo) {
                System.out.println("recieve : " + configInfo);
            }
            @Override
            public Executor getExecutor() {
                return null;
            }
        });

        // 推送config。将原有dataid中信息替换。
//        boolean isPublishOk = configService.publishConfig(dataId, group, "publish config content");
//        System.out.println("isPublishOk : " + isPublishOk);
//        map.put("isPublishOk", isPublishOk);

//        Thread.sleep(3000);
//        content = configService.getConfig(dataId, group, 5000);
        System.out.println("Thread sleep 3000ms : " + content);
        map.put("Thread sleep 3000ms : ", content);

        // 删除指定dataid , group 配置
        /*boolean isRemoveOk = configService.removeConfig(dataId, group);
        System.out.println("remove " + dataId + "config is " + isRemoveOk);
        Thread.sleep(3000);

        content = configService.getConfig(dataId, group, 5000);
        System.out.println("content after 5000ms "+content);
        Thread.sleep(3000);*/
        return map;
    }
}
