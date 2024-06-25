package com.designpatterns.models;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, String> {

}