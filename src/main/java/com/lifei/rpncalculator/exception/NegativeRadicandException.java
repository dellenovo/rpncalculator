package com.lifei.rpncalculator.exception;

public class NegativeRadicandException extends CalcException {
    public NegativeRadicandException(int code, String msg) {
        super(code, msg);
    }

    public NegativeRadicandException() {
        super(ErrorCode.NEGATIVE_RADICAND.getErrorCode(), ErrorCode.NEGATIVE_RADICAND.getMsg());
    }
}
