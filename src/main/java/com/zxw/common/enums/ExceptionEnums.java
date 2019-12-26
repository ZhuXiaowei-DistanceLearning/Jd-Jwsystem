package com.zxw.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author zxw
 * @date 2019/11/8 21:42
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnums {
    NO_DATA(400, "验证码错误")
    ;
    private Integer code;
    private String msg;

    }
