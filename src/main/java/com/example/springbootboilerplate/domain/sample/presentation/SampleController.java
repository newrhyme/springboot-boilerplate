package com.example.springbootboilerplate.domain.sample.presentation;

import com.example.springbootboilerplate.global.common.code.ErrorCode;
import com.example.springbootboilerplate.global.common.code.SuccessCode;
import com.example.springbootboilerplate.global.common.response.ApiResponse;
import com.example.springbootboilerplate.global.exception.CustomException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/sample")
public class SampleController {

    @GetMapping
    public ApiResponse<Map<String, String>> sample() {
        return ApiResponse.success(SuccessCode.READ_SUCCESS, Map.of("hello", "boilerplate"));
    }

    @PostMapping
    public ApiResponse<Map<String, String>> validate(@RequestBody @Valid SampleRequest request) {
        return ApiResponse.success(SuccessCode.CREATED, Map.of("name", request.getName()));
    }

    @GetMapping("/error")
    public ApiResponse<Void> error() {
        throw new CustomException(ErrorCode.INVALID_REQUEST);
    }
}
