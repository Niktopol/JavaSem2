package com.sem2.task2;

import java.time.LocalDate;

public class Human {
    private int age;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private int weight;

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getWeight() {
        return weight;
    }

    public Human(int age, String firstName, String lastName, LocalDate birthDate, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }
    @Override
    public String toString(){
        return String.format("Age: %d, First name: %s, Last name: %s, Birth date: %s, Weight: %d",
                age, firstName, lastName, birthDate.toString(), weight);
    }
}
