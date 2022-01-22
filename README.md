# UpWork Test - QA Engineer

## Setup
1. Project uses Java 8

By running `java --version` on a terminal you can check your java version.

2. Make sure to install all dependencies listed in the `pom.xml` file by using maven.

Project runs fine with maven version `3.6.1`. By running `mvn --version` on a terminal you can check your maven version.
Run `mvn install` to get all the required dependencies.

3. Open the project using your favorite IDE and execute the TestRunner class under `src/test/java`.

## Project Structure

### Browser Factory
The browser factory design pattern allows to easily configure and maintain the WebDriver object across the different tests. 
Making tests isolated from WebDriver managing responsibilities. Plus the WebDriverManager library in a fully automated way
 downloads and setups the drivers required by Selenium WebDriver (e.g., chromedriver, geckodriver, msedgedriver, etc.).
 So the need of adding binaries to the project and specifying paths is no longer required.

All the Browser Factory design logic is implemented in the `utils.driver` package (inside src/test/java).

### Page Object Model
POM is a popular test automation design pattern that enhances test maintenance and reduce code duplication 
by creating page objects as an object-oriented class that serves as an interface to a page of your application under test.

All the POM design logic is implemented in the `page_model` package.

### Cucumber
Cucumber is a BDD tool that promotes collaboration by providing executable specifications that are easy to read to all stakeholders 
regardless of their technical skills.

The UpWork test scenario is located under the test resources folder and describes the problem to solve. These steps become 
executable by the implementation of steps definitions, methods that are located in the `steps` package and that matcht the content
of the feature steps.

The project supports tests execution using Chrome and Firefox. Make sure to specify the browser you want to use by changing the 
browser variable in the gherkin scenario (Upwork.feature). Sear keyword is also a variable so you can use any search keyword you want, feel
free to try different search options.




