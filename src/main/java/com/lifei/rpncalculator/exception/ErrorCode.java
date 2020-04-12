package com.lifei.rpncalculator.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    SUCCESS(0, "success"),
    ILLEGAL_NOTATION(100, "Illegal notation found:"),
    LACK_OF_OPERAND(101, "Lack of operand:"),
    DIVIDED_BY_ZERO(102, "Divided by zero"),
    NEGATIVE_RADICAND(103, "Negative radicand"),
    INTERNAL_ERROR(104, "Internal error");

    private int errorCode;
    private String msg;

    ErrorCode(int errorCode, String msg){
        this.errorCode = errorCode;
        this.msg = msg;
    }

}
