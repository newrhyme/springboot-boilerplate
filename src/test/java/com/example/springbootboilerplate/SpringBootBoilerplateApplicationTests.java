package com.example.springbootboilerplate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootBoilerplateApplicationTests {

    @Disabled("CI에서는 DB 설정 없어 contextLoads 테스트를 실행하지 않음")
    @Test
    void contextLoads() {
    }

}
