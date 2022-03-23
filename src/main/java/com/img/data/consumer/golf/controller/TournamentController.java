package com.img.data.consumer.golf.controller;

import com.img.data.consumer.golf.domain.TournamentEvent;
import com.img.data.consumer.golf.service.TournamentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TournamentController {
    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PostMapping(path = "/tournament", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public TournamentEvent consumeTournamentEvent(@RequestHeader("source") String source, @RequestBody Map<String, Object> request) {
        return tournamentService.handle(source, request);
    }
}
