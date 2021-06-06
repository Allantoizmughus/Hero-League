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
        Hero.clearAllHeros();
    }

    @Test
    public void instanceOfClassCreated_true() throws Exception{
        Hero hero=new Hero("Superleague","",25,"Fire Breather","Water");
        assertEquals(true, hero instanceof Hero);
    }

    @Test
    public void heroInstantiateWithContent_true() throws Exception{
        Hero hero=new Hero("Superleague","",25,"Fire Breather","Water");
        assertEquals("Superleague", hero.getContent());
    }
    @Test
    public void bringsName_true() {
        Hero hero = new Hero("Big crew","Mafia",25,"Fire Breather","Water");
        assertEquals("Mafia",hero.getName());
    }

    @Test
    public void bringsAge_true(){
        Hero hero=new Hero("Big crew","Mafia",25,"Fire Breather","Water");
        assertEquals(25,hero.getAge());

    }
    @Test
    public void bringsSuperPowers_true(){
        Hero hero=new Hero("Big Crew","Mafia",25,"Fire Breather","Water");
        assertEquals("Fire Breather",hero.getPower());
    }
    @Test
    public void bringsWeakness_true(){
        Hero hero=new Hero("Big Crew","Mafia",25,"Fire Breather","Water");
        assertEquals("Water",hero.getWeakness());

    }

    @Test
    public void allHerosAreReturned_true(){
        Hero hero=new Hero("Big Crew","Mafia",25,"Fire Breather","Water");
        Hero heroTwo=new Hero("Believes","SuperCat",21,"crawls on walls","water");
        assertTrue(Hero.getAll().contains(hero));
        assertTrue(Hero.getAll().contains(heroTwo));
    }

}