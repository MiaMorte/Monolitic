package com.example.demo5.apı;

import com.example.demo5.model.Person;
import com.example.demo5.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/update")
    public void addperson(@RequestBody Person person){
        personService.saveOrUpdate(person);
    }
    @GetMapping("/all")
    public List<Person> getAllPeople(){
        return personService.getAllPerson();
    }

}
