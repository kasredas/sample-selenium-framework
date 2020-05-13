# sample-selenium-framework
 Basic selenium framework using maven and junit

## How to run tests
  There is few ways of runing tests
   - VS code with Java test runner plugin (simple and easy)
   - Using maven `<path_to_maven> clean install -Dtest=UiAndApiTests`

## Requirements to run tests on machine
  - Have installed firefox browser (the minimum recommended Firefox version ≥60.)
  - Have java 1.8 or newer installed on machine

### Visual studio code way
 - Install visual studio code (if needed)
 - Install java test runner plugin for vs code [Link for plugin](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-test)
 - Install java (this will be requested by plugin)
 - Open testing framework project
 - Open test (`UiTest.java` or `ApiTest.java` or `UiAndApiTest.java` test suite that contains both tests)
 - Click run test/debug test near `public class`
 - After run plugin will show build status and it's report. [More about reports](#Report)

### Maven way (CLI)
 - Open prefered CLI (under windows 10 navigate to project root directory and press shift + left mouse  and select  `Open PowerShell window here` )
 - Run `.\resources\apache-maven-3.6.3\bin\mvn.cmd clean test -Dtest=UiAndApiTests`
 - System will start executing tests
 - After build CLI will display basic report. [More about reports](#Report)

## Report
 - After each run report will be generated automaticaly
 - Reports located: `sample-selenium-framework\target\surefire-reports`

 ## Basic
 - Framework contains few basic keyword commands
 - Most commands require passing selectors (CUrrently using cssSelectors), right now they work as string, but upgrading those to WebElements would be way more easy to maintain and read code
 - Test do not contain feature of cleaning after themselfs, wich should be implemented in real life scenarios because this might cause unreliable tests