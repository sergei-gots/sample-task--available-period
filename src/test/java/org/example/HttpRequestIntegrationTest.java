package org.example;


import mockit.Mock;
import mockit.MockUp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Objects;


@SpringBootTest
@AutoConfigureMockMvc
class HttpRequestIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturn400BadRequestWhenNoSessionToken() throws Exception {

        this.mockMvc
            .perform(get("/available-period"))
            .andDo(print())
            .andExpect(status().isBadRequest());
    }

    @ParameterizedTest
    @ValueSource(strings = { "2023-11-03", "2013-10-27", "2023-12-31" })
    void shouldReturnJson(String strDate) throws Exception {
        System.out.println("Test for DATE = " + strDate);

        String expectedJson = readExpectedJsonFromResource(strDate);
        ZoneId utc = ZoneId.of("UTC");
        Clock clock = Clock.fixed(Instant.parse(strDate + "T00:00:00Z"), utc);

        new MockUp<Instant>() {
            @Mock
            public Instant now() {
                return Instant.now(clock);
            }
        };
        this.mockMvc
            .perform(get("/available-period")
            .header("session-token", "session-token"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().json(expectedJson));
    }

    private String readExpectedJsonFromResource(String strDate) throws URISyntaxException, IOException {
        return Files.readString(
                Paths.get(Objects.requireNonNull(
                        AvailablePeriodController.class
                                .getResource(strDate + ".json"))
                        .toURI()
                )
        );
    }

}