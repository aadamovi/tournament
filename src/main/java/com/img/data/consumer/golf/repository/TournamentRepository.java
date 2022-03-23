package com.img.data.consumer.golf.repository;

import com.img.data.consumer.golf.domain.TournamentEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends CrudRepository<TournamentEvent, String> {
}
