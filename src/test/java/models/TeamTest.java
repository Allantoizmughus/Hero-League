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
    public void bring_maxSize_5(){
    }


}