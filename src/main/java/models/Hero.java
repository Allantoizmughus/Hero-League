package models;

import java.util.ArrayList;

public class Hero {
    private String name;
    private int age;
    private String power;
    private String weakness;
    private static ArrayList<Hero> instances = new ArrayList<Hero>();
    private int id;


    public Hero(String name,Integer age,String power,String weakness){
        this.name=name;
        this.age=age;
        this.power=power;
        this.weakness=weakness;
        instances.add(this);
        this.id= instances.size();
    }

    public String getName() {
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public String getPower(){
        return this.power;
    }

    public String getWeakness(){
        return this.weakness;
    }

    public static ArrayList<Hero> getAllInstances() {

        return instances;
    }

    public static void clearAllHeros(){
     instances.clear();
    }

    public int getId(){
        return id;
    }

    public static Hero find(int id) {
            return instances.get(id - 1);

    }

    public static boolean findHeroByName(String name){
        boolean isAvailable = false;
        for (int i =0; i<instances.size(); i++)
        {
            if (name.equalsIgnoreCase(instances.get(i).name) )
            {
                isAvailable = true;
            }
        }
        return isAvailable;
    }

    public static Hero setUpNewHero1(){
        return new Hero("Mafia",25,"Fire Breather","Water");
    }
    public static Hero setUpNewHero2(){
        return new Hero("SuperCat",21,"crawls on walls","water");
    }


}
