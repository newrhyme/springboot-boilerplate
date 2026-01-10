package com.example.springbootboilerplate.global.common.code;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    // Common Error들은 여기서 정의하고 각 도메인별 ErrorCode에서는 도메인 특화 에러만 정의해주세요.
    // 400 Bad Request
    INVALID_REQUEST(org.springframework.http.HttpStatus.BAD_REQUEST, "E000", "요청이 올바르지 않습니다."),
    VALIDATION_ERROR(org.springframework.http.HttpStatus.BAD_REQUEST, "E001", "입력값 검증에 실패했습니다."),

    // 401 / 403 Unauthorized / Forbidden
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "E401", "인증이 필요합니다."),
    FORBIDDEN(HttpStatus.FORBIDDEN, "E403", "접근 권한이 없습니다."),

    // 404 Not Found
    RESOURCE_NOT_FOUND(org.springframework.http.HttpStatus.NOT_FOUND, "E404", "리소스를 찾을 수 없습니다."),

    // 500 Internal Server Error
    INTERNAL_SERVER_ERROR(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR, "E999", "서버 내부 오류가 발생했습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;


    ErrorCode(HttpStatus httpStatus, String code, String message) {
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
