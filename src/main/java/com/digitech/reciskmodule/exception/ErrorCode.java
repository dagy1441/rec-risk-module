package com.digitech.reciskmodule.exception;

public enum ErrorCode {

    PARTICIPANT_NOT_FOUND(1000),
    PARTICIPANT_NOT_VALID(1001),

    FORMATEUR_NOT_FOUND(2000),
    FORMATEUR_NOT_VALID(2001)
    ;
    private int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
