import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest {

  @Test
  public void Hero_instantiatesCorrectly_true() {
    Hero myHero = new Hero("Superman", 32, "Super strength", "ladies");
    assertEquals(true, myHero instanceof Hero);
  }

   @Test 
  public void Hero_instantiatesWithName_String(){
    Hero myHero = new Hero("Spiderman",17,"fly","ladies");
    assertEquals("Spiderman",myHero.getName());
  }
​
  @Test 
  public void Hero_instantiatesWithAge_Int(){
    Hero myHero = new Hero("Spiderman",17,"fly","ladies");
    assertEquals(30, myHero.getAge());
  }
​
  @Test 
  public void Hero_instantiatesWithPower_String(){
    Hero myHero = new Hero("Spiderman",17,"fly","ladies");
    assertEquals("fly",myHero.getPower());
  }
​
  @Test 
  public void Hero_instantiatesWithWeakness_String(){
    Hero myHero = new Hero("Spiderman",17,"fly","ladies");
    assertEquals("slow",myHero.getWeakness());
  }

}