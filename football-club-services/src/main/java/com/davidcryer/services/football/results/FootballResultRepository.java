package com.davidcryer.services.football.results;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FootballResultRepository extends CrudRepository<FootballResult, Long> {
}
