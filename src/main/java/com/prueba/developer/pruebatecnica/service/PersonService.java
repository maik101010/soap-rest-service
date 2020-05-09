package com.prueba.developer.pruebatecnica.service;

import com.prueba.developer.pruebatecnica.dto.PersonDto;
import com.prueba.developer.pruebatecnica.utils.validate.ValidateDataPerson;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	private ValidateDataPerson validateDataPerson;

	public PersonService(ValidateDataPerson validateDataPerson) {
		this.validateDataPerson = validateDataPerson;
	}

	public void validate(PersonDto personDto) {
		validateDataPerson.validateData(personDto);
	}
}
