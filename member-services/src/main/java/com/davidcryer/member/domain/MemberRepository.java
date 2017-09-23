package com.davidcryer.member.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unused")
interface MemberRepository extends CrudRepository<AnaemicMember, Long> {
}
