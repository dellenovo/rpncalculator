package com.lifei.rpncalculator.exception;

public class CalcException extends Exception{
    private int code;
    private String msg;

    public CalcException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public CalcException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getErrorCode();
        this.msg = errorCode.getMsg();
    }
}
