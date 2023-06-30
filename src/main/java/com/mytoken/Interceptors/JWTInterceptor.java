package com.mytoken.Interceptors;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mytoken.utils.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String,String> map = new HashMap();
        String token = request.getHeader("token");
        System.out.println(token);
        try {
            JWTUtils.verify(token);
            System.out.println("验证通过");
            return true;
        }catch (SignatureVerificationException e){
            e.printStackTrace();
            map.put("msg","签名无效");
        }catch (TokenExpiredException e){
            e.printStackTrace();
            map.put("msg","token过期");
        }catch (AlgorithmMismatchException e){
            e.printStackTrace();
            map.put("msg","token算法不一致");
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg","token无效");
        }
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=utf-8");
        return false;
    }
}
