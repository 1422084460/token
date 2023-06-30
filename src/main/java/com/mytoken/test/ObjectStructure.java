package com.mytoken.test;

import java.util.LinkedList;
import java.util.List;

/**
 * description
 *
 * @author lou
 * @create 2023/6/14
 */
public class ObjectStructure {

    private List<Person> persons = new LinkedList<>();

    public void attach(Person person){
        persons.add(person);
    }

    public void detach(Person person){
        persons.remove(person);
    }

    public void display(Action action){
        for (Person person : persons){
            person.accept(action);
        }
    }
}
