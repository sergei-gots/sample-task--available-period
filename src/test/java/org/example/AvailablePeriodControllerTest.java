package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AvailablePeriodControllerTest {

    @Autowired
    private AvailablePeriodController controller;

    @Test
    void contextLoads()  {
        assertThat(controller).isNotNull();
    }
}