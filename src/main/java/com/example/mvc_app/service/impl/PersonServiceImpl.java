package com.example.mvc_app.service.impl;

import com.example.mvc_app.models.Person;
import com.example.mvc_app.repositories.PersonRepository;
import com.example.mvc_app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repo;

    @Autowired
    public PersonServiceImpl(PersonRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Person> getAllPeople() {
        return repo.findAll();
    }

    @Override
    public Person getPerson(int id) {
       Person person = repo.getById(id);
        return person;
    }

    @Override
    public void savePerson(Person person) {
        repo.save(person);
    }

    @Override
    public void deletePerson(int id) {
        repo.deleteById(id);
    }
}
