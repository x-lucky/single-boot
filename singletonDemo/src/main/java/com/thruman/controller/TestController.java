package com.thruman.controller;

import com.thruman.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author niexiang
 * @Description
 * @create 2018-03-12 19:03
 **/
@RestController
public class TestController {
    @Resource
    private TestService testService;

    @RequestMapping("/")
    public String sayHello() {
        return "Hello,World!";
    }


    @GetMapping("/sleep")
    public String sleep() {
        return "成功";
    }



}