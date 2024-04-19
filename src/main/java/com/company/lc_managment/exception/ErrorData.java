package com.company.lc_managment.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorData {

    private int status;

    private String msg;

    private String field;

    public ErrorData(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
