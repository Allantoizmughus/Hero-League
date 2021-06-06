package models;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private  String cause;
    private int max_size;
    private static List<Team> instances=new ArrayList<Team>();

    public Team(String name, String cause, int max_size){
        this.name=name;
        this.cause=cause;
        this.max_size=max_size;
        instances.add(this);
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

}
