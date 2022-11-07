package com.fms.exceptions;

public class AdminUserCannotBeDeletedException extends RuntimeException {
    public AdminUserCannotBeDeletedException(String msg) {
        super(msg);
    }
}
