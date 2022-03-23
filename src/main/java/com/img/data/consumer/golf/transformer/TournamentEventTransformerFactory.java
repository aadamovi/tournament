package com.img.data.consumer.golf.transformer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TournamentEventTransformerFactory {
    private final Map<String, Transformer> transformerCache;

    public TournamentEventTransformerFactory(@Qualifier("transformerCache") Map<String, Transformer> transformerCache) {
        this.transformerCache = transformerCache;
    }

    public Transformer getTransformer(String source) {
        if (this.transformerCache.containsKey(source)) {
            return this.transformerCache.get(source);
        }
        throw new IllegalArgumentException("Invalid source provided");
    }
}
