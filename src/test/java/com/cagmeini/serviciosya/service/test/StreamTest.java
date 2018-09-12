package com.cagmeini.serviciosya.service.test;

import java.util.ArrayList;
import java.util.List;

public class StreamTest {

    public static void main (String[] asrgs){
        List<Simpson> list = new ArrayList<>();
        list.add(new Simpson( "Homer","Simpson",34));
        list.add(new Simpson( "Marge","Simpson",30));
        list.add(new Simpson( "Bart","Simpson",14));
        list.add(new Simpson( "Lisa","Simpson",12));
        list.add(new Simpson( "Maggie","Simpson",1));

        List<Simpson> a = new ArrayList<>();
        List<Simpson> b = new ArrayList<>();

        for (Simpson item: list){
            if(item.getAge()>=18){
                a.add(item);
            }
            else{
                b.add(item);
            }
        }




    }
}

class Simpson {
    private String name;

    private String LastName;

    private int age;

    public Simpson(String name, String lastName, int age) {
        this.name = name;
        LastName = lastName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}