package com.sem2.task7.facade;

public class Fuel {
    int maxCap;
    int curCap;
    public Fuel(int maxCap){
        this.maxCap = Math.abs(maxCap);
        curCap = maxCap;
    }
    public boolean isEmpty(){
        return curCap == 0;
    }
    public void decrease(){
        if (curCap > 0){
            curCap--;
        }
    }
    public void refill(){
        curCap = maxCap;
    }
}
