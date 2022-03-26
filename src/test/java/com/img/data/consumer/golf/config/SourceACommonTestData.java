package com.img.data.consumer.golf.config;

import com.img.data.consumer.golf.domain.TournamentEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SourceACommonTestData {
    private static final String ID = "12345";
    private static final String NAME = "scotland open";
    private static final String START_DATE = "13/12/21";
    private static final String END_DATE = "13/01/21";

    public static final Supplier<Map<String, Object>> PAYLOAD = () -> {
        final Map<String, Object> input = new HashMap<>();
        input.put("tournamentId", ID);
        input.put("tournamentName", NAME);
        input.put("startDate", START_DATE);
        input.put("endDate", END_DATE);
        input.put("countryCode", "GB");

        return input;
    };

    public static final Supplier<TournamentEvent> EVENT = () -> {
        final TournamentEvent event = new TournamentEvent();
        event.setId(ID);
        event.setName(NAME);
        event.setStartDate(START_DATE);
        event.setEndDate(END_DATE);
        return event;
    };


    private SourceACommonTestData(){}
}
