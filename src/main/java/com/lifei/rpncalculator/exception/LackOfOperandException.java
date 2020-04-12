package com.lifei.rpncalculator.exception;

public class LackOfOperandException extends CalcException {
    public LackOfOperandException(int code, String msg) {
        super(code, msg);
    }

    public LackOfOperandException(String msg) {
        super(ErrorCode.LACK_OF_OPERAND.getErrorCode(), msg);
    }
}
