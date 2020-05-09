package com.prueba.developer.pruebatecnica.utils.validate;

import com.prueba.developer.pruebatecnica.dto.PersonDto;
import com.prueba.developer.pruebatecnica.utils.errors.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Component
public class ValidateDataPerson {
    final static String DATE_FORMAT = "yyyy-MM-dd";
    Logger logger = LoggerFactory.getLogger(ValidateDataPerson.class);

    public boolean validateData(PersonDto personDto) {
        if (!validateFormatDate(personDto.getBirthDate(), personDto.getBonding())) {
            throw new BadRequestException("Bad format date");
        }
        return validateFields(personDto.getNames(), personDto.getLastNames(), personDto.getDocument(),
                personDto.getSalary(), personDto.getNumberDocument()) && validateAge(personDto.getBirthDate());
    }

    private boolean validateFields(String names, String lastNames, String document, Double salary, String numberDocument) {
        if (names.equals("") || lastNames.equals("") || document.equals("") || salary <= 0 || numberDocument.equals("")) {
            throw new BadRequestException("Bad format parameters");
        }
        return true;
    }

    private boolean validateAge(String birthDate) {
        Period period = getDateWithParameters(birthDate);
        if (period.getYears() < 18) {
            throw new BadRequestException("Bad age");
        }
        return true;
    }

    public Period getDateWithParameters(String birthDate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDate date = LocalDate.parse(birthDate, dateTimeFormatter);
        LocalDate now = LocalDate.now();
        Period period = Period.between(date, now);
        return period;
    }

    private boolean validateFormatDate(String birthDate, String bonding) {
        try {
            DateFormat dateFormatBirthDate = new SimpleDateFormat(DATE_FORMAT);
            dateFormatBirthDate.setLenient(false);
            dateFormatBirthDate.parse(birthDate);
            DateFormat dateFormatBonding = new SimpleDateFormat(DATE_FORMAT);
            dateFormatBonding.setLenient(false);
            dateFormatBonding.parse(bonding);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public XMLGregorianCalendar converterToDate(Period periodAge) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(periodAge.getYears(), periodAge.getMonths(), periodAge.getDays());
        XMLGregorianCalendar xmlGregorianCalendar=null;
        try {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(calendar.getTime());
            xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        } catch (DatatypeConfigurationException e) {
            logger.error("Error converter date ", e);
        }
        return xmlGregorianCalendar;

    }
}
