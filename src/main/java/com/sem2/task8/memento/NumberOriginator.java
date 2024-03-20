package com.sem2.task8.memento;

public class NumberOriginator {
    private int currentNumber;

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public NumberOriginator(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public NumberMemento createMemento(){
        return new NumberMemento(currentNumber);
    }

    public void setMemento(NumberMemento memento){
        this.currentNumber = memento.getNumberState();
    }

    @Override
    public String toString(){
        return "Current number is " + currentNumber;
    }
}
