package com.img.data.consumer.golf.conf;

import com.img.data.consumer.golf.transformer.TournamentSourceAEventTransformer;
import com.img.data.consumer.golf.transformer.TournamentSourceBEventTransformer;
import com.img.data.consumer.golf.transformer.Transformer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ApplicationConfiguration {

    @Bean
    @Qualifier("transformerCache")
    public Map<String, Transformer> transformerCache(TournamentSourceAEventTransformer sourceAEventTransformer,
                                                     TournamentSourceBEventTransformer sourceBEventTransformer) {
        final Map<String, Transformer> transformersCache = new HashMap<>();
        transformersCache.put("sourceA", sourceAEventTransformer);
        transformersCache.put("sourceB", sourceBEventTransformer);
        return transformersCache;
    }
}
