package com.bzdnet.community.handler;

import com.bzdnet.community.exception.UnAuthException;
import com.bzdnet.community.exception.UnLoginException;
import com.bzdnet.community.vo.ResultVO;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnLoginException.class)
    public ResultVO handleCustomException(UnLoginException ce) {
        return new ResultVO(401, ce.getType() == 1 ? "登录超时，请重新登录" : "请先登录");
    }

    @ExceptionHandler(UnAuthException.class)
    public ResultVO handleCustomException(UnAuthException ce) {
        return new ResultVO(403, "没有访问权限");
    }

    @ExceptionHandler({BindException.class, ConstraintViolationException.class, MethodArgumentNotValidException.class})
    public ResultVO handleValidException(Exception ex) {
        ex.printStackTrace();
        return new ResultVO(100, "参数格式不正确");
    }

    @ExceptionHandler(Exception.class)
    public ResultVO handleGlobalError(Exception ex) {
        ex.printStackTrace();
        return new ResultVO(500, "服务器异常，请稍后再试");
    }

}
