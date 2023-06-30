package com.mytoken.es.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mytoken.es.LJ.ConnectElasticsearch;
import com.mytoken.es.model.User;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * description
 *
 * @author lou
 * @create 2023/6/28
 */
public class InsertDoc {

    public static void main(String[] args) {
        ConnectElasticsearch.connect(client->{
            IndexRequest request = new IndexRequest();
            request.index("user").id("1001");
            User user = new User().setName("zhangsan").setAge(30).setSex("男");
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(user);
            request.source(json, XContentType.JSON);
            IndexResponse response = client.index(request, RequestOptions.DEFAULT);
            System.out.println("_index:" + response.getIndex());
            System.out.println("_id:" + response.getId());
            System.out.println("_result:" + response.getResult());
        });
    }
}
