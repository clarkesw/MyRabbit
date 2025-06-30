package com.locsoft.rabbit.beans;

import java.io.Serializable;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable{
    private int id;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
