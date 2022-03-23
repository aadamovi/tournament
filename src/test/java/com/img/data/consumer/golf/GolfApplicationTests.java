package com.img.data.consumer.golf;

import com.img.data.consumer.golf.config.AbstractTestContainer;
import com.img.data.consumer.golf.domain.TournamentEvent;
import com.img.data.consumer.golf.repository.TournamentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class GolfApplicationTests extends AbstractTestContainer {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TournamentRepository repository;

    @Test
    void healthCheck() throws Exception {
        final var mvcResult = this.mockMvc
            .perform(get("/actuator/health"))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();
        assertThat(mvcResult.getResponse().getContentAsString().contains("\"status\":\"UP\""), is(true));
    }

    @Test
    void shouldSaveToCouchbase() throws Exception {
        final var headers = new HttpHeaders();
        headers.add("source", "sourceA");
        final var mvcResult = this.mockMvc
            .perform(post("/tournament")
                .headers(headers)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("{\n" +
                    "\t\"tournamentId\": \"174638\",\n" +
                    "\t\"tournamentName\": \"Women's Open Championship\",\n" +
                    "\t\"forecast\": \"fair\",\n" +
                    "\t\"courseName\": \"Sunnydale Golf Course\",\n" +
                    "\t\"countryCode\": \"GB\",\n" +
                    "\t\"startDate\": \"09/07/21\",\n" +
                    "\t\"endDate\": \"13/07/21\",\n" +
                    "\t\"roundCount\": \"4\"\n" +
                    "}"))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();
        final TournamentEvent actual = new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), TournamentEvent.class);
        final Optional<TournamentEvent> saved = repository.findById("174638");
        saved.ifPresentOrElse(
            value -> assertThat(actual, is(value)),
            () -> {
                throw new IllegalArgumentException("A database entry wasn't found");
            }
        );
    }
}
