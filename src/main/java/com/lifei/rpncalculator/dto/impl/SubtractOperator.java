package com.lifei.rpncalculator.dto.impl;

import com.lifei.rpncalculator.dto.BigDecimalCalcOperator;
import com.lifei.rpncalculator.exception.LackOfOperandException;
import com.lifei.rpncalculator.util.ExceptionUtils;

import java.math.BigDecimal;

public class SubtractOperator extends BigDecimalCalcOperator {
    @Override
    public int getOperandSize() {
        return 2;
    }

    @Override
    public BigDecimal operate(BigDecimal... operands) throws Exception {
        ExceptionUtils.check(operands[0] != null, new LackOfOperandException("minuend"));
        ExceptionUtils.check(operands[1] != null, new LackOfOperandException("subtrahend"));

        return operands[0].subtract(operands[1]);
    }

    @Override
    public String getText() {
        return "-";
    }
}
