package com.img.data.consumer.golf.transformer;

import com.img.data.consumer.golf.domain.TournamentEvent;

import java.util.Map;

public interface Transformer {
    TournamentEvent transform(Map<String, Object> event);
}
