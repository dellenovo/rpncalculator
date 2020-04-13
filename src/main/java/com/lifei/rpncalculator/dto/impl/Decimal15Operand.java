package com.lifei.rpncalculator.dto.impl;

import com.lifei.rpncalculator.dto.CalcOperand;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
    public String getText() {
        return val == null ? dummyVal : val.stripTrailingZeros().toPlainString();
    }

    @Override
    public String toString() { return val == null ? dummyVal :
            val.setScale(10, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString();}
}
