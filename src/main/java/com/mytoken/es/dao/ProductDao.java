package com.mytoken.es.dao;

import com.mytoken.es.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * description
 *
 * @author lou
 * @create 2023/6/28
 */
@Repository
public interface ProductDao extends ElasticsearchRepository<Product,Long> {
}
