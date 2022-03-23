package com.img.data.consumer.golf.transformer;

import com.img.data.consumer.golf.domain.TournamentEvent;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TournamentSourceBEventTransformer implements Transformer {
    @Override
    public TournamentEvent transform(Map<String, Object> incoming) {
        final TournamentEvent event = new TournamentEvent();
        event.setId((String) incoming.get("tournamentUUID"));
        event.setCourse((String) incoming.get("golfCourse"));
        event.setName((String) incoming.get("competitionName"));
        event.setCountryCode((String) incoming.get("hostCountry"));
        event.setStartMillis((String) incoming.get("epochStart"));
        event.setEndMillis((String) incoming.get("epochFinish"));
        event.setRoundCount((String) incoming.get("rounds"));
        event.setPlayerCount((String) incoming.get("playerCount"));
        return event;
    }
}
