package com.alibaba.csp.sentinel.dashboard.provider.publish;

import com.alibaba.csp.sentinel.dashboard.datasource.Constants;
import com.alibaba.csp.sentinel.dashboard.provider.ServiceProviderAdapter;
import com.alibaba.csp.sentinel.dashboard.provider.TypeServiceProvider;
import com.alibaba.csp.sentinel.dashboard.transport.publish.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Gu Lifeng
 * @version 1.0
 * @date 2021/9/15 23:09
 */
@Component
public class PublisherProvider extends ServiceProviderAdapter implements TypeServiceProvider<Publisher> {

    @Autowired
    private Map<String, Publisher> publisherMap;

    @Override
    public Publisher get(String app, String ip, Integer port, String type) {
        String dataSourceType = getDataSourceType(app, ip, port);
        String key = dataSourceType + type + Constants.PUBLISHER;
        return publisherMap.get(key);
    }
}
