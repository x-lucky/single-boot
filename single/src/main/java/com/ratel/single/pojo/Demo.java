package com.ratel.single.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author niexiang
 * @Description
 * @create 2018-03-19 19:16
 **/
@ApiModel(value = "demo")
public class Demo {

    @ApiModelProperty(value = "id")
    private int id;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                '}';
    }
}