package samplePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebdriverDemo {
	public static void main(String[] args) {
		 // declaration and instantiation of objects/variables
    	System.setProperty("webdriver.gecko.driver","/home/robro/Downloads/testing/geckodriver-v0.26.0-linux64/geckodriver");
		
    	ReadXSL read= new ReadXSL();
    	try {
    	read.runLeadTest();
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
	}

}
