package com.sem2;

import com.sem2.task8.memento.NumberMemento;
import com.sem2.task8.memento.NumberOriginator;
import com.sem2.task8.observer.NumberObserver;
import com.sem2.task8.observer.NumberSubject;

public class Task8 {
    public static void testMemento(){
        NumberOriginator originator = new NumberOriginator(10);
        System.out.println(originator);

        NumberMemento memento = originator.createMemento();

        originator.setCurrentNumber(100);
        System.out.println(originator);

        originator.setMemento(memento);
        System.out.println(originator);
    }

    public static void testObserver(){
        NumberSubject subject = new NumberSubject(10);

        NumberObserver observer1 = new NumberObserver("Observer1", 11);
        NumberObserver observer2 = new NumberObserver("Observer2", 12);
        NumberObserver observer3 = new NumberObserver("Observer3", 13);
        System.out.println(observer1);
        System.out.println(observer2);
        System.out.println(observer3);
        subject.attach(observer1);
        subject.attach(observer2);
        subject.attach(observer3);

        subject.setNumberState(100);
        subject.notifyObs();

        System.out.println(observer1);
        System.out.println(observer2);
        System.out.println(observer3);

        subject.detach(observer1);

        subject.setNumberState(1000);
        subject.notifyObs();

        System.out.println(observer1);
        System.out.println(observer2);
        System.out.println(observer3);
    }
}
