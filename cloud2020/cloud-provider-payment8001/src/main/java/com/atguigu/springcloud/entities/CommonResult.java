package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 空参构造方法
@NoArgsConstructor  // 全参构造方法
public class CommonResult<T> {
    // 404 not_found data
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }
}
