package com.ratel.single.dao;

import com.ratel.single.pojo.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 类
 * <p>
 *
 * @author niexiang
 * @version 1.0.0
 * @date 2018/12/24
 */
@Mapper
public interface DemoMapper {


    /**
     * getById
     * @param id
     * @return
     */
    @Select("select * from product where id = #{id}")
    Demo get(@Param("id") Long id);

}
