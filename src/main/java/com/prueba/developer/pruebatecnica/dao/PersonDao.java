package com.prueba.developer.pruebatecnica.dao;

import com.prueba.developer.pruebatecnica.mapper.MapperPerson;
import com.prueba.developer.pruebatecnica.repository.PersonRepository;
import com.prueba.developer.pruebatecnica.utils.validate.ValidateDataPerson;
import com.techprimers.spring_boot_soap_example.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Period;

@Component
public class PersonDao implements IPersonRepository {
    private PersonRepository personRepository;
    private ValidateDataPerson validateDataPerson;

    @Autowired
    public PersonDao(PersonRepository personRepository, ValidateDataPerson validateDataPerson) {
        this.personRepository = personRepository;
        this.validateDataPerson = validateDataPerson;
    }

    public PersonDao(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person personSoap) {
        Person personMapper = MapperPerson.soapToDto(personRepository.save(MapperPerson.toEntity(personSoap)));
        Period periodAge= validateDataPerson.getDateWithParameters(personSoap.getBirthDate());
        Period periodTimeBounding= validateDataPerson.getDateWithParameters(personSoap.getBonding());
        personMapper.setAge(validateDataPerson.converterToDate(periodAge));
        personMapper.setTimeBounding(validateDataPerson.converterToDate(periodTimeBounding));
        return personMapper;
    }
}