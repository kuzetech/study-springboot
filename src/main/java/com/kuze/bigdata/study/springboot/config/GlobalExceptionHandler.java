package com.kuze.bigdata.study.springboot.config;

import com.kuze.bigdata.study.springboot.domain.ResultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public static final int SUCCESS_CODE = 200;
    private static final int ERROR_CODE_ARGUMENT_VALID = 411;
    private static final int ERROR_CODE_SERVER = 500;

    /**
     * 验证异常
     * @param req
     * @param e
     * @return
     * @throws MethodArgumentNotValidException
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultResponse handleMethodArgumentNotValidException(HttpServletRequest req, MethodArgumentNotValidException e) throws MethodArgumentNotValidException {
        ResultResponse r = new ResultResponse();
        BindingResult bindingResult = e.getBindingResult();
        String errorMesssage = "Invalid Request: ";

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMesssage += fieldError.getField() + " ";
            errorMesssage += fieldError.getDefaultMessage();
        }
        r.setCode(ERROR_CODE_ARGUMENT_VALID);
        r.setMessage(errorMesssage);
        //logger.info("MethodArgumentNotValidException",e);
        return r;
    }

    /**
     * 全局异常
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultResponse handleException(HttpServletRequest req, Exception e) throws Exception {
        ResultResponse r = new ResultResponse();
        r.setCode(ERROR_CODE_SERVER);
        r.setMessage(e.getMessage());
        logger.error(e.getMessage(),e);
        return r;
    }
}
