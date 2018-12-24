package com.thruman.controller;

import com.thruman.pojo.Demo;
import com.thruman.service.DemoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author niexiang
 * @Description
 * @create 2018-03-12 19:03
 **/

@RestController
public class DemoController {
    @Resource
    private DemoService demoService;


    @PostMapping("/get")
    @ApiOperation(value = "get",tags = "demo")
    public Demo get(@RequestBody Long id){
        return demoService.get(id);
    }




}