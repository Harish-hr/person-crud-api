package com.person.personcrudapi.controllers;

import java.util.List;
import com.person.personcrudapi.beans.PersonDto;
import com.person.personcrudapi.exceptions.RecordNotFoundException;
import com.person.personcrudapi.models.Person;
import com.person.personcrudapi.service.PersonService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@Api(value = "Person Management System")
public class PersonController {

    private PersonService personService;

    @GetMapping("/persons")
    public List<PersonDto> getAllPersons () {
        return personService.findAllPersons();
    }

    @PostMapping("/persons")
    public Person insertPerson(@RequestBody PersonDto personDto) {
        return personService.savePerson(personDto);
    }

    @GetMapping("/persons/{id}")
    public PersonDto getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<Person> deletePersonById(@PathVariable Long id) throws RecordNotFoundException {
        try {
            personService.deletePersonById(id);
        } catch (Exception e) {
            throw new RecordNotFoundException("No Booking record exist for id " +id);
        }
        return new ResponseEntity<Person>(HttpStatus.OK);
    }

    @PutMapping("/persons/{id}")
    public PersonDto updatePersonById(@PathVariable Long id, @RequestBody PersonDto personDto) {
        return personService.updatePersonById(id, personDto);
    }
}
