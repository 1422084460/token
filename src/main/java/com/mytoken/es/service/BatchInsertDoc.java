package com.mytoken.es.service;

import com.mytoken.es.LJ.ConnectElasticsearch;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * description
 *
 * @author lou
 * @create 2023/6/28
 */
public class BatchInsertDoc {

    public static void main(String[] args) {
//        ConnectElasticsearch.connect(client -> {
//            BulkRequest request = new BulkRequest();
//            request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON,"name","zhangsan"));
//            request.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON,"name","lisi"));
//            request.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON,"name","wangwu"));
//            BulkResponse responses = client.bulk(request, RequestOptions.DEFAULT);
//            System.out.println("took:" + responses.getTook());
//            System.out.println("items:" + responses.getItems());
//        });

//        ConnectElasticsearch.connect(client -> {
//            BulkRequest request = new BulkRequest();
//            request.add(new DeleteRequest().index("user").id("1001"));
//            request.add(new DeleteRequest().index("user").id("1002"));
//            request.add(new DeleteRequest().index("user").id("1003"));
//            client.bulk(request, RequestOptions.DEFAULT);
//        });

        ConnectElasticsearch.connect(client -> {
            BulkRequest request = new BulkRequest();
            request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON, "name", "zhangsan", "age", "10", "sex","女"));
            request.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON, "name", "lisi", "age", "30", "sex","女"));
            request.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON, "name", "wangwu1", "age", "40", "sex","男"));
            request.add(new IndexRequest().index("user").id("1004").source(XContentType.JSON, "name", "wangwu2", "age", "20", "sex","女"));
            request.add(new IndexRequest().index("user").id("1005").source(XContentType.JSON, "name", "wangwu3", "age", "50", "sex","男"));
            request.add(new IndexRequest().index("user").id("1006").source(XContentType.JSON, "name", "wangwu4", "age", "20", "sex","男"));
            //客户端发送请求，获取响应对象
            client.bulk(request, RequestOptions.DEFAULT);
        });
    }
}
