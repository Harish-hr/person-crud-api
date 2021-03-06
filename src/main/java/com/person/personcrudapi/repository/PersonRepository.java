package com.person.personcrudapi.repository;

import com.person.personcrudapi.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
