package com.lifei.rpncalculator.dto.impl;

import com.google.common.collect.Lists;
import com.lifei.rpncalculator.dto.Notation;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

public class AddOperatorTest {
    private AddOperator addOperator = new AddOperator();

    @Test
    public void test() throws Exception {
        assertThat(addOperator.getOperandSize()).isEqualTo(2);

        assertThat(addOperator.getText()).isEqualTo("+");

        assertThat(addOperator.operate(new BigDecimal("3.2"), new BigDecimal(-1), new BigDecimal(1)))
                .isEqualByComparingTo(new BigDecimal("2.2"));

        Deque<Notation> stack = new ArrayDeque<>(Arrays.asList(
                new Decimal15Operand("1"),
                new Decimal15Operand("2")//,
//                addOperator
        ));

        Deque<Deque<Notation>> history = new ArrayDeque<>();
        history.add(stack);

        addOperator.handle(stack, history);

        assertThat(stack).hasSize(1);
        assertThat(stack.getFirst().getText()).isEqualTo("3");
    }
}
