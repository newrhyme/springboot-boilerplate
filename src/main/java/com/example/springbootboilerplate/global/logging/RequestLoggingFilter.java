package com.example.springbootboilerplate.global.logging;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jboss.logging.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@Component
public class RequestLoggingFilter extends OncePerRequestFilter {

    // Request ID 관련 상수
    public static final String REQUEST_ID = "requestId";

    // Request Header에서 사용할 Request ID 키
    public static final String HEADER_REQUEST_ID = "X-Request-ID";

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        // 필터 로직 구현
        // 요청 시작 시간 기록
        long start = System.currentTimeMillis();

        String requestedId = request.getHeader(HEADER_REQUEST_ID);

        if (requestedId == null || requestedId.isBlank()) {
            requestedId = UUID.randomUUID().toString();
        }

        MDC.put(REQUEST_ID, requestedId);
        response.setHeader(HEADER_REQUEST_ID, requestedId);

        try {
            filterChain.doFilter(request, response);
        } finally {
            long duration = System.currentTimeMillis() - start;
            log.info("method={}, uri={}, status={}, duration={}ms",
                    request.getMethod(),
                    request.getRequestURI(),
                    response.getStatus(),
                    duration);
            MDC.remove(REQUEST_ID);
        }
    }

}
