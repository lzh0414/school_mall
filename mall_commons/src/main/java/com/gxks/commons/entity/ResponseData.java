package com.gxks.commons.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应内容对象
 * @author Mr.Gao
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData<T> {
    // 响应状态码
    private Integer code;
    // 响应描述
    private String message;
    // 响应数据
    private T data;
}
