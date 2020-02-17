package com.person.personcrudapi.service;

import java.util.List;
import java.util.stream.Collectors;
import com.person.personcrudapi.beans.PersonDto;
import com.person.personcrudapi.models.Person;
import com.person.personcrudapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;

    public List<PersonDto> findAllPersons() {
        return personRepository.findAll()
                .stream()
                .map(person -> PersonDto.builder()
                        .firstName(person.getFirstName())
                        .lastName(person.getLastName())
                        .age(person.getAge())
                        .favouriteColor(person.getFavouriteColor())
                        .hobby(person.getHobby())
                        .build()
                )
                .collect(Collectors.toList());
    }

    public Person savePerson(PersonDto personDto) {
        Person person = buildPersonForInsertingIntoTable(personDto);
        return personRepository.saveAndFlush(person);
    }

    private Person buildPersonForInsertingIntoTable(PersonDto personDto) {
        return Person.builder()
                .firstName(personDto.getFirstName())
                .lastName(personDto.getLastName())
                .age(personDto.getAge())
                .favouriteColor(personDto.getFavouriteColor())
                .hobby(personDto.getHobby())
                .build();

    }

    public PersonDto getPersonById(Long id) {
        Person retrievedPerson = personRepository.findById(id).get();
        return buildPersonDtoForRetrievedPerson(retrievedPerson);
    }

    private PersonDto buildPersonDtoForRetrievedPerson(Person retrievedPerson) {
        return PersonDto.builder()
                .firstName(retrievedPerson.getFirstName())
                .lastName(retrievedPerson.getLastName())
                .age(retrievedPerson.getAge())
                .favouriteColor(retrievedPerson.getFavouriteColor())
                .hobby(retrievedPerson.getHobby())
                .build();
    }

    public void deletePersonById(Long id){
            personRepository.deleteById(id);
    }

    public PersonDto updatePersonById (Long id, PersonDto personDto) {
        Person retrievedPerson = personRepository.findById(id).get();
        Person updatedPerson = updatePerson(retrievedPerson, personDto);
        PersonDto personDtoResponse = buildPersonDtoResponse(updatedPerson);
        return personDtoResponse;
    }

    private PersonDto buildPersonDtoResponse(Person updatedPerson) {
        return PersonDto.builder()
                .firstName(updatedPerson.getFirstName())
                .lastName(updatedPerson.getLastName())
                .age(updatedPerson.getAge())
                .favouriteColor(updatedPerson.getFavouriteColor())
                .hobby(updatedPerson.getHobby())
                .build();
    }

    private Person updatePerson(Person retrievedPerson, PersonDto personDto) {
        retrievedPerson.setFirstName(personDto.getFirstName());
        retrievedPerson.setLastName(personDto.getLastName());
        retrievedPerson.setAge(personDto.getAge());
        retrievedPerson.setFavouriteColor(personDto.getFavouriteColor());
        retrievedPerson.setHobby(personDto.getHobby());
        personRepository.save(retrievedPerson);
        return retrievedPerson;
    }
}
