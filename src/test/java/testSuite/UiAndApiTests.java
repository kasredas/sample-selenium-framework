package testSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.ApiTest;
import test.UiTest;

@RunWith(Suite.class)
@SuiteClasses({
    UiTest.class,
    ApiTest.class
})
public class UiAndApiTests {
    
}