package com.kuze.bigdata.study.springboot.domain;

import com.kuze.bigdata.study.springboot.config.GlobalExceptionHandler;

public class ResultResponse {

    public static ResultResponse generateSuccessRes(){
        ResultResponse response = new ResultResponse();
        response.setCode(GlobalExceptionHandler.SUCCESS_CODE);
        response.setMessage("success");
        return response;
    }

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
