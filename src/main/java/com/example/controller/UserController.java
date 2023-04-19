package com.example.controller;



import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.dao.UserDao;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/getOne")
    public User getOne(@PathParam("id") Integer id){
        return userDao.selectById(id);
    }
}
