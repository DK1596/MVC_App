package com.example.mvc_app.controllers;

import com.example.mvc_app.models.Person;
import com.example.mvc_app.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public String getAllPeople(Model model){
        List<Person> allPeople = personService.getAllPeople();
        model.addAttribute("people", allPeople);
        return "all_people";
    }

    @GetMapping("/{id}")
    public String getPerson(@PathVariable("id") int id, Model model){
        Person person = personService.getPerson(id);
        model.addAttribute("person",  person);
        return "person";
    }

    @GetMapping("/new")
    public String saveNewPersonForm(@ModelAttribute("person") Person person){
//        Person person = new Person();
//        model.addAttribute("person", person);
        return "new_person";
    }

    @PostMapping("/save")
    public String saveNewPerson(@ModelAttribute("person") Person person){
        personService.savePerson(person);
        return "redirect:/people";
    }

    @GetMapping("/edit/{id}")
    public String editPersonForm(@PathVariable("id") int id, Model model){
        Person person = personService.getPerson(id);
        model.addAttribute("person", person);
        return "edit_person";
    }

    // need to filter patch, put, delete
//    @PatchMapping("/edit/{id}")
//    public String editPerson(@ModelAttribute("person") Person person, @PathVariable("id") int id){
//        personService.savePerson(person);
    //    personService.update(id, person);
//        return "redirect:/people";
//    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") int id){
        personService.deletePerson(id);
        return "redirect:/people";
    }

//    @DeleteMapping("/delete/{id}")
//    public String del etePerson(@PathVariable("id") int id){
//        personService.deletePerson(id);
//        return "redirect:/people";
//    }
}
