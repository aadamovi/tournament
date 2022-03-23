package com.img.data.consumer.golf.config;

import com.img.data.consumer.golf.domain.TournamentEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SourceACommonTestData {
    private static final String ID = "12345";
    private static final String NAME = "scotland open";

    public static final Supplier<Map<String, Object>> PAYLOAD = () -> {
        final Map<String, Object> input = new HashMap<>();
        input.put("tournamentId", ID);
        input.put("tournamentName", NAME);
        return input;
    };

    public static final Supplier<TournamentEvent> EVENT = () -> {
        final TournamentEvent event = new TournamentEvent();
        event.setId(ID);
        event.setName(NAME);
        return event;
    };


    private SourceACommonTestData(){}
}
