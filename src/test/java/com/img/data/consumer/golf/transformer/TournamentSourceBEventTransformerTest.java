package com.img.data.consumer.golf.transformer;

import com.img.data.consumer.golf.domain.TournamentEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
class TournamentSourceBEventTransformerTest {

    @Test
    void shouldConvertSourceBMapToEvent() {
        final String id = "123344566";
        final String name = "UK Open";
        final String course = "Fine course";
        final String countryCode = "GB";
        final String playerCount = "1";
        final Instant epochStart = Instant.now();
        final Instant epochFinish = Instant.now().plusSeconds(36000L);
        final String startDate = toLocalDateString(epochStart.toEpochMilli());
        final String endDate = toLocalDateString(epochFinish.toEpochMilli());
        final String round = "6";

        final Map<String, Object> input = new HashMap<>();
        input.put("tournamentUUID", id);
        input.put("competitionName", name);
        input.put("golfCourse", course);
        input.put("hostCountry", countryCode);
        input.put("playerCount", playerCount);
        input.put("epochStart", String.valueOf(epochStart.toEpochMilli()));
        input.put("epochFinish", String.valueOf(epochFinish.toEpochMilli()));
        input.put("rounds", round);

        final TournamentSourceBEventTransformer transformer = new TournamentSourceBEventTransformer();

        final TournamentEvent result = transformer.transform(input);
        assertThat(result.getId(), is(id));
        assertThat(result.getName(), is(name));
        assertThat(result.getCourse(), is(course));
        assertThat(result.getCountryCode(), is(countryCode));
        assertThat(result.getPlayerCount(), is(playerCount));
        assertThat(result.getStartDate(), is(startDate));
        assertThat(result.getEndDate(), is(endDate));
        assertThat(result.getRoundCount(), is(round));
    }

    private String toLocalDateString(long millis) {
        final LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond((millis)), ZoneId.systemDefault());
        return localDateTime.toLocalDate().format(DateTimeFormatter.ISO_DATE);
    }
}