package com.imooc.oa.service.exception;

/**
 * @Author Tianhao Tao
 * @Date 2020/9/2 14:26
 * @Version 1.0
 */
public class BussinessException extends RuntimeException{
    private String code;//异常编码
    private String message;//异常描述
    public BussinessException(String code,String message){
        super(code + ":" + message);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
