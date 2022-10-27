package com.springboot.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
//    public String getVariable2(@PathVariable("variable") String var){
//        return var;
//    }
    @GetMapping(value = "/request1")
    public String getRequestParam(@RequestParam String name, @RequestParam String email, @RequestParam String password){
        return String.format("%s, %s, %s", name, email, password);
    }
}
