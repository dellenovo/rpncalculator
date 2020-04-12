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
    public void operateDeque(Deque<Notation> stack) {

    }

    @Override
    public String getText() {
        return "undo";
    }

    @Override
    public void handle(Deque<Notation> stack, Deque<Deque<Notation>> history) throws Exception {
        stack.pollLast();

        Deque<Notation> historyItem = history.pollLast();

        if(CollectionUtils.isEmpty(historyItem)){
            //operand not deriving from a calculation, nothing to do

        } else {
            //put the last RPN back to the stack except the final operand and the operator
            Notation notation = historyItem.pollLast();
//            ExceptionUtils.check(CalcOperator.class.isAssignableFrom(notation.getClass()),
//                    new CalcException(ErrorCode.INTERNAL_ERROR));
        }
        stack.addAll(historyItem);
    }

    @Override
    public String toString() { return getText();}
}
