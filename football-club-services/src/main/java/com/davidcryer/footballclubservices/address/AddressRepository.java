package com.davidcryer.footballclubservices.address;

import com.davidcryer.common.domain.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AddressRepository extends CrudRepository<Address, Long> {
}
