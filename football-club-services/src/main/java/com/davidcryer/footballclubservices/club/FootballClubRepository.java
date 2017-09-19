package com.davidcryer.footballclubservices.club;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballClubRepository extends CrudRepository<FootballClub, Long> {
}
