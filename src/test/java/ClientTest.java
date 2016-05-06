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
}
