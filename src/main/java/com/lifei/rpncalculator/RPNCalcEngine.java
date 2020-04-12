package com.lifei.rpncalculator;

import com.google.common.base.Splitter;
import com.lifei.rpncalculator.dto.CalcOperand;
import com.lifei.rpncalculator.dto.CalcOperator;
import com.lifei.rpncalculator.dto.Notation;
import com.lifei.rpncalculator.dto.NotationParser;
import com.lifei.rpncalculator.exception.CalcException;
import com.lifei.rpncalculator.exception.LackOfOperandException;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.regex.Pattern;

@Service
@Setter
public class RPNCalcEngine extends CalcEngine {
    @Resource
    private NotationParser notationParser;
    private Deque<Notation> stack = new ArrayDeque<>();
    private Deque<Deque<Notation>> calcOperationHistory = new ArrayDeque<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    protected void calc() {
//        Scanner scanner = new Scanner("12, 42, 78, 99, 42");

//        scanner.useDelimiter("\\s+");
//        while (true) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int i = 0;
            for (String input : Splitter.on(Pattern.compile("\\s+")).omitEmptyStrings().splitToList(line)) {
                i = line.indexOf(input, i);

                try {
                    Notation notation = notationParser.parse(input);
                    notation.handle(stack, calcOperationHistory);
                } catch (LackOfOperandException loe) {
                    System.out.println(String.format("operator %s (position: %d): insucient parameters",
                            loe.getOperator().getText(), i + 1));

                    //restore previous result from history
                    Deque<Notation> historyItem = calcOperationHistory.pollLast();
                    CalcOperator calcOperator = ((CalcOperator)(historyItem.pollLast()));
                    CalcOperand[] calcOperands = new CalcOperand[calcOperator.getOperandSize()];
                    for(int j=0; j< calcOperator.getOperandSize(); j++) {
                        calcOperands[j] = (CalcOperand)historyItem.pollFirst();
                    }
                    try {
                        stack.addLast(calcOperator.getCalcResultNotation(calcOperands));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                } catch (CalcException ce) {
                    System.out.println(ce.getMessage());
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }

                i += input.length();
            }

            System.out.print("stack:");
            stack.forEach(s -> System.out.print(s + " "));
            System.out.println();
        }
//        }

    }
}
