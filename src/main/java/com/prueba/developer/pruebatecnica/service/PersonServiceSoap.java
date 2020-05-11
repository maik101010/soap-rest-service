package com.prueba.developer.pruebatecnica.service;

import com.prueba.developer.pruebatecnica.dao.IPersonRepository;
import com.prueba.developer.pruebatecnica.utils.validate.ValidateDataPerson;
import com.techprimers.spring_boot_soap_example.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;

@Service
public class PersonServiceSoap {
    private IPersonRepository personRepository;
    private ValidateDataPerson validateDataPerson;

    @Autowired
    public PersonServiceSoap(IPersonRepository personRepository, ValidateDataPerson validateDataPerson) {
        this.personRepository = personRepository;
        this.validateDataPerson = validateDataPerson;
    }

    public Person saveAndGetPerson(Person personSoap) {
        Person person = personRepository.save(personSoap);
        Period periodAge= validateDataPerson.getDateWithParameters(personSoap.getBirthDate());
        Period periodTimeBounding= validateDataPerson.getDateWithParameters(personSoap.getBonding());
        person.setAge(validateDataPerson.converterToDate(periodAge));
        person.setTimeBounding(validateDataPerson.converterToDate(periodTimeBounding));
        return person;
    }
}
