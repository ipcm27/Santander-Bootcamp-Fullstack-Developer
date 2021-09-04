package controller;

import DTO.MessageResponseDTO;
import entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import repository.PersonRepository;
import service.PersonService;

public class PersonController {

    private PersonService personservice;

    @Autowired
    public PersonController(PersonService personservice) {
        this.personservice = personservice;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person){
        return personservice.createPerson(person);

    }

}
