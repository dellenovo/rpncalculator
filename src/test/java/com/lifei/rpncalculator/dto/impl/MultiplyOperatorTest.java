package com.lifei.rpncalculator.dto.impl;

import com.lifei.rpncalculator.dto.Notation;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplyOperatorTest {
    @Test
    public void test() throws Exception {
        MultiplyOperator multiplyOperator = new MultiplyOperator();

        Deque<Notation> stack = new ArrayDeque<>(Arrays.asList(
                new Decimal15Operand("-3.1"),
                new Decimal15Operand("2")
        ));

        Deque<Deque<Notation>> history = new ArrayDeque<>();

        multiplyOperator.handle(stack, history);

        assertThat(stack).hasSize(1);
        assertThat(stack.getFirst().getText()).isEqualTo("-6.2");
        assertThat(history).hasSize(1);
        assertThat(history.getFirst()).hasSize(3);
        assertThat(history.getFirst().getFirst().getText()).isEqualTo("-3.1");
        assertThat(history.getFirst().getLast().getText()).isEqualTo("*");
    }
}
