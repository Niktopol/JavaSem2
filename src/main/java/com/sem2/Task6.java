package com.sem2;

import com.sem2.task6.abstractFactory.AbstractFactory;
import com.sem2.task6.abstractFactory.GenerationSayerFactory;
import com.sem2.task6.abstractFactory.PetSayerFactory;
import com.sem2.task6.factory.ConcreteCreatorOne;
import com.sem2.task6.factory.ConcreteCreatorTwo;
import com.sem2.task6.factory.Creator;
import com.sem2.task6.prototype.Prototype;
import com.sem2.task6.prototype.PrototypeOne;
import com.sem2.task6.prototype.PrototypeTwo;

import java.util.Scanner;

public class Task6 {
    public static void testFactory(){
        Creator[] creators = {new ConcreteCreatorOne(), new ConcreteCreatorTwo()};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name:");
        String name = scanner.next();
        com.sem2.task6.factory.Product[] products = {creators[0].factoryMethod(name), creators[1].factoryMethod(name)};
        products[0].sayMyName();
        products[1].sayMyName();
    }
    public static void testAbstractFactory(){
        AbstractFactory[] abstractFactories = {new GenerationSayerFactory(), new PetSayerFactory()};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name:");
        String name = scanner.next();
        System.out.println("First abstract factory :");
        abstractFactories[0].createProductA().relateToName(name);
        abstractFactories[0].createProductB().relateToName(name);
        System.out.println("Second abstract factory :");
        abstractFactories[1].createProductA().relateToName(name);
        abstractFactories[1].createProductB().relateToName(name);
    }
    public static void testBuilder(){
        System.out.println(new com.sem2.task6.builder.Product.ProductBuilder(6654.65F,"Giraffe")
                .setBig(true).setPopular(true).build());
    }
    public static void testPrototype(){
        Prototype[] prototypes = {new PrototypeOne("PrototypeTwo"), new PrototypeTwo("HGSJ-655")};
        System.out.println(prototypes[0]);
        System.out.println("Clone: "+prototypes[0].clone());
        System.out.println(prototypes[1]);
        System.out.println("Clone: "+prototypes[1].clone());
    }
}
