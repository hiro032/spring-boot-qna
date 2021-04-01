package com.codessquad.qna.exception;

public class NotFoundEntityException extends RuntimeException{

    public NotFoundEntityException() {
        super("유효하지 않는 id입니다");
    }

    public NotFoundEntityException(String errorMessage) {
        super(errorMessage);
    }
}
