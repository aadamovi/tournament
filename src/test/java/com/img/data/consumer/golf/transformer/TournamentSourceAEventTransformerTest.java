package com.img.data.consumer.golf.transformer;

import com.img.data.consumer.golf.domain.TournamentEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
class TournamentSourceAEventTransformerTest {

    @Test
    void shouldConvertSourceAMapToEvent() {
        final String id = "someId";
        final String name = "England Open";
        final String course = "Good course";
        final String countryCode = "GB";
        final String forecast = "nice";
        final String startDate = "09/08/22";
        final String endDate = "16/08/22";
        final String round = "6";

        final Map<String, Object> input = new HashMap<>();
        input.put("tournamentId", id);
        input.put("tournamentName", name);
        input.put("courseName", course);
        input.put("countryCode", countryCode);
        input.put("forecast", forecast);
        input.put("startDate", startDate);
        input.put("endDate", endDate);
        input.put("roundCount", round);

        final TournamentSourceAEventTransformer transformer = new TournamentSourceAEventTransformer();

        final TournamentEvent result = transformer.transform(input);
        assertThat(result.getId(), is(id));
        assertThat(result.getName(), is(name));
        assertThat(result.getCourse(), is(course));
        assertThat(result.getCountryCode(), is(countryCode));
        assertThat(result.getForecast(), is(forecast));
        assertThat(result.getStartDate(), is("2022-08-09"));
        assertThat(result.getEndDate(), is("2022-08-16"));
        assertThat(result.getRoundCount(), is(round));
    }
}