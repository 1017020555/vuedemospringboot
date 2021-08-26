package com.lc.vuedemospringboot.controller;

import com.lc.vuedemospringboot.pojo.User;
import com.lc.vuedemospringboot.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @CrossOrigin
    @RequestMapping("api/login")
    @ResponseBody
    public Result login(@RequestBody User user){

        System.out.println(user.getUsername()+"::"+user.getPassword());

        if ("admin".equals(user.getUsername()) && "123".equals(user.getPassword())){
            return new Result(200);
        }else {
            return new Result(400);
        }

    }


}
