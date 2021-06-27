package com.example.mvc_app.service;

import com.example.mvc_app.models.Person;

import java.util.List;

public interface PersonService {

    public List<Person> getAllPeople();
    public Person getPerson(int id);
    public void savePerson(Person person);
    public void deletePerson(int id);
}
