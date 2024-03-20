package com.sem2.task8.observer;

import java.util.ArrayList;

public class NumberSubject implements Subject{

    ArrayList<Observer> observers;

    int numberState;

    public NumberSubject(int numberState){
        observers = new ArrayList<>();
        this.numberState = numberState;
    }

    public int getNumberState() {
        return numberState;
    }

    public void setNumberState(int numberState) {
        this.numberState = numberState;
    }

    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)){
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObs() {
        for(Observer i: observers){
            i.update(numberState);
        }
    }
}
