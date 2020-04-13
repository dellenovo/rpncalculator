package com.lifei.rpncalculator;

import com.lifei.rpncalculator.dto.Notation;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class RPNCalcEngineTest extends RpncalculatorApplicationTests {
    @Resource
    private RPNCalcEngine rpnCalcEngine;
    private Scanner systemInScanner = new Scanner(System.in);

    @Test
    public void testAdd() {
        Deque<Notation> stack = new ArrayDeque<>();
        Deque<Deque<Notation>> calcOperationHistory = new ArrayDeque<>();
        Scanner scanner = new Scanner("1 2 +");

        try{
            rpnCalcEngine.setScanner(scanner);
            rpnCalcEngine.setStack(stack);
            rpnCalcEngine.setCalcOperationHistory(calcOperationHistory);

            rpnCalcEngine.calc();

            assertThat(stack).hasSize(1);
            assertThat(stack.getFirst().getText()).isEqualTo("3");
            assertThat(calcOperationHistory).hasSize(3);
            assertThat(calcOperationHistory.getLast()).hasSize(3);
            assertThat(calcOperationHistory.getLast().getFirst().getText()).isEqualTo("1");
            assertThat(calcOperationHistory.getLast().getLast().getText()).isEqualTo("+");
        }finally {
            rpnCalcEngine.setScanner(systemInScanner);
        }
    }

    @Test
    public void testSubtract() {
        Deque<Notation> stack = new ArrayDeque<>();
        Deque<Deque<Notation>> calcOperationHistory = new ArrayDeque<>();
        Scanner scanner = new Scanner("1 2 -");

        try{
            rpnCalcEngine.setScanner(scanner);
            rpnCalcEngine.setStack(stack);
            rpnCalcEngine.setCalcOperationHistory(calcOperationHistory);

            rpnCalcEngine.calc();

            assertThat(stack).hasSize(1);
            assertThat(stack.getFirst().getText()).isEqualTo("-1");
            assertThat(calcOperationHistory).hasSize(3);
            assertThat(calcOperationHistory.getLast()).hasSize(3);
            assertThat(calcOperationHistory.getLast().getFirst().getText()).isEqualTo("1");
            assertThat(calcOperationHistory.getLast().getLast().getText()).isEqualTo("-");
        }finally {
            rpnCalcEngine.setScanner(systemInScanner);
        }
    }

    @Test
    public void testSubtractMultiple() {
        Deque<Notation> stack = new ArrayDeque<>();
        Deque<Deque<Notation>> calcOperationHistory = new ArrayDeque<>();
        Scanner scanner = new Scanner("1 2 - -10 *");

        try{
            rpnCalcEngine.setScanner(scanner);
            rpnCalcEngine.setStack(stack);
            rpnCalcEngine.setCalcOperationHistory(calcOperationHistory);

            rpnCalcEngine.calc();

            assertThat(stack).hasSize(1);
            assertThat(stack.getFirst().getText()).isEqualTo("10");
            assertThat(calcOperationHistory).hasSize(5);
            assertThat(calcOperationHistory.getLast()).hasSize(3);
            assertThat(calcOperationHistory.getLast().getFirst().getText()).isEqualTo("-1");
            assertThat(calcOperationHistory.getLast().getLast().getText()).isEqualTo("*");
        }finally {
            rpnCalcEngine.setScanner(systemInScanner);
        }
    }

    @Test
    public void testDivideAdd() {
        Deque<Notation> stack = new ArrayDeque<>();
        Deque<Deque<Notation>> calcOperationHistory = new ArrayDeque<>();
        Scanner scanner = new Scanner("1 2 / 9.5 +");

        try{
            rpnCalcEngine.setScanner(scanner);
            rpnCalcEngine.setStack(stack);
            rpnCalcEngine.setCalcOperationHistory(calcOperationHistory);

            rpnCalcEngine.calc();

            assertThat(stack).hasSize(1);
            assertThat(stack.getFirst().getText()).isEqualTo("10");
            assertThat(calcOperationHistory).hasSize(5);
            assertThat(calcOperationHistory.getLast()).hasSize(3);
            assertThat(calcOperationHistory.getLast().getFirst().getText()).isEqualTo("0.5");
            assertThat(calcOperationHistory.getLast().getLast().getText()).isEqualTo("+");
        }finally {
            rpnCalcEngine.setScanner(systemInScanner);
        }
    }

    @Test
    public void testSqrtUndo() {
        Deque<Notation> stack = new ArrayDeque<>();
        Deque<Deque<Notation>> calcOperationHistory = new ArrayDeque<>();
        Scanner scanner = new Scanner("9 sqrt undo");

        try{
            rpnCalcEngine.setScanner(scanner);
            rpnCalcEngine.setStack(stack);
            rpnCalcEngine.setCalcOperationHistory(calcOperationHistory);

            rpnCalcEngine.calc();

            assertThat(stack).hasSize(1);
            assertThat(stack.getFirst().getText()).isEqualTo("9");
            assertThat(calcOperationHistory).hasSize(1);
            assertThat(calcOperationHistory.getLast()).isEmpty();
        }finally {
            rpnCalcEngine.setScanner(systemInScanner);
        }
    }

    @Test
    public void testSqrtSqrtUndoUndo() {
        Deque<Notation> stack = new ArrayDeque<>();
        Deque<Deque<Notation>> calcOperationHistory = new ArrayDeque<>();
        Scanner scanner = new Scanner("81 sqrt sqrt undo undo");

        try{
            rpnCalcEngine.setScanner(scanner);
            rpnCalcEngine.setStack(stack);
            rpnCalcEngine.setCalcOperationHistory(calcOperationHistory);

            rpnCalcEngine.calc();

            assertThat(stack).hasSize(1);
            assertThat(stack.getFirst().getText()).isEqualTo("81");
            assertThat(calcOperationHistory).hasSize(1);
            assertThat(calcOperationHistory.getLast()).isEmpty();
        }finally {
            rpnCalcEngine.setScanner(systemInScanner);
        }
    }

    @Test
    public void testDivideUndoMultiply() {
        Deque<Notation> stack = new ArrayDeque<>();
        Deque<Deque<Notation>> calcOperationHistory = new ArrayDeque<>();
        Scanner scanner = new Scanner("8 2 / undo *");

        try{
            rpnCalcEngine.setScanner(scanner);
            rpnCalcEngine.setStack(stack);
            rpnCalcEngine.setCalcOperationHistory(calcOperationHistory);

            rpnCalcEngine.calc();

            assertThat(stack).hasSize(1);
            assertThat(stack.getFirst().getText()).isEqualTo("16");
            assertThat(calcOperationHistory).hasSize(3);
            assertThat(calcOperationHistory.getLast().getFirst().getText()).isEqualTo("8");
            assertThat(calcOperationHistory.getLast().getLast().getText()).isEqualTo("*");
        }finally {
            rpnCalcEngine.setScanner(systemInScanner);
        }
    }

    @Test
    public void testThreeNumbers() {
        Deque<Notation> stack = new ArrayDeque<>();
        Deque<Deque<Notation>> calcOperationHistory = new ArrayDeque<>();
        Scanner scanner = new Scanner("8 2 -9");

        try{
            rpnCalcEngine.setScanner(scanner);
            rpnCalcEngine.setStack(stack);
            rpnCalcEngine.setCalcOperationHistory(calcOperationHistory);

            rpnCalcEngine.calc();

            assertThat(stack).hasSize(3);
            assertThat(stack.getFirst().getText()).isEqualTo("8");
            assertThat(stack.getLast().getText()).isEqualTo("-9");
            assertThat(calcOperationHistory).hasSize(3);

            assertThat(calcOperationHistory.getFirst()).isEmpty();
            assertThat(calcOperationHistory.getLast()).isEmpty();
        }finally {
            rpnCalcEngine.setScanner(systemInScanner);
        }
    }

    @Test
    public void testFinalClear() {
        Deque<Notation> stack = new ArrayDeque<>();
        Deque<Deque<Notation>> calcOperationHistory = new ArrayDeque<>();
        Scanner scanner = new Scanner("8 2 -9 - clear");

        try{
            rpnCalcEngine.setScanner(scanner);
            rpnCalcEngine.setStack(stack);
            rpnCalcEngine.setCalcOperationHistory(calcOperationHistory);

            rpnCalcEngine.calc();

            assertThat(stack).isEmpty();
            assertThat(calcOperationHistory).hasSize(5);

            assertThat(calcOperationHistory.getLast()).hasSize(3);
            assertThat(calcOperationHistory.getLast().getFirst().getText()).isEqualTo("8");
            assertThat(calcOperationHistory.getLast().getLast().getText()).isEqualTo("clear");
        }finally {
            rpnCalcEngine.setScanner(systemInScanner);
        }
    }

    @Test
    public void testClearUndo() {
        Deque<Notation> stack = new ArrayDeque<>();
        Deque<Deque<Notation>> calcOperationHistory = new ArrayDeque<>();
        Scanner scanner = new Scanner("8 2 -9 - clear undo");

        try{
            rpnCalcEngine.setScanner(scanner);
            rpnCalcEngine.setStack(stack);
            rpnCalcEngine.setCalcOperationHistory(calcOperationHistory);

            rpnCalcEngine.calc();

            assertThat(stack).hasSize(2);
            assertThat(stack.getFirst().getText()).isEqualTo("8");
            assertThat(stack.getLast().getText()).isEqualTo("11");

            assertThat(calcOperationHistory).hasSize(4);

            assertThat(calcOperationHistory.getLast()).hasSize(3);
            assertThat(calcOperationHistory.getLast().getFirst().getText()).isEqualTo("2");
            assertThat(calcOperationHistory.getLast().getLast().getText()).isEqualTo("-");
        }finally {
            rpnCalcEngine.setScanner(systemInScanner);
        }
    }
}
