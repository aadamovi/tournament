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
class TournamentSourceBEventTransformerTest {

    @Test
    void shouldConvertSourceBMapToEvent() {
        final String id = "123344566";
        final String name = "UK Open";
        final String course = "Fine course";
        final String countryCode = "GB";
        final String playerCount = "1";
        final String epochStart = "123456";
        final String epochFinish = "123457";
        final String round = "6";

        final Map<String, Object> input = new HashMap<>();
        input.put("tournamentUUID", id);
        input.put("competitionName", name);
        input.put("golfCourse", course);
        input.put("hostCountry", countryCode);
        input.put("playerCount", playerCount);
        input.put("epochStart", epochStart);
        input.put("epochFinish", epochFinish);
        input.put("rounds", round);

        final TournamentSourceBEventTransformer transformer = new TournamentSourceBEventTransformer();

        final TournamentEvent result = transformer.transform(input);
        assertThat(result.getId(), is(id));
        assertThat(result.getName(), is(name));
        assertThat(result.getCourse(), is(course));
        assertThat(result.getCountryCode(), is(countryCode));
        assertThat(result.getPlayerCount(), is(playerCount));
        assertThat(result.getStartMillis(), is(epochStart));
        assertThat(result.getEndMillis(), is(epochFinish));
        assertThat(result.getRoundCount(), is(round));
    }
}