package com.lifei.rpncalculator.dto;

import java.util.Deque;

public interface Notation {
    String getText();

    void handle(Deque<Notation> stack, Deque<Deque<Notation>> history) throws Exception;
}
