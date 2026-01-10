package com.example.springbootboilerplate.global.common.code;

import org.springframework.http.HttpStatus;

public enum SuccessCode {

    // 200 OK
    OK(HttpStatus.OK, "S200", "요청이 성공했습니다."),
    READ_SUCCESS(HttpStatus.OK, "S201", "조회에 성공했습니다."),
    UPDATE_SUCCESS(HttpStatus.OK, "S202", "수정에 성공했습니다."),

    // 201 CREATED
    CREATED(HttpStatus.CREATED, "S201", "리소스가 생성되었습니다."),

    // 202 ACCEPTED
    ACCEPTED(HttpStatus.ACCEPTED, "S202", "요청이 접수되었습니다."),

    // 204 NO CONTENT
    DELETED(HttpStatus.NO_CONTENT, "S204", "리소스가 삭제되었습니다.");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    SuccessCode(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
