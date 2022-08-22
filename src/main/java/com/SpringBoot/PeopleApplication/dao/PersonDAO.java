package com.SpringBoot.PeopleApplication.dao;

import com.SpringBoot.PeopleApplication.models.Person;
import com.SpringBoot.PeopleApplication.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {

    @Autowired
    private PersonRepository personRepository;

    public Iterable<Person> index() {
        return personRepository.findAll();
    }

    public Person show(Long id) {
        List<Person> people = (List<Person>) personRepository.findAll();
        return people.stream().filter(person -> person.getId().equals(id)).findAny().orElse(null);
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public void update(Long id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());

        personRepository.save(personToBeUpdated);
    }

    public void delete(Long id) {
        Person person = new Person();
        if (person.getId().equals(id)) {
            personRepository.delete(person);
        }
    }
}
