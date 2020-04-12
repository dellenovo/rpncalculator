package com.lifei.rpncalculator.exception;

public class DividedByZeroException extends CalcException {
    public DividedByZeroException(int code, String msg) {
        super(code, msg);
    }

    public DividedByZeroException() {
        super(ErrorCode.DIVIDED_BY_ZERO.getErrorCode(), ErrorCode.DIVIDED_BY_ZERO.getMsg());
    }
}
