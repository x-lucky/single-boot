package com.ratel.single.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(
    description = "响应结果"
)
@JsonInclude(Include.NON_NULL)
public class RestResult<T> implements Serializable {
    @ApiModelProperty(
        notes = "状态码；200：成功， 非200：失败"
    )
    protected int code;
    @ApiModelProperty(
        notes = "响应消息"
    )
    protected String message;
    @ApiModelProperty(
        notes = "时间戳"
    )
    protected Long timestamp;
    @ApiModelProperty(
        notes = "返回数据"
    )
    protected T data;

    public RestResult(T data) {
        this.code = ResultCodeEnum.OK.getCode();
        this.message = ResultCodeEnum.OK.getMessage();
        this.timestamp = System.currentTimeMillis();
        this.data = data;
    }

    public RestResult() {
        this.code = ResultCodeEnum.OK.getCode();
        this.message = ResultCodeEnum.OK.getMessage();
        this.timestamp = System.currentTimeMillis();
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public RestResult<T> code(int code) {
        this.code = code;
        return this;
    }

    public RestResult<T> message(String message) {
        this.message = message;
        return this;
    }

    public RestResult<T> putTimestamp() {
        this.timestamp = System.currentTimeMillis();
        return this;
    }

    public RestResult<T> data(T data) {
        this.data = data;
        return this;
    }

}