package com.lifei.rpncalculator.exception;

public class IllegalNotationException extends CalcException {
    public IllegalNotationException(ErrorCode errorCode, String msg) {
        super(errorCode.getErrorCode(), errorCode.getMsg() + msg);
    }
}
