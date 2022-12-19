package io.zipcoder.crudapp.controllers;

import io.zipcoder.crudapp.entities.Person;
import io.zipcoder.crudapp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/people")
public class PersonController {
    PersonRepository personRepository;
    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public Person createPerson(@RequestBody Person p){
        return personRepository.save(p);

    }
    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id){
        return personRepository.findOne(id);
    }
    @GetMapping
    public Iterable<Person> getPersonList(){
        return personRepository.findAll();
    }
    @PutMapping
    public Person updatePerson(@PathVariable Long id, @RequestBody Person p){
        Person updatePerson = personRepository.findOne(id);
        updatePerson.setFirstName(p.getFirstName());
        updatePerson.setLastName(p.getLastName());
        return personRepository.save(updatePerson);
    }
    @DeleteMapping("/{id}")
    public void DeletePerson(@PathVariable Long id){
        personRepository.delete((Long) id);
    }
}
