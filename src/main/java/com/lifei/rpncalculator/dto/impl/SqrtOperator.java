package com.lifei.rpncalculator.dto.impl;

import com.lifei.rpncalculator.dto.BigDecimalCalcOperator;
import com.lifei.rpncalculator.exception.LackOfOperandException;
import com.lifei.rpncalculator.exception.NegativeRadicandException;
import com.lifei.rpncalculator.util.ExceptionUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;

@Component
public class SqrtOperator extends BigDecimalCalcOperator {
    @Override
    public int getOperandSize() {
        return 1;
    }

    @Override
    public BigDecimal operate(BigDecimal... operands) throws Exception {
        ExceptionUtils.check(operands[0] != null, new LackOfOperandException("radicand", this));
        ExceptionUtils.check(operands[0].compareTo(BigDecimal.ZERO) > 0, new NegativeRadicandException());
        return new BigDecimal(Math.sqrt(operands[0].doubleValue()), MathContext.DECIMAL64).stripTrailingZeros();
    }

    @Override
    public String getText() {
        return "sqrt";
    }
}
