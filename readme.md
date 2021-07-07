Demo Java automation framework
==============================
This educational project was build for basic automation needs. Tech stack: Java, Maven, TestNG; PageObject pattern.

Setting up
----------
1. Make sure Java installed, check `java -version` in console
2. Install or update Chromedriver https://sites.google.com/a/chromium.org/chromedriver/downloads
3. Clone this repository and import pom.xml into your IDE (I use IntelliJ Idea Community edition)
4. Run tests using IDE extension, or you can install Maven and use `mvn test` command.

Comments
--------
This is how I see the simplest Page Object implementation without BDD. We have TestFactory here to set up/tear down WebDriver. Also, it is the base class for inheritance for tests and pages declared here, so we can easily call them in tests.
Page Factory contains constructor to pass WebDriver and Wait to our tests plus common helping methods.

![Bugs!](/src/main/resources/files/bugs.jpg)