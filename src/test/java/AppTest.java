import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Hair Salon");
  }
  @Test
  public void addStylistLinkFunctions() {
    goTo("http://localhost:4567/");
    click("a", withText("Add A New Stylist"));
    assertThat(pageSource()).contains("Add a Stylist");
  }
  @Test
  public void addedStylistSaves() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Stylist"));
    fill("#stylistInput").with("Robert");
    submit(".btn-info");
    assertThat(pageSource()).contains("Robert");
  }
  @Test
  public void addedClientSavesToStylistList() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Stylist"));
    fill("#stylistInput").with("Robert");
    submit(".btn", withText("Add"));
    click("a", withText("Robert"));
    fill("#clientInput").with("William");
    submit(".btn-info");
    assertThat(pageSource()).contains("William");
  }
}
