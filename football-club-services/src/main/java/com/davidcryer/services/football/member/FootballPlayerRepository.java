package com.davidcryer.services.football.member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FootballPlayerRepository extends CrudRepository<FootballPlayer, Long> {
}
