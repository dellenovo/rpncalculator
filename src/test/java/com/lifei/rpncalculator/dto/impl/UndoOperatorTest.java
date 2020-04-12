package com.lifei.rpncalculator.dto.impl;

import com.lifei.rpncalculator.dto.Notation;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

public class UndoOperatorTest {
    @Test
    public void test() throws Exception {
        Deque<Notation> stack = new ArrayDeque<>(Arrays.asList(
                new Decimal15Operand("12")
        ));

        Deque<Deque<Notation>> history = new ArrayDeque<>();
        Deque<Notation> historyItem = new ArrayDeque<>(Arrays.asList(
                new Decimal15Operand("6"),
                new Decimal15Operand("0.5"),
                new DivideOperator()
        ));
        history.add(historyItem);

        UndoOperator undoOperator = new UndoOperator();
        undoOperator.handle(stack, history);

        assertThat(stack).hasSize(1);
        assertThat(stack.getFirst().getText()).isEqualTo("6");
        assertThat(history).isEmpty();
    }
}
