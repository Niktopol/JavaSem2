package com.sem2.task6.abstractFactory;

public class PetSayerFactory implements AbstractFactory{
    @Override
    public AbstractProduct createProductA() {
        return new DogSayerProduct();
    }

    @Override
    public AbstractProduct createProductB() {
        return new CatSayerProduct();
    }
}
