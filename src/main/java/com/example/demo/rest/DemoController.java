package com.example.demo.rest;

import com.example.demo.model.Person;
import com.example.demo.persistence.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DemoController {


    private final PersonRepository personRepository;

    public DemoController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @GetMapping("persons")
    public List<Person> getPersons() {
        var persons = new ArrayList<Person>();
        for (Person person : personRepository.findAll()) {
            persons.add(person);
        }
        return persons;
    }

    @PostMapping("persons")
    public Person postPerson(@RequestBody Person personToInsert) {
        personRepository.save(personToInsert);
        return personToInsert;
    }

    @DeleteMapping("persons/{id}")
    public void deletePerson(@PathVariable Integer id) {
        personRepository.deleteById(id);

    }

    @PutMapping("persons")
    public Person putPerson(@RequestBody Person personToUpdate) {
        personRepository.save(personToUpdate);
        return personToUpdate;
    }

    @GetMapping("persons/{id}")
    public Person getPerson(@PathVariable Integer id) {
        return personRepository.findById(id).orElse(null);

    }
}


