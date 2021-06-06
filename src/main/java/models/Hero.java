package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Hero {
    private String content;
    private String name;
    private int age;
    private static List<Hero> instances = new ArrayList<Hero>();


    public Hero(String content,String name,int age){

        this.content=content;
        this.name=name;
        this.age=age;
    }

    public String getContent(){
        return content;
    }

    public String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }

}
