# singtelcodingtest
Source code for "TODO" MVC testing using Cucumber BDD and TestNG

Steps to run the test suite:

1) Download or clone the project from https://github.com/iswaryasr/singtelcodingtest/tree/master to your local machine
2) Import the project using editors like Eclipse or Intellij from the downloaded path
3) Once Maven successfully builds all the required jars from the dependency file pom.xml, run the class CucumberTestRunner.java 
4) This will open the chrome browser automatically and execute the test cases
5) A separate folder "Reports" is created in the repository and the cucumber test reports are updated in TestReports.html which can be viewed using any browser.
6) Under src/test/resources, there is a file "config.properties" created to configure properties like browser and URL.
7) Change the default browser from "chrome" to "firefox" to run the test suite in firefox browser.

