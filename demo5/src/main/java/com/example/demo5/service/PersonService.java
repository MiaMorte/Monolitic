package com.example.demo5.service;

import com.example.demo5.dao.PersonDAO;
import com.example.demo5.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    private PersonDAO personDAO;

    public Person saveOrUpdate(Person person){
        return (Person) personDAO.saveOrUpdate(person);
    }
    public List<Person> getAllPerson(){
        return personDAO.findAll(Person.class);
    }

    public Person getPersonById(long id){
        return personDAO.findById(Person.class ,id);
    }
    public boolean deletePerson(Person person){
        boolean isSaved = false;
        try {
            personDAO.delete(person);
            isSaved = true;
        } catch (Exception e) {

        }
        return isSaved;
    }

}
