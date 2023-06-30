package com.mytoken.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.mytoken.pojo.User;
import com.mytoken.service.UserServiceImpl;
import com.mytoken.utils.JWTUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserServiceImpl userService;

    @RequestMapping("/getUser")
    public Map<String,String> getUser(@RequestBody Map<String,String> message){
        System.out.println(message.get("userName")+message.get("password"));
        Map<String,String> map = new HashMap<>();
        User user = userService.queryUserByNameAndPwd(message.get("userName"), message.get("password"));
        if (user==null){
            map.put("msg","用户名或密码错误!");
        }else {
            Map<String,String> payload = new HashMap<>();
            payload.put("id",user.getId().toString());
            payload.put("userName",user.getUserName());
            payload.put("status",user.getStatus().toString());
            String token = JWTUtils.getToken(payload);
            map.put("msg","登录成功!");
            map.put("token",token);
        }
        return map;
    }

    @RequestMapping("/test")
    public Map<String,String> goTest(HttpServletRequest request){
        String token = request.getHeader("token");
        DecodedJWT verify = JWTUtils.verify(token);
        String s = verify.getClaim("userName").asString();
        System.out.println(s);
        String payload = verify.getClaim("id").asString();
        System.out.println(payload);
        Map<String,String> map = new HashMap<>();
        map.put("msg","测试成功!");
        //map.put("verify",verify.toString());
        if (payload.equals("1")){
            map.put("权限","vip");
        }else if (payload.equals("0")){
            map.put("权限","普通会员");
        }else {
            map.put("权限","管理员");
        }
        return map;
    }
}
