package com.mytoken.es.service;

import com.mytoken.es.LJ.ConnectElasticsearch;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * description
 *
 * @author lou
 * @create 2023/6/28
 */
public class UpdateDoc {

    public static void main(String[] args) {
        ConnectElasticsearch.connect(client -> {
            UpdateRequest request = new UpdateRequest();
            request.index("user").id("1001");
            request.doc(XContentType.JSON,"sex","女");
            UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
            System.out.println("_index:" + response.getIndex());
            System.out.println("_id:" + response.getId());
            System.out.println("_result:" + response.getResult());
        });
    }
}
