package models;

import java.util.ArrayList;

public class Team {
    private String teamName;
    private  String cause;
    private int max_size;
    private static ArrayList<Team> instances=new ArrayList<Team>();
    private int teamId;
    private ArrayList<Hero> teamHeros=new ArrayList<>();

    public Team(String name, String cause, int max_size){
        teamName = name;
        max_size = max_size;
        this.cause = cause;
        this.teamHeros = new ArrayList<>();
        instances.add(this);
        this.teamId = instances.size();
    }
    public int getMaxSize(){
        return max_size=5;
    }

    public String getName(){
        return teamName;
    }

    public String getCause(){
        return cause;
    }

    public static ArrayList<Team> getAll(){
        return instances;
    }

    public static void clearAllTeams(){
        instances.clear();
    }

    public int getId(){
        return teamId;
    }
    public static Team find(int id){
        return instances.get(id-1);
    }

    public ArrayList<Hero> getHeros(){
        return teamHeros;
    }

    public void addHero(Hero hero) {

        teamHeros.add(hero);
    }
    public void clearAllTeamHeros(){ getHeros().clear(); }

    public static Team setUpNewTeam1(){return new Team("Superleague","No Hunger",5);}
    public static Team setUpNewTeam2(){return new Team("Conka","No Racism",5);}



}
