package com.erudio.api_rest_person.services;

import com.erudio.api_rest_person.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {

        logger.info("Finding all people!");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

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


    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setAddress("Address: " + i);
        person.setGender("Gender: " + i);
        person.setFirstName("Name: " + i);
        person.setLastName("Last name: " + i);
        return person;
    }
}
