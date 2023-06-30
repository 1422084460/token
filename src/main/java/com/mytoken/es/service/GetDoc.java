package com.mytoken.es.service;

import com.mytoken.es.LJ.ConnectElasticsearch;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;

/**
 * description
 *
 * @author lou
 * @create 2023/6/28
 */
public class GetDoc {

    public static void main(String[] args) {
        ConnectElasticsearch.connect(client -> {
            GetRequest request = new GetRequest().index("user").id("1001");
            GetResponse response = client.get(request, RequestOptions.DEFAULT);
        });
    }
}
