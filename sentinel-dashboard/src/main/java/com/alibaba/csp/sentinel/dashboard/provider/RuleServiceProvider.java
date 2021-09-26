package com.alibaba.csp.sentinel.dashboard.provider;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.RuleEntity;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 19:28
 */
public interface RuleServiceProvider<T, R extends RuleEntity> {

    /**
     * get service by rule entity
     *
     * @param entity RuleEntity
     * @return T which service you need
     */
    T get(R entity);
}
