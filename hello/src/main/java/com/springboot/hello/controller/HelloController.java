package com.springboot.hello.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping(value = "/request1")
    public String getRequestParam(@RequestParam String name, @RequestParam String email, @RequestParam String password){
        return String.format("%s, %s, %s", name, email, password);
    }
    @GetMapping(value = "/request2")
    public String getRequest2Param(@RequestParam Map<String,String> param){
        param.entrySet().forEach((map)->System.out.printf("key: %s, value: %s\n",map.getKey(),map.getValue()));

        return "Reqest2 finish";
    }
}
