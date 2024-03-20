package com.sem2.task7.facade;

public class CarFacade {
    Car car;
    public CarFacade(Car car){
        this.car = car;
    }
    public int fullDrive(){
        int distance = 0;
        while (car.canDrive()){
            distance += car.driveFroth();
        }
        car.refillFuel();
        System.out.println("Car was driving for: "+distance+" km");
        return distance;
    }
}
