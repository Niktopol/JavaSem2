package com.sem2.task8.observer;

public interface Subject{
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObs();
}
