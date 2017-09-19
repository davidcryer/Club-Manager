package com.davidcryer.footballclubservices.club;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FootballClubRepository extends CrudRepository<FootballClub, Long> {
}
