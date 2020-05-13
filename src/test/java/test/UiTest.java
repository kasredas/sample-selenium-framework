package test;

import java.io.FileWriter;

import org.junit.Test;
import org.openqa.selenium.By;

import test.actions.Do;

public class UiTest extends Do{

  @Test
  public void uiFlow(){

    startDriver();

    // -------------------//
    // -- Test scenario --//
    // -------------------//

    // Open https://home.openweathermap.org
    Do.navigate("https://home.openweathermap.org");

    // Login to th system
    Do.waitFor("#user_email");
    Do.setText("#user_email", "moyoxay379@jupiterm.com");
    Do.setText("#user_password", "T35TinG45_For/s");
    Do.click("[value='Submit']");
    Do.verifyText(".panel-body","Signed in successfully.");
    Do.verifyText("a.pull-right[href='/']","Hello John Doe");

    // Navigate to  API keys tab
    Do.waitFor("[href='/api_keys']");
    Do.click("[href='/api_keys']");

    // Enter key name and click generate
    Do.waitFor("#api_key_form_name");
    Do.setText("#api_key_form_name", "KeyName");
    Do.waitFor("[value='Generate']");
    Do.click("[value='Generate']");
    
    // Validate if key was created
    Do.waitFor(".panel-body");
    Do.verifyText(".panel-body","API key was created successfully");

    // Click edit and change generated key name and save it
    Do.waitFor("[data-name='KeyName']");
    Do.click("[data-name='KeyName']");
    Do.setText("#edit_key_form_name[name='edit_key_form[name]']", "KeyNameUpdated");
    Do.click("button.btn.btn-orange");

    // Validate if key name was saved
    Do.waitFor(".panel-body");
    Do.verifyText(".panel-body","API key was edited successfully");
    Do.waitFor(".table.api-keys > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2)");
    Do.verifyText(".table.api-keys > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2)","KeyNameUpdated");

    // Save key in to your framework profile
    String keyCodeToSave = driver.findElement(By.cssSelector(".table.api-keys > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(1) > pre:nth-child(1)")).getText();

    try (FileWriter writeFile = new FileWriter("resources/key.txt")) 
    {
      writeFile.append(keyCodeToSave);
    } catch (Exception e) {
      System.out.println("Error accured writing key to file");
    }

    Do.closeBrowser();
    // In real life I would add solution to clear generated keys to start over again with clean data

  }
}
