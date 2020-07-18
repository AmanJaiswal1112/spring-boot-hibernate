package com.javatechie.spring.orm.api.controller;

import com.javatechie.spring.orm.api.dao.PersonDao;
import com.javatechie.spring.orm.api.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spring-boot-orm")
public class PersonController
{
    @Autowired
    PersonDao personDao;

    @PostMapping("/addPerson")
    public String save(@RequestBody Person person)
    {
        personDao.savePersion(person);
        return "Person added :";
    }

    @GetMapping("/getAll")
    public List<Person> getPersons()
    {
        return personDao.getPersons();
    }
}
