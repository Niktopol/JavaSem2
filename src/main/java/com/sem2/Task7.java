package com.sem2;

import com.sem2.task7.facade.CarFacade;
import com.sem2.task7.facade.Car;
import com.sem2.task7.facade.Fuel;
import com.sem2.task7.flyweight.FlyweightFactory;

public class Task7 {
    public static void testFacade(){
        CarFacade carFacade = new CarFacade(new Car(new Fuel(20), 30));
        carFacade.fullDrive();
    }
    public static void testFlyweight(){
        FlyweightFactory.getFlyweight('A').printIdentity();
        FlyweightFactory.getFlyweight('B').printIdentity();
        FlyweightFactory.getFlyweight('C').printIdentity();
        FlyweightFactory.getFlyweight('A').printIdentity();
    }
}
