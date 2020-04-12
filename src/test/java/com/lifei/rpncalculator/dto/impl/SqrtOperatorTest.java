package com.lifei.rpncalculator.dto.impl;

import com.lifei.rpncalculator.dto.Notation;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

public class SqrtOperatorTest {
    @Test
    public void test() throws Exception {
        SqrtOperator sqrtOperator = new SqrtOperator();

        Deque<Notation> stack = new ArrayDeque<>(Arrays.asList(
                new Decimal15Operand("1.21")
        ));

        Deque<Deque<Notation>> history = new ArrayDeque<>();

        sqrtOperator.handle(stack, history);

        assertThat(stack).hasSize(1);
        assertThat(stack.getFirst().getText()).isEqualTo("1.1");
        assertThat(history).hasSize(1);
        assertThat(history.getFirst()).hasSize(2);
        assertThat(history.getFirst().getFirst().getText()).isEqualTo("sqrt");
        assertThat(history.getFirst().getLast().getText()).isEqualTo("1.21");
    }
}
