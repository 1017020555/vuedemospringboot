package com.lc.vuedemospringboot.controller;

import com.lc.vuedemospringboot.pojo.User;
import com.lc.vuedemospringboot.result.Result;
import com.lc.vuedemospringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @RequestMapping("api/login")
    @ResponseBody
    public Result login(@RequestBody User user){

        User byUsernameAndPassword = userService.getByUsernameAndPassword(user.getUsername(), user.getPassword());

        if (byUsernameAndPassword!=null){
            return new Result(200);
        }else {
            return new Result(400);
        }

    }


}
