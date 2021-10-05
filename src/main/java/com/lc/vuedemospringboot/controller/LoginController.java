package com.lc.vuedemospringboot.controller;

import com.lc.vuedemospringboot.pojo.User;
import com.lc.vuedemospringboot.utils.Result;
import com.lc.vuedemospringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @RequestMapping("api/login")
    @ResponseBody
    public Result login(@RequestBody User user,HttpSession session){

        User byUsernameAndPassword = userService.getByUsernameAndPassword(user.getUsername(), user.getPassword());

        if (byUsernameAndPassword!=null){
            session.setAttribute("user",byUsernameAndPassword);
            return new Result(200);
        }else {
            return new Result(400);
        }

    }


}
