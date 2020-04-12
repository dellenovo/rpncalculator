package com.lifei.rpncalculator.dto.impl;

import com.lifei.rpncalculator.dto.Notation;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

public class DivideOperatorTest {
    @Test
    public void test() throws Exception {
        DivideOperator divideOperator = new DivideOperator();

        Deque<Notation> stack = new ArrayDeque<>(Arrays.asList(
                new Decimal15Operand("1"),
                new Decimal15Operand("2")
        ));

        Deque<Deque<Notation>> history = new ArrayDeque<>();

        divideOperator.handle(stack, history);

        assertThat(stack).hasSize(1);
        assertThat(stack.getFirst().getText()).isEqualTo("0.5");
        assertThat(history).hasSize(1);
        assertThat(history.getFirst()).hasSize(3);
        assertThat(history.getFirst().getFirst().getText()).isEqualTo("/");
        assertThat(history.getFirst().getLast().getText()).isEqualTo("2");
    }
}
