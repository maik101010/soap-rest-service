package com.prueba.developer.pruebatecnica.mapper;

import com.prueba.developer.pruebatecnica.entity.PersonEntity;
import com.techprimers.spring_boot_soap_example.Person;
import org.springframework.stereotype.Component;

@Component
public class MapperPerson {
    private MapperPerson() {
    }

    public static Person soapToDto(PersonEntity entity) {
        return new Person(entity.getNames(), entity.getLastNames(), entity.getDocument(),
                entity.getNumberDocument(), entity.getBirthDate(), entity.getBonding(), entity.getFunction(),
                entity.getSalary());
    }

    public static PersonEntity toEntity(Person personSoap) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setNames(personSoap.getNames());
        personEntity.setLastNames(personSoap.getLastNames());
        personEntity.setDocument(personSoap.getDocument());
        personEntity.setNumberDocument(personSoap.getNumberDocument());
        personEntity.setBirthDate(personSoap.getBirthDate());
        personEntity.setBonding(personSoap.getBonding());
        personEntity.setFunction(personSoap.getFunction());
        personEntity.setSalary(personSoap.getSalary());
        return personEntity;
    }

    }
