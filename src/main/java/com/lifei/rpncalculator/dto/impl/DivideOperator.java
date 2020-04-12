package com.lifei.rpncalculator.dto.impl;

import com.lifei.rpncalculator.dto.BigDecimalCalcOperator;
import com.lifei.rpncalculator.exception.DividedByZeroException;
import com.lifei.rpncalculator.exception.LackOfOperandException;
import com.lifei.rpncalculator.util.ExceptionUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DivideOperator extends BigDecimalCalcOperator {
    @Override
    public int getOperandSize() {
        return 2;
    }

    @Override
    public BigDecimal operate(BigDecimal... operands) throws Exception {
        ExceptionUtils.check(operands[0] != null, new LackOfOperandException("dividend", this));
        ExceptionUtils.check(operands[1] != null, new LackOfOperandException("divisor", this));
        ExceptionUtils.check(operands[1].compareTo(BigDecimal.ZERO) != 0, new DividedByZeroException());

        return operands[0].divide(operands[1]);
    }

    @Override
    public String getText() {
        return "/";
    }
}
