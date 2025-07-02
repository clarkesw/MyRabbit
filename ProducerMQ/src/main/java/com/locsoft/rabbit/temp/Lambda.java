package com.locsoft.rabbit.temp;

import com.locsoft.rabbit.beans.Person;
import java.util.Arrays;
import java.util.List;


public class Lambda {
    public static void main(String[] args) {
//        Integer[] lInt = {2,3,4,5,6};
//        List<Integer> list = Arrays.asList(lInt);
//        List<String> names = Arrays.asList("alice", "bob", "charlie", "david");
// filter out all persons older than 30 and then collect their names into a List<String>

        List<Person> people = Arrays.asList(
            new Person("Alice", 25),
            new Person("Bob", 35),
            new Person("Charlie", 30),
            new Person("David", 40),
            new Person("Eve", 28)
        );
        
        List<String> names = people.stream()
                .filter(p -> p.getAge() > 30)
                .map(p -> p.getName())
                .toList();
        
        System.out.println("Result: " + names);
    }
}
