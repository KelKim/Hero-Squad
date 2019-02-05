import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest {

  @Test
  public void Hero_instantiatesCorrectly_true() {
    Hero myHero = new Hero("Spiderman", 16, "Spider webs", "teenhood");
    assertEquals(true, myHero instanceof Hero);
  }

}