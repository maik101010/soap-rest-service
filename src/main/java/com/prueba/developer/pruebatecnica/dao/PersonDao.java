package com.prueba.developer.pruebatecnica.dao;

import com.prueba.developer.pruebatecnica.dto.PersonDto;
import com.prueba.developer.pruebatecnica.entity.PersonEntity;
import com.prueba.developer.pruebatecnica.mapper.MapperPerson;
import com.prueba.developer.pruebatecnica.repository.PersonRepository;
import com.prueba.developer.pruebatecnica.utils.validate.ValidateDataPerson;
import com.techprimers.spring_boot_soap_example.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDao implements IPersonRepository {
    private PersonRepository personRepository;

    @Autowired
    public PersonDao(PersonRepository personRepository, ValidateDataPerson validateDataPerson) {
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person personSoap) {
        Person personMapper = MapperPerson.soapToDto(personRepository.save(MapperPerson.toEntity(personSoap)));
        return personMapper;
    }

    public List<PersonEntity> getListSalary(double salary) {
        return personRepository.findBySalaryGreaterThan(salary);
    }
}