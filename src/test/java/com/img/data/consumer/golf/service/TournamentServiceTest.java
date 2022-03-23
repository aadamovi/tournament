package com.img.data.consumer.golf.service;

import com.img.data.consumer.golf.domain.TournamentEvent;
import com.img.data.consumer.golf.repository.TournamentRepository;
import com.img.data.consumer.golf.transformer.TournamentEventTransformerFactory;
import com.img.data.consumer.golf.transformer.TournamentSourceAEventTransformer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.img.data.consumer.golf.config.SourceACommonTestData.EVENT;
import static com.img.data.consumer.golf.config.SourceACommonTestData.PAYLOAD;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TournamentServiceTest {

    @Mock
    private TournamentEventTransformerFactory factory;

    @Mock
    private TournamentRepository repository;

    private TournamentService service;

    @BeforeEach
    void setUp() {
        service = new TournamentService(factory, repository);
    }

    @Test
    void shouldHandleSourceAEvent() {
        final String sourceA = "sourceA";

        when(factory.getTransformer(sourceA)).thenReturn(new TournamentSourceAEventTransformer());
        when(repository.save(any(TournamentEvent.class))).thenReturn(EVENT.get());

        service.handle(sourceA, PAYLOAD.get());

        verify(factory).getTransformer(sourceA);
        verify(repository).save(any(TournamentEvent.class));
    }
}