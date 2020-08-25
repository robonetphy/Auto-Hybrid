# Auto-Hybride 
##### TestNG and Selenium Based Hybride Automation FrameWork

## New Features!
  
  - Support Handling of general HTML elements like select,radio,checkbox,input and button
  - Can Capture Screenshot at any point
  - Can Work with same TestSteps but with different Data
  - Data can be provide with TestData sheet  
  - TestNG in-built feature report generation

### Tech

Auto-Hybride uses a number of open source projects to work properly:

* [Selenium] - Selenium is a portable framework for testing web applications.
* [TestNG] - TestNG is a testing framework for the Java programming language.
* [Apache POI] - the Java API for Microsoft Documents.
* [Webdriver] - Proxy for using W3C WebDriver-compatible clients to interact with Gecko-based browser.
* [Apache LOG4J] - Apache Log4j is a Java-based logging utility.


### Installation
#####  Install TestNG
#
    > Donwload Latest TestNG from https://github.com/cbeust/testng-eclipse
    > Go to the eclipse installation directory and look for the "dropins" folder there.
    > Create a folder inside the dropins folder and name it as "testng-eclipse-6.11"
    > 6->Major version & 11->Minor version of the TestNG plugin.
    > Copy Downloaded testNG's content 
          >i.e. the “features” and “plugins” folders to testng-eclipse-6.11
#####  Install Selenium,TestNG and POI
#
    > Install Eclipse with JAVA-11
    > Launch Eclipse 
    > Copy Webdriver Folder into Workspace
    > Right Click on Webdriver and Select Properties
    > Select Java Build Path 
    > Select Libraries tab
    > Remove All Red JAR which shows path is not same.
    > Click Add External JAR'S
        -Add All JAR From dependencies/
            >log4j-1.2.17.jar
            >poi-4.1.2/*.jar
            >poi-4.1.2/lib/*.jar
            >poi-4.1.2/ooxml-lib/*/jar
            >selenium-java-3.141.59/*.jar
            >selenium-java-3.141.59/lib/*.jar
    > Click Add Libraries
        > Add TestNG (If TestNG installed perfedctly then option is available ) 
        
#####  Run Script
#
    > Update TestSteps.properties,ScreenShot Path in Xlsx
    > Update Gecko.driver path in WebDriver
    > Update Xlsx Path in WebDriver
    > Run As TestNG 
    > YaY! it's Running 
    > Happy Coding 

#### HTML Report
    > Right Click Project
    > Refresh and check test-output
    > Open index.html in browser
    > Yay! Report is Ready
License
----

MIT


**Free Automation, Hell Yeah!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [Selenium]: <https://www.selenium.dev/>
   [TestNG]: <https://testng.org/doc/>
   [Apache POI]: <https://poi.apache.org/>
   [Webdriver]: <https://firefox-source-docs.mozilla.org/testing/geckodriver/>
   [Apache LOG4J]: <https://logging.apache.org/log4j/1.2/download.html>
   [Eclipse]: <https://www.eclipse.org/downloads/packages/installer>
