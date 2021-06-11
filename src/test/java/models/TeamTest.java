package models;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        assertTrue(team instanceof Team);
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
        assertTrue(Team.getInstances().contains(team));
        assertTrue(Team.getInstances().contains(teamTwo));
    }

    @Test
    public void clearAllTeamsCorrectly_0(){
        Team.clearAllTeams();
        assertEquals(Team.getInstances().size(),0);
    }

    @Test
    public void bringsIdOfTeam(){
        Team.clearAllTeams();
        Team team=new Team("Superleague","No Hunger",5);
        assertEquals(1,team.getId());
    }

    @Test
    public void find_TeamWithId(){
        Team.clearAllTeams();
        Team team=new Team("Superleague","No Hunger",5);
        assertEquals(Team.findById(team.getId()),team);
    }

    @Test
    public void getTeam_initiallyReturnsEmptyArrayList_0(){
        Team.clearAllTeams();
        Team team=new Team("Superleague","No Hunger",5);
        assertEquals(0,team.getHeros().size());
    }

//    @Test
//    public void addHerosToTeam(){
//        Team team=new Team("Superleague","No Hunger",5);
//        Hero hero=new Hero("Mafia",25,"Fire Breather","Water") ;
//        team.addHero(hero);
//        assertTrue(team.getHeros().contains(hero));
//
//    }


    @Test
    public void addMember_addsMemberToSquad_Hero(){
        Hero newHero = Hero.setUpNewHero1();
        Team testTeam = Team.setUpNewTeam1();
        Team newTeam = Team.findById(1);
        newTeam.clearAllTeamHeros();
        newTeam.getHeros().add(newHero);
        newTeam.getHeros().add(newHero);
        assertEquals(2,newTeam.getHeros().size());
    }

    @Test
    public void setNewMember_hero(){
        Hero.clearAllHeros();
        Hero newHero = Hero.setUpNewHero1();
        Team testTeam = Team.setUpNewTeam1();
        testTeam.addHero(newHero);

        assertEquals(1,testTeam.getHeros().get(0).getId());
    }

}