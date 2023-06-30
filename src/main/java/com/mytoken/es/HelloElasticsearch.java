package com.mytoken.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

/**
 * description
 *
 * @author lou
 * @create 2023/6/28
 */
public class HelloElasticsearch {

    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //CreateIndexRequest request = new CreateIndexRequest("user2");
        //GetIndexRequest request = new GetIndexRequest("user2");
        DeleteIndexRequest request = new DeleteIndexRequest("user2");
        //GetIndexResponse response = client.indices().get(request, RequestOptions.DEFAULT);

        AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);

        System.out.println("aliases:"+response.isAcknowledged());
        client.close();
    }
}
