package com.sem2.task7.facade;

public class Car {
    private Fuel fuel;
    private int speed;

    public Car(Fuel fuel, int speed){
        this.fuel = fuel;
        this.speed = Math.abs(speed);
    }

    public int driveFroth(){
        if(!fuel.isEmpty()){
            fuel.decrease();
            return speed;
        }
        return 0;
    }

    public void refillFuel(){
        fuel.refill();
    }

    public boolean canDrive(){
        return !fuel.isEmpty();
    }
}
