package com.sem2.task6.factory;

public class ConcreteProductTwo implements Product{
    private String notMyName;

    public ConcreteProductTwo(String notMyName){
        this.notMyName = notMyName;
    }
    @Override
    public void sayMyName() {
        System.out.println("My name is not " + notMyName);
    }
}
