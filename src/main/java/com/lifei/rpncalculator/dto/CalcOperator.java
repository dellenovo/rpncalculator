package com.lifei.rpncalculator.dto;

import com.lifei.rpncalculator.exception.LackOfOperandException;
import com.lifei.rpncalculator.util.ExceptionUtils;

import java.util.*;

public interface CalcOperator<N> extends Notation{
    int getOperandSize();
    N operate(N... operands) throws Exception;
    CalcOperand<N> operate(CalcOperand<N>... operands) throws Exception;
    Notation getCalcResultNotation(CalcOperand<N>... operands) throws Exception;

    default void handle(Deque<Notation> stack, Deque<Deque<Notation>> history) throws Exception {
        int operandSize = getOperandSize();
        CalcOperand[] operands =  new CalcOperand[operandSize];


        //the order in the historyItem is as same as in the stack
        Deque<Notation> historyItem = new ArrayDeque<>();

        // get operands but do not remove elements from the stack in case of lacking of operands
        for(int i=operandSize - 1; i>= 0; i--){
            Notation prevNotation = stack.peekLast();

            ExceptionUtils.check(prevNotation != null && CalcOperand.class.isAssignableFrom(prevNotation.getClass()),
                    new LackOfOperandException(getText(), this));

            operands[i] = (CalcOperand)prevNotation;
            historyItem.addFirst(stack.removeLast());
        }

        historyItem.addLast(this);

        stack.add(getCalcResultNotation(operands));

        history.add(historyItem);
    }
}
