package com.example.controller;


import com.cjw.test.utils.RandomUtil;
import com.example.service.MSGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/JWTTest")
public class MSGController {

    @Autowired
    private MSGService jwtService;


    @GetMapping("send/{phone}/interAspect")
    public void sendMsm(@PathVariable String phone){
        //生成随机数
        String code = RandomUtil.getFourBitRandom();
        Map map = new HashMap();
        map.put("code",code);
        boolean b = jwtService.send(map,phone);
    }
}

