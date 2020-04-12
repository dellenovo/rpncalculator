package com.lifei.rpncalculator.dto.impl;

import com.lifei.rpncalculator.dto.CalcOperand;
import com.lifei.rpncalculator.dto.Notation;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Deque;

@Component
@NoArgsConstructor
public class Decimal15Operand implements CalcOperand<BigDecimal> {

    private BigDecimal val;

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
    public String getText() {
        return val == null ? dummyVal : val.stripTrailingZeros().toPlainString();
    }

    @Override
    public String toString() { return val == null ? dummyVal :
            val.setScale(10, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString();}
}
