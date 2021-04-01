package com.codessquad.qna.exception;

public class NotLoginException extends RuntimeException {
    public NotLoginException() {
        super("헬로");
    }
    public NotLoginException(String errorMessage) {
        super(errorMessage);
    }
}
