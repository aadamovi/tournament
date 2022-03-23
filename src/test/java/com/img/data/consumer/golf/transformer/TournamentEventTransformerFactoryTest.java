package com.img.data.consumer.golf.transformer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
class TournamentEventTransformerFactoryTest {

    @Test
    void shouldGetTransformer() {
        final Map<String, Transformer> transformersCache = new HashMap<>();
        transformersCache.put("sourceA", new TournamentSourceAEventTransformer());
        transformersCache.put("sourceB", new TournamentSourceBEventTransformer());

        final TournamentEventTransformerFactory factory = new TournamentEventTransformerFactory(transformersCache);

        assertThat(factory.getTransformer("sourceA") instanceof TournamentSourceAEventTransformer, is(true));
        assertThat(factory.getTransformer("sourceB") instanceof TournamentSourceBEventTransformer, is(true));
    }
}