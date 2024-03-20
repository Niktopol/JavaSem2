package com.sem2.task6.abstractFactory;

public class DogSayerProduct implements AbstractProduct{
    @Override
    public void relateToName(String name) {
        System.out.println("My dog`s name is "+name);
    }
}
