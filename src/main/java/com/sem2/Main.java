package com.sem2;

import com.sem2.task3.MySyncronizedList;
import com.sem2.task3.SemaphoreSet;
import com.sem2.task4.MyExecutorService;
import com.sem2.task5.EnumSingleton;
import com.sem2.task5.HolderSingleton;
import com.sem2.task5.LazySingleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("I`m working");
        /*
        Scanner scanner = new Scanner(System.in);
        int task;
        while (true){
            System.out.println("Enter task number: ");
            task = scanner.nextInt();
            switch (task){
                case (1) ->{
                    Task1 task1 = new Task1();
                    System.out.println(task1.compare(scanner.next(),scanner.next()));
                }
                case (2) ->{
                    Task2.doThing();
                }
                case (3) ->{
                    SemaphoreSet<Integer> set = new SemaphoreSet<>();
                    ArrayList<Thread> threads = new ArrayList<>();
                    for(int i = 0; i < 5; i++){
                        threads.add(new Thread(
                                ()->{
                                    for(int j = 0; j < 100; j++) {
                                        set.add(j);
                                    }
                                }
                        ));
                    }
                    threads.forEach(Thread::start);
                    threads.forEach((thread) -> {
                        try{
                            thread.join();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    });
                    System.out.println("Size of Set: " + set.size());
                    MySyncronizedList<Integer> lst = new MySyncronizedList<>();
                    threads.clear();
                    for(int i = 0; i < 3; i++){
                        threads.add(new Thread(
                                ()->{
                                    for(int j = 0; j < 3; j++) {
                                        lst.add(j);
                                    }
                                }
                        ));
                    }
                    threads.forEach(Thread::start);
                    threads.forEach((thread) -> {
                        try{
                            thread.join();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    });
                    System.out.println(Arrays.toString(lst.toArray()));
                    Executors.newFixedThreadPool(3);
                }
                case (4) ->{
                    MyExecutorService service = new MyExecutorService(3);
                    service.execute(() -> {System.out.println("Hi");});
                    service.execute(() -> {System.out.println("Hello");});
                    service.execute(() -> {System.out.println("Good day");});
                }
                case (5) ->{
                    LazySingleton.getInstance().sayWord();
                    EnumSingleton.INSTANCE.sayWord();
                    HolderSingleton.getInstance().sayWord();
                }
                case (6) ->{
                    Task6.testFactory();
                    Task6.testAbstractFactory();
                    Task6.testBuilder();
                    Task6.testPrototype();
                }
                case (7) ->{
                    Task7.testFacade();
                    Task7.testFlyweight();
                }
                case (8) ->{
                    Task8.testMemento();
                    Task8.testObserver();
                }
                default -> {
                    return;
                }
            }
        }*/
    }
}