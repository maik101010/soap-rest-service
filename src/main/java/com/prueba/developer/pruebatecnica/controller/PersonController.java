package com.prueba.developer.pruebatecnica.controller;

import com.prueba.developer.pruebatecnica.dto.PersonDto;
import com.prueba.developer.pruebatecnica.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private static final String SERVICE_SOAP_URL = "http://localhost:8080/soapWS";
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<String> create(@RequestBody PersonDto personDto) {
        personService.validate(personDto);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_XML);
        String soapFormatString = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                "                  xmlns:ns2=\"http://techprimers.com/spring-boot-soap-example\">\n" +
                "    <soapenv:Header/>\n" +
                "    <soapenv:Body>\n" +
                "        <ns2:getPersonRequest>\n" +
                "        \t<ns2:person>\n" +
                "                <ns2:names>" + personDto.getNames() + "</ns2:names>\n" +
                "                <ns2:lastNames>" + personDto.getLastNames() + "</ns2:lastNames>\n" +
                "                <ns2:document>" + personDto.getDocument() + "</ns2:document>\n" +
                "                <ns2:numberDocument>" + personDto.getNumberDocument() + "</ns2:numberDocument>\n" +
                "                <ns2:birthDate>" + personDto.getBirthDate() + "</ns2:birthDate>\n" +
                "                <ns2:bonding>" + personDto.getBonding() + "</ns2:bonding>\n" +
                "                <ns2:function>" + personDto.getFunction() + "</ns2:function>\n" +
                "                <ns2:salary>" + personDto.getSalary() + "</ns2:salary>\n" +
                "            </ns2:person>\n" +
                "        </ns2:getPersonRequest>\n" +
                "    </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> requestBody = new HttpEntity<>(soapFormatString, headers);
        ResponseEntity<String> getPersonRequestResponseEntity = restTemplate.postForEntity(SERVICE_SOAP_URL, requestBody, String.class);

        return getPersonRequestResponseEntity;
    }

}
