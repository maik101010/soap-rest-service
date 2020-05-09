package com.prueba.developer.pruebatecnica.dto;

import java.io.Serializable;

public class PersonDto implements Serializable {
    private static final long serialVersionUID = -7868921555530898L;
    private String names;
    private String lastNames;
    private String document;
    private String numberDocument;
    private String birthDate;
    private String bonding;
    private String function;
    private Double salary;

    public PersonDto(String names, String lastNames, String document, String numberDocument, String birthDate, String bonding, String function, Double salary) {
        this.names = names;
        this.lastNames = lastNames;
        this.document = document;
        this.numberDocument = numberDocument;
        this.birthDate = birthDate;
        this.bonding = bonding;
        this.function = function;
        this.salary = salary;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(String numberDocument) {
        this.numberDocument = numberDocument;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBonding() {
        return bonding;
    }

    public void setBonding(String bonding) {
        this.bonding = bonding;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void validateData(PersonDto personDto) {

    }
}
