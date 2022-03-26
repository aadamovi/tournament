package com.img.data.consumer.golf.transformer;

import com.img.data.consumer.golf.domain.TournamentEvent;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.img.data.consumer.golf.transformer.IsoLocalDateConverter.EPOCH_TO_LOCAL_DATE_IN_ISO;

@Component
public class TournamentSourceBEventTransformer implements Transformer {
    @Override
    public TournamentEvent transform(Map<String, Object> incoming) {
        final TournamentEvent event = new TournamentEvent();
        event.setId((String) incoming.get("tournamentUUID"));
        event.setCourse((String) incoming.get("golfCourse"));
        event.setName((String) incoming.get("competitionName"));
        event.setCountryCode((String) incoming.get("hostCountry"));
        event.setStartDate(EPOCH_TO_LOCAL_DATE_IN_ISO.getConverter().apply((String) incoming.get("epochStart")));
        event.setEndDate(EPOCH_TO_LOCAL_DATE_IN_ISO.getConverter().apply((String) incoming.get("epochFinish")));
        event.setRoundCount((String) incoming.get("rounds"));
        event.setPlayerCount((String) incoming.get("playerCount"));
        return event;
    }
}
