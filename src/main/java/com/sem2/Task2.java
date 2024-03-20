package com.sem2;

import com.sem2.task2.Human;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Task2 {
    public static List<Human> getPeople(){
        LinkedList<Human> list = new LinkedList<>();
        list.add(new Human(18, "Пётр", "Погода", LocalDate.of(1992, 10, 19), 69));
        list.add(new Human(27, "Арсений", "Амброзин", LocalDate.of(1989, 1, 2), 84));
        list.add(new Human(16, "Дмитрий", "Донской", LocalDate.of(2000, 11, 26), 50));
        list.add(new Human(23, "Алексей", "Античный", LocalDate.of(1990, 11, 14), 76));
        list.add(new Human(40, "Анатолий", "Асинхронный", LocalDate.of(1973, 8, 18), 93));
        return list;
    }
    public static void doThing(){
        List<Human> people = getPeople();
        System.out.println("Сортировка по возрасту в обратном порядке:");
        people.stream().sorted(Comparator.comparingInt(person -> -person.getAge())).forEach(System.out::println);
        System.out.println("Люди с именами на A:");
        people.stream().filter((person) -> person.getFirstName().matches("^А.+")).forEach(System.out::println);
        System.out.println("Сортировка по дате рождения:");
        people.stream().sorted(Comparator.comparingLong(person -> person.getBirthDate().toEpochDay())).forEach(System.out::println);
        System.out.println("Средний вес:");
        System.out.println(people.stream().mapToInt(Human::getWeight).reduce(Integer::sum).getAsInt() / people.stream().count());
    }
}
