package com.erudio.api_rest_person.cotrollers;

import com.erudio.api_rest_person.model.Person;
import com.erudio.api_rest_person.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") String id) {
        return service.findById(id);
    }

    @RequestMapping(method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @RequestMapping(method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") String id) {
        service.delete(id);
    }
}
