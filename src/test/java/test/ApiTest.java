package test;

import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ApiTest {

  public static String readKyeCode() throws IOException {
    String secretKey = "";
    FileReader file = new FileReader("resources/key.txt");
    BufferedReader br = new BufferedReader(file);
    secretKey = br.readLine();
    // System.out.println(secretKey);
    br.close();
    return secretKey;
  }

  @Test
  public void givenCityNotExist() throws IOException {

    String secretKey = readKyeCode(); 
    given().
      pathParam("secretKey",secretKey).
    when().
      get("https://api.openweathermap.org/data/2.5/weather?q=JohnDoeCity&appid={secretKey}").
    then().
      assertThat().
      statusCode(404);
  }

  @Test
  public void givenCityExist() throws IOException {

    String secretKey = readKyeCode(); 
    
    given().
      pathParam("secretKey",secretKey).
    when().
      get("https://api.openweathermap.org/data/2.5/weather?q=Vilnius&appid={secretKey}").
    then().
      assertThat().
      statusCode(200).
    and().
      assertThat().
      body("sys.country",equalTo("LT"));
  }

}
