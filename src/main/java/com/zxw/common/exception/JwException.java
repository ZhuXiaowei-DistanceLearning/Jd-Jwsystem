package com.zxw.common.exception;

import com.zxw.common.enums.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author zxw
 * @date 2019/11/8 21:43
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class JwException extends RuntimeException {
    private ExceptionEnums exceptionEnums;
}
