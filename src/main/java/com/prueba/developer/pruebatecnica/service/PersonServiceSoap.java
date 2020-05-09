package com.prueba.developer.pruebatecnica.service;

import com.prueba.developer.pruebatecnica.dao.IPersonRepository;
import com.techprimers.spring_boot_soap_example.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceSoap {
    private final IPersonRepository personRepository;

    @Autowired
    public PersonServiceSoap(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public Person saveAndGetPerson(Person personSoap) {
        return personRepository.save(personSoap);
    }
}
