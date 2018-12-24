package com.ratel.single.service.impl;

import com.ratel.single.dao.DemoMapper;
import com.ratel.single.pojo.Demo;
import com.ratel.single.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author niexiang
 * @Description
 * @create 2018-03-19 17:56
 **/
@Service
public class DemoServiceImpl implements DemoService {
    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Autowired
    private DemoMapper demoMapper;
    
    
    @Override
    /**
    * 方法说明
    * <p>
    * @param id 
    * @return 
    * @throws 
    * @author  niexiang
    * @version   1.0.0
    * @date  2018/12/24
    */
    public Demo get(Long id){
        Demo demo = demoMapper.get(id);
        logger.info("信息：{}",demo);
        return demo;
    }
    

}