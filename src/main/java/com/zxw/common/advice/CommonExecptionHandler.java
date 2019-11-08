package com.zxw.common.advice;

import com.zxw.common.exception.JwException;
import com.zxw.common.pojo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author zxw
 * @date 2019/11/8 21:44
 */
@ControllerAdvice
public class CommonExecptionHandler {

    @ExceptionHandler(JwException.class)
    public ResponseEntity<ExceptionResult> handlerExecption(JwException e) {
        return ResponseEntity.status(e.getExceptionEnums().getCode()).body(new ExceptionResult(e.getExceptionEnums()));
    }
}
