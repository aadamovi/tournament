package com.img.data.consumer.golf.service;

import com.img.data.consumer.golf.domain.TournamentEvent;
import com.img.data.consumer.golf.repository.TournamentRepository;
import com.img.data.consumer.golf.transformer.TournamentEventTransformerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TournamentService {

    private final TournamentEventTransformerFactory transformerFactory;
    private final TournamentRepository tournamentRepository;

    public TournamentService(TournamentEventTransformerFactory transformerFactory,
                             TournamentRepository tournamentRepository) {
        this.transformerFactory = transformerFactory;
        this.tournamentRepository = tournamentRepository;
    }

    public TournamentEvent handle(String source, Map<String, Object> event) {
        final TournamentEvent tournamentEvent = transformerFactory.getTransformer(source).transform(event);
        tournamentEvent.setSource(source);
        return tournamentRepository.save(tournamentEvent);
    }

}
