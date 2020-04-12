package com.lifei.rpncalculator.dto.impl;

import com.lifei.rpncalculator.dto.DequeOperator;
import com.lifei.rpncalculator.dto.Notation;

import java.util.Deque;

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
        //todo
    }
}
