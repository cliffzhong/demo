package com.example.demo.dto;

public class Person {

    private String name;
    private String title;
    private int age;

    private Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.title = personBuilder.title;
        this.age = personBuilder.age;
    }


    //builder Class
    public static class PersonBuilder {

        private String name;
        private String title;
        private int age;

        public PersonBuilder(String name) {
            this.name = name;
        }

//        public PersonBuilder name(String name) {
//            this.name = name;
//            return this;
//        }


        public PersonBuilder title(String title) {
            this.title = title;
            return this;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(this);
        }

    }

}
