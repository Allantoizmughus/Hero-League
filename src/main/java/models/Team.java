package models;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private  String cause;
    private int max_size;
    private static List<Team> instances=new ArrayList<Team>();
    private int id;
    private List<Hero> heros;

    public Team(String name, String cause, int max_size){
        this.name=name;
        this.cause=cause;
        this.max_size=max_size;
        instances.add(this);
        heros=new ArrayList<Hero>();
        id=instances.size();
        heros=new ArrayList<Hero>();
    }
    public int getMaxSize(){
        return max_size;
    }

    public String getName(){
        return name;
    }

    public String getCause(){
        return cause;
    }

    public static List<Team> getAll(){
        return instances;
    }

    public static void clearAllTeams(){
        instances.clear();
    }

    public int getId(){
        return id;
    }
    public static Team find(int id){
        return instances.get(id-1);
    }

    public List<Hero> getHeros(){
        return heros;
    }

    public void addHero(Hero hero) {

        heros.add(hero);
    }


}
