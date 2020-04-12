package com.lifei.rpncalculator;

import com.lifei.rpncalculator.dto.Notation;
import com.lifei.rpncalculator.dto.NotationParser;

import java.util.*;

public class RPNCalcEngine extends CalcEngine {
    private Deque<Notation> stack = new ArrayDeque<>();
    private Deque<List<Notation>> calcOperationHistory = new ArrayDeque<>();

    @Override
    protected void calc() {
//        Scanner scanner = new Scanner("12, 42, 78, 99, 42");
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\\s+");
        while(scanner.hasNext()) {
            Notation notation = NotationParser.parse(scanner.next());

            calcOperationHistory.add(Collections.emptyList());
            stack.add(notation);


        }

    }
}
