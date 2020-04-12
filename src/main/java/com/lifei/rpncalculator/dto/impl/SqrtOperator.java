package com.lifei.rpncalculator.dto.impl;

import com.lifei.rpncalculator.dto.BigDecimalCalcOperator;
import com.lifei.rpncalculator.exception.LackOfOperandException;
import com.lifei.rpncalculator.exception.NegativeRadicandException;
import com.lifei.rpncalculator.util.ExceptionUtils;

import java.math.BigDecimal;

public class SqrtOperator extends BigDecimalCalcOperator {
    @Override
    public int getOperandSize() {
        return 1;
    }

    @Override
    public BigDecimal operate(BigDecimal... operands) throws Exception {
        ExceptionUtils.check(operands[0] != null, new LackOfOperandException("radicand"));
        ExceptionUtils.check(operands[0].compareTo(BigDecimal.ZERO) > 0, new NegativeRadicandException());
        return new BigDecimal(Math.sqrt(operands[0].doubleValue()));
    }

    @Override
    public String getText() {
        return "sqrt";
    }
}
