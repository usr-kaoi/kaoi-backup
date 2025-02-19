package com.erudio.api_rest_person.services;

import com.erudio.api_rest_person.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {

        logger.info("Finding one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setAddress("Uberlândia - MG");
        person.setGender("Male");
        person.setFirstName("Leandro");
        person.setLastName("Costa");
        return person;
    }
}
