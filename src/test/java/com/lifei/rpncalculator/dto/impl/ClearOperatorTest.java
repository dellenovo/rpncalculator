package com.lifei.rpncalculator.dto.impl;

import com.lifei.rpncalculator.dto.Notation;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

public class ClearOperatorTest {
    @Test
    public void test() throws Exception {
        ClearOperator clearOperator = new ClearOperator();
        Deque<Notation> stack = new ArrayDeque<>(Arrays.asList(
                new Decimal15Operand("1"),
                new Decimal15Operand("2")
        ));

        Deque<Deque<Notation>> history = new ArrayDeque<>();

        clearOperator.handle(stack, history);

        assertThat(stack).isEmpty();
        assertThat(history).isNotEmpty();
        assertThat(history.getFirst()).isNotEmpty();
    }
}
