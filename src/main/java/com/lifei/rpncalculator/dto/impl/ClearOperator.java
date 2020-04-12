package com.lifei.rpncalculator.dto.impl;

import com.lifei.rpncalculator.dto.DequeOperator;
import com.lifei.rpncalculator.dto.Notation;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.Deque;

@Component
public class ClearOperator implements DequeOperator {
    @Override
    public void operateDeque(Deque<Notation> stack) {
        stack.clear();
    }

    @Override
    public String getText() {
        return "clear";
    }

    @Override
    public void handle(Deque<Notation> stack, Deque<Deque<Notation>> history) throws Exception {
        Deque<Notation> historyItem2Add = new ArrayDeque<>(stack);
        historyItem2Add.addLast(this);
        history.add(historyItem2Add);
        operateDeque(stack);
    }

    @Override
    public String toString() { return getText();}
}
