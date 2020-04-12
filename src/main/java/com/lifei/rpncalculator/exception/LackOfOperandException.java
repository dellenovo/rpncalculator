package com.lifei.rpncalculator.exception;

import com.lifei.rpncalculator.dto.CalcOperator;

public class LackOfOperandException extends CalcException {
    private CalcOperator calcOperator;

    public LackOfOperandException(int code, String msg, CalcOperator calcOperator) {
        super(code, msg);
        this.calcOperator = calcOperator;
    }

    public LackOfOperandException(String msg, CalcOperator calcOperator) {
        super(ErrorCode.LACK_OF_OPERAND.getErrorCode(), ErrorCode.LACK_OF_OPERAND.getMsg() + msg);
        this.calcOperator = calcOperator;
    }

    public CalcOperator getOperator() {
        return calcOperator;
    }
}
