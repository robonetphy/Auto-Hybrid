package samplePackage;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;

public class Keywords {

	static FirefoxDriver driver;
	static Properties prop;
	static FileInputStream input;
	public void openbrowser(String objectFilePath) throws IOException  {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		prop = new Properties();
		input =	new FileInputStream(objectFilePath);
		prop.load(input);
	}
	
	public void input(String testData, String objectName) {
		driver.findElement(By.xpath(prop.getProperty(objectName))).sendKeys(testData);
		
	}
	
	public void navigate(String testData) {
		driver.get(testData);
	}
	
	public void click(String objectName)  {
		driver.findElement(By.xpath(prop.getProperty(objectName))).click();
		
	}

	public void selectlist(String testData, String objectName) {
		Select select = new Select(driver.findElement(By.xpath(prop.getProperty(objectName))));
		select.selectByVisibleText(testData);
	}

	public String verifypagetitle(String expectedTestData) {
		String actualValue  = driver.getTitle();
		return actualValue;
	}

	public String verifyeditboxtext(String expectedTestData, String objectName) {
		String actualValue = driver.findElement(By.xpath(prop.getProperty(objectName))).getAttribute("value");
		return actualValue;
	}

	public String verifypagetext(String expectedTestData, String objectName) {
		String actualValue = driver.findElement(By.xpath(prop.getProperty(objectName))).getText();
		return actualValue;
	}
	public void screenshot(String objectName) throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile, new File(objectName));
	}
}
