package models;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;

public class TeamTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create_instanceofTeam_true(){
        Team team=new Team("Superleague","No Hunger",5);
        assertEquals(true,team instanceof Team);
    }

    @Test
    public void brings_name(){
        Team team=new Team("Superleague","No Hunger",5);
        assertEquals("Superleague",team.getName());
    }

    @Test
    public void brings_cause(){
        Team team=new Team("Superleague","No Hunger",5);
        assertEquals("No Hunger",team.getCause());
    }

    @Test
    public void bring_maxSize_5(){
        Team team=new Team("Superleague","No Hunger",5);
         assertEquals(5,team.getMaxSize());
    }

    @Test
    public void returnsAllTeamsCorrectly(){
        Team team=new Team("Superleague","No Hunger",5);
        Team teamTwo=new Team("Conka","No Racism",5);
        assertTrue(Team.getAll().contains(team));
        assertTrue(Team.getAll().contains(teamTwo));

    }

    @Test
    public void clearAllTeamsCorrectly_0(){
        Team.clear();
        assertEquals(Team.getAll().size(),0);
    }

    @Test
    public void bringsIdOfTeam(){
        Team.clear();
        Team team=new Team("Superleague","No Hunger",5);
        assertEquals(1,team.getId());
    }


}