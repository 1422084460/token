package com.mytoken;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.mytoken.utils.JWTUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MytokenApplicationTests {

    String token =null;

    @Test
    void contextLoads() {
        Map map = new HashMap();
        map.put("aaa","bbb");
        token = JWTUtils.getToken(map);
        System.out.println(token);
    }

    @Test
    void contextLoad() {
        DecodedJWT verify = JWTUtils.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhYWEiOiJiYmIiLCJleHAiOjE2MzY3MDQzMDR9._ZTnzgA4G8p_IFPrmSmWQvlm3VR32i7KElCkpdBWTog");
        System.out.println(verify.getClaim("aaa").asString());
        System.out.println(verify.getHeader());
    }

}
