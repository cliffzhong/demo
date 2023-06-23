package com.example.demo.dto;

public class PersonClient {

    public Person createPerson() {
        Person person = new Person.PersonBuilder("Frank").title("Instructor").build();
        return person;
    }

    public Person createPersonSecond() {
        Person person = new Person.PersonBuilder("Mike").title("Instructor").age(35).build();
        return person;
    }

    public Person createPersonThird() {
        Person person = new Person.PersonBuilder("Joe").title("Manager").build();
        return person;
    }

}
