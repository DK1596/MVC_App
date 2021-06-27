package com.example.mvc_app.repositories;

import com.example.mvc_app.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
