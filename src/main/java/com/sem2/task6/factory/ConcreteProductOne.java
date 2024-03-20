package com.sem2.task6.factory;

public class ConcreteProductOne implements Product{
    private String myName;

    public ConcreteProductOne(String myName){
        this.myName = myName;
    }
    @Override
    public void sayMyName() {
        System.out.println("My name is " + myName);
    }
}
