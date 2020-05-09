package com.prueba.developer.pruebatecnica.endpoint;

import com.prueba.developer.pruebatecnica.service.PersonServiceSoap;
import com.techprimers.spring_boot_soap_example.GetPersonRequest;
import com.techprimers.spring_boot_soap_example.GetPersonResponse;
import com.techprimers.spring_boot_soap_example.Person;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PersonEndpoint {

    private PersonServiceSoap personServiceSoap;

    public PersonEndpoint(PersonServiceSoap personServiceSoap) {
        this.personServiceSoap = personServiceSoap;
    }

    @PayloadRoot(namespace = "http://techprimers.com/spring-boot-soap-example",
            localPart = "getPersonRequest")
    @ResponsePayload
    public GetPersonResponse getPersonRequest(@RequestPayload GetPersonRequest request) {
        GetPersonResponse response = new GetPersonResponse();
        Person person = new Person(request.getPerson().getNames(), request.getPerson().getLastNames(),
                request.getPerson().getDocument(),
                request.getPerson().getNumberDocument(), request.getPerson().getBirthDate(),
                request.getPerson().getBonding(), request.getPerson().getFunction(),
                request.getPerson().getSalary());
        response.setPerson(personServiceSoap.saveAndGetPerson(person));
        return response;
    }
}
