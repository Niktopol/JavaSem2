package com.sem2.task8.observer;

public class NumberObserver implements Observer{
    String name;
    int numberState;

    public NumberObserver(String name, int numberState) {
        this.name = name;
        this.numberState = numberState;
    }

    @Override
    public void update(Object state) {
        numberState = (Integer) state;
    }

    @Override
    public String toString(){
        return "Observer "+name+" has number state: "+numberState;
    }
}
