package com.img.data.consumer.golf.controller;

import com.img.data.consumer.golf.domain.TournamentEvent;
import com.img.data.consumer.golf.service.TournamentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static com.img.data.consumer.golf.config.SourceACommonTestData.EVENT;
import static com.img.data.consumer.golf.config.SourceACommonTestData.PAYLOAD;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TournamentController.class)
class TournamentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TournamentService tournamentService;

    @Test
    void shouldSaveTournamentEvent() throws Exception {
        when(tournamentService.handle("sourceA", PAYLOAD.get())).thenReturn(EVENT.get());

        final var headers = new HttpHeaders();
        headers.add("source", "sourceA");
        final var mvcResult = this.mockMvc
            .perform(post("/tournament")
                .headers(headers)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("{\n" +
                    "\t\"tournamentId\": \"12345\",\n" +
                    "\t\"tournamentName\": \"scotland open\",\n" +
                    "\t\"startDate\": \"13/12/21\",\n" +
                    "\t\"endDate\": \"13/01/21\",\n" +
                    "\t\"countryCode\": \"GB\"\n" +
                    "}"))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();

        final TournamentEvent actual = new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), TournamentEvent.class);
        assertThat(actual, is(EVENT.get()));
    }
}