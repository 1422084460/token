package com.mytoken.es.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * description
 *
 * @author lou
 * @create 2023/6/28
 */
@Data
@Accessors(chain = true)
public class User {

    private String name;
    private Integer age;
    private String sex;
}
