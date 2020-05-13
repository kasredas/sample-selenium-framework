package test.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class Do extends driver {

  public static void navigate(String url) {
    driver.get(url);
  }

  public static void waitFor(String cssSelector) {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
  }

  public static void setText(String cssSelector, String text) {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
    driver.findElement(By.cssSelector(cssSelector)).clear();
    driver.findElement(By.cssSelector(cssSelector)).sendKeys(text);
  }

  public static void click(String cssSelector) {
    driver.findElement(By.cssSelector(cssSelector)).click();
  }

  public static void verifyText(String cssSelector, String text) {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
    String getText = driver.findElement(By.cssSelector(cssSelector)).getText();
    assertEquals(text, getText);
  }

  public static void closeBrowser() {
    driver.close();
  }

}