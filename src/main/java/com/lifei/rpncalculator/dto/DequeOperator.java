package com.lifei.rpncalculator.dto;

import java.util.Deque;

public interface DequeOperator extends Notation {
    default void operateDeque(Deque<Notation> stack){}
}
