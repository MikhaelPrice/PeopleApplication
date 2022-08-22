package com.SpringBoot.PeopleApplication.repo;

import com.SpringBoot.PeopleApplication.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
