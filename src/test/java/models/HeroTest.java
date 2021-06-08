package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        Hero hero=new Hero("Mafia",25,"Fire Breather","Water");
        assertEquals(true, hero instanceof Hero);
    }

//    @Test
//    public void heroInstantiateWithContent_true() throws Exception{
//        Hero hero=new Hero("Superleague","",25,"Fire Breather","Water",1);
//        assertEquals("Superleague", hero.getContent());
//    }
    @Test
    public void bringsName_true() {
        Hero hero = new Hero("Mafia",25,"Fire Breather","Water");
        assertEquals("Mafia",hero.getName());
    }

    @Test
    public void bringsAge_true(){
        Hero hero=new Hero("Mafia",25,"Fire Breather","Water");
        assertEquals(25,hero.getAge());

    }
    @Test
    public void bringsSuperPowers_true(){
        Hero hero=new Hero("Mafia",25,"Fire Breather","Water");
        assertEquals("Fire Breather",hero.getPower());
    }
    @Test
    public void bringsWeakness_true(){
        Hero hero=new Hero("Mafia",25,"Fire Breather","Water");
        assertEquals("Water",hero.getWeakness());

    }

    @Test
    public void allHerosAreReturned_true(){
        Hero hero=new Hero("Mafia",25,"Fire Breather","Water");
        Hero heroTwo=new Hero("SuperCat",21,"crawls on walls","water");
        assertTrue(Hero.getAll().contains(hero));
        assertTrue(Hero.getAll().contains(heroTwo));
    }
//    @Test
//    public void getId_1(){
//        Hero.clearAllHeros();// Remember, the test will fail without this line! We need to empty leftover Heros from previous tests!
//        Hero hero=new Hero("Mafia",25,"Fire Breather","Water") ;
//        assertEquals(1,hero.getId());
//    }

    @Test
    public void newHero_getId_Int() {
        Hero.clearAllHeros();
        Hero hero = Hero.setUpNewHero1();
        Hero heroTwo = Hero.setUpNewHero2();
        assertEquals(2,heroTwo.getId());
    }


    @Test
    public void find_returnsCorrectHero() throws Exception{
        Hero.clearAllHeros();
        Hero hero=new Hero("Mafia",25,"Fire Breather","Water");
        assertEquals(Hero.find(hero.getId()), hero);
    }

    @Test
    public void findHeroByName_true(){
        Hero.clearAllHeros();
        Hero hero=new Hero("Mafia",25,"Fire Breather","Water");
        assertTrue(Hero.findHeroByName("Mafia"));

    }

    @Test
    public void find_returnsNullWhenNoTaskFound_null() {
        assertTrue(Hero.find(1000) == null);
    }


}