package com.prueba.developer.pruebatecnica.service;

import com.prueba.developer.pruebatecnica.dao.PersonDao;
import com.prueba.developer.pruebatecnica.dto.PersonDto;
import com.prueba.developer.pruebatecnica.entity.PersonEntity;
import com.prueba.developer.pruebatecnica.utils.validate.ValidateDataPerson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
	private ValidateDataPerson validateDataPerson;
	private PersonDao personDao;

	public PersonService(ValidateDataPerson validateDataPerson, PersonDao personDao) {
		this.validateDataPerson = validateDataPerson;
		this.personDao = personDao;
	}

	public void validate(PersonDto personDto) {
		validateDataPerson.validateData(personDto);
	}

	public List<PersonEntity> getListSalary(double salary) {
		return personDao.getListSalary(salary);
	}
}
