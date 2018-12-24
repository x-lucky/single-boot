package com.ratel.single.controller;

import com.ratel.single.exception.BusinessException;
import com.ratel.single.pojo.Demo;
import com.ratel.single.pojo.RestResult;
import com.ratel.single.service.DemoService;
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


    @PostMapping("/exc")
    @ApiOperation(value = "exc",tags = "demo")
    public RestResult exc(@RequestBody Long id){
        if (id != null){
            throw new BusinessException(1000);
        }
        return new RestResult().data(id);
    }


}