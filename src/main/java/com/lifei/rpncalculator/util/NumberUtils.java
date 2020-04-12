package com.lifei.rpncalculator.util;

import java.util.regex.Pattern;

public class NumberUtils {
//    public static final String Decimal_PATTERN = "((-*[1-9]\\d*)|0)(\\.\\d+)*";// too strict
    public static final String Decimal_PATTERN = "-*\\d+\\.*\\d*";

    public static boolean isNumber(String input) {
        return Pattern.compile(Decimal_PATTERN).matcher(input).matches();
    }
}
