package com.davidcryer.services.football.career;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FootballCareerRepository extends CrudRepository<FootballCareer, Long> {
}
