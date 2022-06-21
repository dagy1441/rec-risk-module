package com.digitech.reciskmodule.exception;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorHandler {

    private Integer httpStatus;

    private ErrorCode errorCode;

    private String message;

    private List<String> errors;


}
