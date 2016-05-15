import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void client_instantiatesCorrectly() {
    Client newClient = new Client("William", 1);
    assertEquals(true, newClient instanceof Client);
  }
  @Test
  public void getName_returnsNameOfClient_String() {
    Client newClient = new Client("Will", 1);
    assertEquals("Will", newClient.getName());
  }
  @Test
  public void getStylistId_returnsTrueIfStylistIdIsOne_True() {
    Client newClient = new Client("Will", 1);
    assertEquals(1, newClient.getStylistId());
  }
  @Test
  public void all_emptyAtFirst() {
    assertEquals(Client.all().size(), 0);
  }
  @Test
  public void equals_returnsTrueIfBothNamesAreTheSame_True() {
    Client firstClient = new Client("Bill", 1);
    Client secondClient = new Client("Bill", 1);
    assertTrue(firstClient.equals(secondClient));
  }
  @Test
  public void save_savesClients_2() {
    Client firstClient = new Client("Billy", 1);
    Client secondClient = new Client("Billiam", 1);
    firstClient.save();
    secondClient.save();
    assertEquals(Client.all().size(), 2);
  }
  @Test
  public void find_returnsCorrectInstanceOfClient_True() {
    Client newClient = new Client("Willy", 1);
    newClient.save();
    Client foundClient = Client.find(newClient.getId());
    assertTrue(newClient.equals(foundClient));
  }
}
