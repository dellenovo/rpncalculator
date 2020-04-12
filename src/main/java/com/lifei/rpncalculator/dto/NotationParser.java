package com.lifei.rpncalculator.dto;

import com.lifei.rpncalculator.dto.impl.Decimal15Operand;
import com.lifei.rpncalculator.util.NumberUtils;


public class NotationParser {

    public static Notation parse(String input){

        if(NumberUtils.isNumber(input)) {
            return new Decimal15Operand(input);
        }

        Notation result = null;
        switch (input){
            case "":
                break;
        }

        return result;
    }
}
