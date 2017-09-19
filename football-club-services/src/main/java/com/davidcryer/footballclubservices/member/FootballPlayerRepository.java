package com.davidcryer.footballclubservices.member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballPlayerRepository extends CrudRepository<FootballPlayer, Long> {
}
