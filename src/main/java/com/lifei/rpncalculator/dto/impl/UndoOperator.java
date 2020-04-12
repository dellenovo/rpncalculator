package com.lifei.rpncalculator.dto.impl;

import com.lifei.rpncalculator.dto.CalcOperator;
import com.lifei.rpncalculator.dto.DequeOperator;
import com.lifei.rpncalculator.dto.Notation;
import com.lifei.rpncalculator.exception.CalcException;
import com.lifei.rpncalculator.exception.ErrorCode;
import com.lifei.rpncalculator.util.ExceptionUtils;
import org.springframework.util.CollectionUtils;

import java.util.Deque;
import java.util.List;

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
        stack.poll();

        Deque<Notation> historyItem = history.poll();

        if(CollectionUtils.isEmpty(historyItem)){
            //operand not deriving from a calculation, nothing to do

        } else {
            //put the last RPN back to the stack except the final operand and the operator
            Notation notation = historyItem.poll();
            ExceptionUtils.check(CalcOperator.class.isAssignableFrom(notation.getClass()),
                    new CalcException(ErrorCode.INTERNAL_ERROR));

            CalcOperator calcOperator = (CalcOperator) notation;
            int operandSize = calcOperator.getOperandSize();

            for(int i=0; i<operandSize; i++){
                historyItem.poll();
            }

            stack.addAll(historyItem);
        }
    }
}
