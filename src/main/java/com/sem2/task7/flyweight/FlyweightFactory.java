package com.sem2.task7.flyweight;

import java.util.HashMap;

public class FlyweightFactory {
    private static HashMap<Character, Flyweight> objectsBuffer = new HashMap<>();

    public static Flyweight getFlyweight(char type){
        Flyweight flyweight = objectsBuffer.get(type);
        if (flyweight == null){
            switch (type){
                case 'A':
                    flyweight = new ObjectTypeA();
                    objectsBuffer.put('A', flyweight);
                    break;
                case 'B':
                    flyweight = new ObjectTypeB();
                    objectsBuffer.put('B', flyweight);
                    break;
                case 'C':
                    flyweight = new ObjectTypeC();
                    objectsBuffer.put('C', flyweight);
                    break;
            }
        }
        return flyweight;
    }
}
