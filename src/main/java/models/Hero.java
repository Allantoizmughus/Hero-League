package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Hero {
    private String content;
    private String name;
    private int age;
    private String power;
    private String weakness;
    private static List<Hero> instances = new ArrayList<Hero>();
    private int id;


    public Hero(String content,String name,int age,String power,String weakness,int id){

        this.content=content;
        this.name=name;
        this.age=age;
        this.power=power;
        this.weakness=weakness;
        instances.add(this);
        this.id= instances.size();
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

    public String getPower(){
        return power;
    }

    public String getWeakness(){
        return weakness;
    }

    public static List<Hero> getAll() {

        return instances;
    }

    public static void clearAllHeros(){
     instances.clear();
    }

    public int getId(){
        return id;
    }

    public static Hero find(int id) {
        try {
            return instances.get(id - 1);
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }


}
