package com.mytoken.es.JK;

import org.elasticsearch.client.RestHighLevelClient;

/**
 * description
 *
 * @author lou
 * @create 2023/6/28
 */
public interface ElasticsearchTask {

    void doSomething(RestHighLevelClient client) throws Exception;
}
