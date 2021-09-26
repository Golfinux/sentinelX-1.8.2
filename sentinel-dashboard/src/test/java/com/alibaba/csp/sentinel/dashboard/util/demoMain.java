package com.alibaba.csp.sentinel.dashboard.util;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/17 1:19
 */
public class demoMain {
    public static void main(String[] args) throws NacosException {
        //使用nacos client远程获取nacos服务上的配置信息
        //nacos server地址
        String serverAddr = "127.0.0.1:8848";
        //data id
        String dataId = "Sentinel-Nacos-Demo_172.31.209.112_8089_flowRules";
        //group
        String group = "SENTINEL_GROUP";

        //namespace
        String namespace = "";
        Properties properties =new Properties();
        properties.put("serverAddr",serverAddr);
        properties.put("namespace",namespace);
        //获取配置
        ConfigService configService = null;
        try {
            configService = NacosFactory.createConfigService(properties);
        } catch (NacosException e) {
            e.printStackTrace();
        }
        // String dataId, String group, long timeoutMs
        String config = configService.getConfig(dataId, group, 5000);
        System.out.println(config);
        //String dataId, String group, Listener listener
        /*configService.addListener(dataId, group, new Listener() {
            public Executor getExecutor() {
                return null;
            }
            //当配置有变化 时候获取通知
            public void receiveConfigInfo(String s) {
                System.out.println(s);
            }
        });

        while (true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

    }

}
