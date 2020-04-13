package com.lifei.rpncalculator.dto.impl;

import com.lifei.rpncalculator.dto.CalcOperator;
import com.lifei.rpncalculator.dto.DequeOperator;
import com.lifei.rpncalculator.dto.Notation;
import com.lifei.rpncalculator.exception.CalcException;
import com.lifei.rpncalculator.exception.ErrorCode;
import com.lifei.rpncalculator.util.ExceptionUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Deque;

@Component
public class UndoOperator implements DequeOperator {

    @Override
    public String getText() {
        return "undo";
    }

    @Override
    public void handle(Deque<Notation> stack, Deque<Deque<Notation>> history) throws Exception {
        stack.pollLast();

        Deque<Notation> historyItem = history.pollLast();

        if(!CollectionUtils.isEmpty(historyItem)){
            //remove the operator
            historyItem.pollLast();
        }

        stack.addAll(historyItem);
    }

    @Override
    public String toString() { return getText();}
}
