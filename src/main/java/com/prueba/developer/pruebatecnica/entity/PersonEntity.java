package com.prueba.developer.pruebatecnica.entity;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String names;
    @Column(nullable = false)
    private String lastNames;
    @Column(nullable = false)
    private String document;
    @Column(nullable = false)
    private String numberDocument;
    @Column(nullable = false)
    private String birthDate;
    @Column(nullable = false)
    private String bonding;
    @Column(nullable = false)
    private String function;
    @Column(nullable = false)
    private Double salary;

    public PersonEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
