package models;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void instanceOfClassCreated_true() throws Exception{
        Hero hero=new Hero("Superleague","",25);
        assertEquals(true, hero instanceof Hero);
    }

    @Test
    public void heroInstantiateWithContent_true() throws Exception{
        Hero hero=new Hero("Superleague","",25);
        assertEquals("Superleague", hero.getContent());
    }
    @Test
    public void bringsName_true() {
        Hero hero = new Hero("Big crew","Mafia",25);
        assertEquals("Mafia",hero.getName());
    }

    @Test
    public void bringsAge_true(){
        Hero hero=new Hero("Big crew","Mafia",25);
        assertEquals(25,hero.getAge());

    }

}