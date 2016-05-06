import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StylistsTest {

  // @Rule
  // public DatabaseRule database = new DatabaseRule();

  @Test
  public void stylist_instantiatesCorrectly() {
    Stylist newStylist = new Stylist("Robert");
    assertEquals(true, newStylist instanceof Stylist);
  }
}
