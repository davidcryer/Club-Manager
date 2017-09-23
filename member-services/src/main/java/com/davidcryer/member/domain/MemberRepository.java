package com.davidcryer.member.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface MemberRepository extends CrudRepository<AnaemicMember, Long> {
}
