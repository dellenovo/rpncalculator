package com.lifei.rpncalculator.dto;

import com.lifei.rpncalculator.dto.impl.Decimal15Operand;

import java.math.BigDecimal;

public abstract class BigDecimalCalcOperator implements CalcOperator<BigDecimal> {
    public CalcOperand<BigDecimal> operate(CalcOperand<BigDecimal>... operands) throws Exception{
        BigDecimal[] bigDecimals = new BigDecimal[operands.length];
        for(int i=0; i< bigDecimals.length; i++){
            bigDecimals[i] = operands[i].getVal();
        }
        return new Decimal15Operand(operate(bigDecimals));
    }

    @Override
    public CalcOperand<BigDecimal> getCalcResultNotation(CalcOperand<BigDecimal>... operands) throws Exception {
        return operate(operands);
    }

    @Override
    public String toString() { return getText();}
}
