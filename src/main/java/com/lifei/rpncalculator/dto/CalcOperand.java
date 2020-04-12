package com.lifei.rpncalculator.dto;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public interface CalcOperand<T> extends Notation {
    String dummyVal = "Number";
    Deque<Notation> emptyDeque = new ArrayDeque<Notation>();

    T getVal();

    void setVal(T val);

    default void handle(Deque<Notation> stack, Deque<Deque<Notation>> history){
        stack.addLast(this);
        history.addLast(emptyDeque);// a placeholder
    }
}
