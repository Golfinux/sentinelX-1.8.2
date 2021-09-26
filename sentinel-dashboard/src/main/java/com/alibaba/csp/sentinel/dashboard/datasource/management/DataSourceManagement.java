package com.alibaba.csp.sentinel.dashboard.datasource.management;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 18:42
 */
public interface DataSourceManagement<T> {

    /**
     * get or create data source open api client
     *
     * @param dataSourceMachineInfo machine info
     * @return T client
     */
    T getOrCreateClient(DataSourceMachineInfo dataSourceMachineInfo);

    /**
     * transfer json to DataSourceMachineInfo
     *
     * @param jsonObject machine info
     * @return T client
     */
    DataSourceMachineInfo transfer(JSONObject jsonObject);
}
