package com.erudio.api_rest_person.services;

import com.erudio.api_rest_person.model.Person;
import com.erudio.api_rest_person.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {

        logger.info("Finding all people!");

        return repository.findAll();
    }

    public Person findById(Long id) {

        logger.info("Finding one person!");

        return repository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("No records found for this ID!"));
    }

    public Person create(Person person) {

        logger.info("Creating one person!");
        return repository.save(person);
    }

    public Person update(Person person) {

        logger.info("Updating a person`s data!");

        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceAccessException("No records found for this ID!"));

        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());

        return repository.save(person);
    }


    public void delete(Long id) {

        logger.info("Deleting a person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("No records found for this ID!"));
        repository.delete(entity);

    }
}
