package test.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driver {

  public static WebDriver driver;

  public static void startDriver() {
    String os = System.getProperty("os.name").toLowerCase();
    System.out.println(os);
    if (os.contains("windows")) {
      os = "win.exe";
    }
    else if (os.equals("mac os x")) {
      os = "mac";
    }
    else {
      os = "linux";
    }

    if (driver == null) {
      System.setProperty("webdriver.gecko.driver", "resources/geckodriver_" + os);
      driver = new FirefoxDriver();
    } else {
      System.out.println("Error starting browser(firefox)");
    }
  }
}