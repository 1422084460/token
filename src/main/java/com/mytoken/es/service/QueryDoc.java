package com.mytoken.es.service;

import com.mytoken.es.LJ.ConnectElasticsearch;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.query.TermsQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;

import java.util.Map;

/**
 * description
 *
 * @author lou
 * @create 2023/6/28
 */
public class QueryDoc {

    public static void main(String[] args) {
//        ConnectElasticsearch.connect(client -> {
//            SearchRequest request = new SearchRequest();
//            request.indices("user");
//            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//            sourceBuilder.query(QueryBuilders.matchAllQuery());
//            request.source(sourceBuilder);
//            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//            SearchHits hits = response.getHits();
//            for (SearchHit hit : hits) {
//                //输出每条查询的结果信息
//                System.out.println(hit.getSourceAsString());
//            }
//        });

//        ConnectElasticsearch.connect(client -> {
//            SearchRequest request = new SearchRequest();
//            request.indices("user");
//            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//            sourceBuilder.query(QueryBuilders.termQuery("age", "30"));
//            request.source(sourceBuilder);
//            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//            SearchHits hits = response.getHits();
//            for (SearchHit hit : hits) {
//                System.out.println(hit.getSourceAsString());
//            }
//        });

//        ConnectElasticsearch.connect(client -> {
//            SearchRequest request = new SearchRequest();
//            request.indices("user");
//            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//            sourceBuilder.query(QueryBuilders.matchAllQuery());
//            sourceBuilder.from(0);
//            sourceBuilder.size(2);
//            request.source(sourceBuilder);
//            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//            SearchHits hits = response.getHits();
//            for (SearchHit hit : hits) {
//                System.out.println(hit.getSourceAsString());
//            }
//        });

//        ConnectElasticsearch.connect(client -> {
//            SearchRequest request = new SearchRequest();
//            request.indices("user");
//            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//            sourceBuilder.query(QueryBuilders.matchAllQuery());
//            sourceBuilder.sort("age", SortOrder.DESC);
//            request.source(sourceBuilder);
//            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//            SearchHits hits = response.getHits();
//            for (SearchHit hit : hits) {
//                System.out.println(hit.getSourceAsString());
//            }
//        });

//        ConnectElasticsearch.connect(client -> {
//            SearchRequest request = new SearchRequest();
//            request.indices("user");
//            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//            //boolQueryBuilder.must(QueryBuilders.matchQuery("age","30"));
//            boolQueryBuilder.should(QueryBuilders.matchQuery("name","zhangsan"));
//            boolQueryBuilder.should(QueryBuilders.matchQuery("name","lisi"));
//            sourceBuilder.query(boolQueryBuilder);
//            request.source(sourceBuilder);
//            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//            SearchHits hits = response.getHits();
//            for (SearchHit hit : hits) {
//                System.out.println(hit.getSourceAsString());
//            }
//        });

//        ConnectElasticsearch.connect(client -> {
//            SearchRequest request = new SearchRequest();
//            request.indices("user");
//            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//            sourceBuilder.query(QueryBuilders.fuzzyQuery("name","wangwu").fuzziness(Fuzziness.ONE));
//            request.source(sourceBuilder);
//            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//            SearchHits hits = response.getHits();
//            for (SearchHit hit : hits) {
//                System.out.println(hit.getSourceAsString());
//            }
//        });

        ConnectElasticsearch.connect(client -> {
            SearchRequest request = new SearchRequest();
            request.indices("user");
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery("name","zhangsan");
            sourceBuilder.query(termsQueryBuilder);
            HighlightBuilder highlightBuilder = new HighlightBuilder();
            highlightBuilder.preTags("<font color='red'>");
            highlightBuilder.postTags("</font>");
            highlightBuilder.field("name");
            sourceBuilder.highlighter(highlightBuilder);
            request.source(sourceBuilder);
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            SearchHits hits = response.getHits();
            for (SearchHit hit : hits) {
                System.out.println(hit.getSourceAsString());
                Map<String, HighlightField> fields = hit.getHighlightFields();
                System.out.println(fields);
            }
        });
    }
}
