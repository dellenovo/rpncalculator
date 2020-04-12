package com.lifei.rpncalculator.dto.impl;

import com.lifei.rpncalculator.dto.BigDecimalCalcOperator;
import com.lifei.rpncalculator.exception.LackOfOperandException;
import com.lifei.rpncalculator.util.ExceptionUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AddOperator extends BigDecimalCalcOperator {
    @Override
    public int getOperandSize() {
        return 2;
    }

    @Override
    public BigDecimal operate(BigDecimal... operands) throws Exception {

        ExceptionUtils.check(operands[0] != null, new LackOfOperandException("augend", this));
        ExceptionUtils.check(operands[1] != null, new LackOfOperandException("addend", this));

        return operands[0].add(operands[1]);
    }

    @Override
    public String getText() {
        return "+";
    }
}
