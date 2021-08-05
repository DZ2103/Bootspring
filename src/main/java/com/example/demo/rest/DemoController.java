package com.example.demo.rest;

import com.example.demo.model.Person;
import com.example.demo.persistence.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {


    private final PersonRepository personRepository;
    public DemoController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @GetMapping("persons")
    public List<Person> getPersons() {
        var persons = new ArrayList<Person>();
        for(Person person: personRepository.findAll()) {
            persons.add(person);
        }
        return persons;
    }
}