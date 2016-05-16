import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void stylist_instantiatesCorrectly() {
    Stylist newStylist = new Stylist("Robert");
    assertEquals(true, newStylist instanceof Stylist);
  }
  @Test
  public void getName_returnsNameOfStylist_String() {
    Stylist newStylist = new Stylist("Bobby");
    assertEquals("Bobby", newStylist.getName());
  }
  @Test
  public void all_emptyAtFirst() {
    assertEquals(Stylist.all().size(), 0);
  }
  @Test
  public void equals_returnsTrueIfBothNamesAreTheSame_True() {
    Stylist firstStylist = new Stylist("Robert");
    Stylist secondStylist = new Stylist("Robert");
    assertTrue(firstStylist.equals(secondStylist));
  }
  @Test
  public void save_savesInstanceToDBWithId_True() {
    Stylist newStylist = new Stylist("Roberto");
    newStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(newStylist.getId(), savedStylist.getId());
  }
  @Test
  public void find_returnsCorrectInstanceOfStylist_True() {
    Stylist newStylist = new Stylist("Roberto Jr/Sr II");
    newStylist.save();
    Stylist foundStylist = Stylist.find(newStylist.getId());
    assertTrue(newStylist.equals(foundStylist));
  }

  @Test
  public void allStylistClients_returnsClientListOfStylist_String() {
    Stylist newStylist = new Stylist("Robby");
    newStylist.save();
    Client newClient = new Client("Billy", newStylist.getId());
    newClient.save();
    assertEquals(newClient, newStylist.allStylistClients().get(0));
  }
}
