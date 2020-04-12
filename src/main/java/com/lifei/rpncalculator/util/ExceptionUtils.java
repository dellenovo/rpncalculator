package com.lifei.rpncalculator.util;

public class ExceptionUtils {
    public static void check(boolean condition, Exception ex) throws Exception {
        if(!condition){
            throw ex;
        }
    }

}
