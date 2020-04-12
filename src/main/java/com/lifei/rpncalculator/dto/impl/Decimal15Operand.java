package com.lifei.rpncalculator.dto.impl;

import com.lifei.rpncalculator.dto.CalcOperand;
import com.lifei.rpncalculator.dto.Notation;

import java.math.BigDecimal;
import java.util.Deque;

public class Decimal15Operand implements CalcOperand<BigDecimal> {

    private BigDecimal val;

    public Decimal15Operand(){};

    public Decimal15Operand(String val) {
        this.val = new BigDecimal(val);
    }

    public Decimal15Operand(BigDecimal val) {
        this.val = val;
    }

    @Override
    public BigDecimal getVal() {
        return val;
    }

    @Override
    public void setVal(BigDecimal val) {
        this.val = val;
        return;
    }


    @Override
    public void handle(Deque<Notation> stack, Deque<Deque<Notation>> history) {

    }

    @Override
    public String getText() {
        return val.stripTrailingZeros().toPlainString();
    }
}
