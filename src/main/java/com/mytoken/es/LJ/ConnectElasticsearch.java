package com.mytoken.es.LJ;

import com.mytoken.es.JK.ElasticsearchTask;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * description
 *
 * @author lou
 * @create 2023/6/28
 */
public class ConnectElasticsearch {

    public static void connect(ElasticsearchTask task){

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );
        try {
            task.doSomething(client);
            client.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
