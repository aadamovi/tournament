package com.img.data.consumer.golf.transformer;

import com.img.data.consumer.golf.domain.TournamentEvent;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.img.data.consumer.golf.transformer.IsoLocalDateConverter.FORMAT_SLASH_DELIMITED_DATE_TO_ISO;

@Component
public class TournamentSourceAEventTransformer implements Transformer {

    @Override
    public TournamentEvent transform(Map<String, Object> incoming) {
        final TournamentEvent event = new TournamentEvent();
        event.setId((String) incoming.get("tournamentId"));
        event.setName((String) incoming.get("tournamentName"));
        event.setCountryCode((String) incoming.get("countryCode"));
        event.setCourse((String) incoming.get("courseName"));
        event.setStartDate(FORMAT_SLASH_DELIMITED_DATE_TO_ISO.getConverter().apply((String) incoming.get("startDate")));
        event.setEndDate(FORMAT_SLASH_DELIMITED_DATE_TO_ISO.getConverter().apply((String) incoming.get("endDate")));
        event.setRoundCount((String) incoming.get("roundCount"));
        event.setForecast((String) incoming.get("forecast"));
        return event;
    }
}
