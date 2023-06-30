package com.mytoken.es;

import com.mytoken.es.dao.ProductDao;
import com.mytoken.es.model.Product;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author lou
 * @create 2023/6/28
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringDataESIndexTest {

    @Autowired
    private ElasticsearchRestTemplate template;

    @Autowired
    private ProductDao productDao;

    @Test
    public void createIndex(){
        //创建索引，系统初始化会自动创建索引
        System.out.println("创建索引");
    }

    @Test
    public void save(){
        Product product = new Product();
        //product.setId(2L);
        product.setTitle("华为手机");
        product.setCategory("手机");
        product.setPrice(2999.0);
        product.setImages("http://www.atguigu/hw.jpg");
        productDao.save(product);
    }

    @Test
    public void delete(){
        Product product = new Product();
        //product.setId(2L);
        productDao.delete(product);
    }

    @Test
    public void update(){
        Product product = new Product();
        //product.setId(2L);
        product.setTitle("华为手机nb");
        product.setCategory("手机");
        product.setPrice(2999.0);
        product.setImages("http://www.atguigu/hw.jpg");
        productDao.save(product);
    }

    @Test
    public void findById(){
        Product product = productDao.findById(2L).get();
        System.out.println(product.toString());//productDao.findAll() productDao.saveAll()
    }

    @Test
    public void saveAll(){
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            //product.setId(Long.valueOf(i));
            product.setTitle("["+i+"]小米手机");
            product.setCategory("手机");
            product.setPrice(1999.0 + i);
            product.setImages("http://www.atguigu/xm.jpg");
            productList.add(product);
        }
        productDao.saveAll(productList);
    }

    //分页查询
    @Test
    public void findByPageable(){
        //设置排序(排序方式，正序还是倒序，排序的 id)
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        int currentPage = 1;//当前页，第一页从 0 开始， 1 表示第二页
        int pageSize = 3;//每页显示多少条
        //设置查询分页
        PageRequest pageRequest = PageRequest.of(currentPage, pageSize, sort);
        //分页查询
        Page<Product> productPage = productDao.findAll(pageRequest);
        for (Product Product : productPage.getContent()) {
            System.out.println(Product);
        }
    }

    @Test
    public void termQuery(){
        TermQueryBuilder builder = QueryBuilders.termQuery("title", "小米");
        Iterable<Product> search = productDao.search(builder);
        for (Product product : search) {
            System.out.println(product);
        }
    }

    @Test
    public void saveAll2(){
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            //product.setId(Long.valueOf(i));
            product.setTitle("["+i+"]小米手机");
            product.setCategory("手机");
            product.setPrice(1999.0 + i);
            product.setImages("http://www.atguigu/xm.jpg");
            productList.add(product);
        }
        productDao.saveAll(productList);
    }

}
