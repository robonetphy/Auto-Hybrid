package samplePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebdriverDemo
{
	FileInputStream file;
	XSSFWorkbook workbook;
	
	@BeforeSuite
	public void setSystemPropertyDriver() {
		System.setProperty("webdriver.gecko.driver","/home/robro/Downloads/testing/geckodriver-v0.26.0-linux64/geckodriver");
		System.out.println("[INFO_MSG] Initializing Gecko Driver");
	}
	
	@BeforeTest
	public void xlsxSheetInitialization() {
		
		
		try {
			file = new FileInputStream("/home/robro/Downloads/testing/TestSuite.xlsx");
			workbook  = new XSSFWorkbook(file);
	    	}
	    	catch(Exception e)
	    		{
	    		System.out.println(e);
	    		System.out.println("[ERROR_MSG] File Can't Accessed:");
	    	}
		System.out.println("[INFO_MSG] File Successfully Accessed:");
		int NumberOfSheets=workbook.getNumberOfSheets();
		System.out.println("[INFO_MSG] Number Of Sheets:"+NumberOfSheets);
		for(int i=0;i<NumberOfSheets;i++)
		{
			System.out.println("[INFO_MSG] At index "+i+" Sheet Name : "+workbook.getSheetName(i));
		}
	}
	
	 @DataProvider (name = "xlsxDataProvider")
	 public Iterator<Object[]> xlsxDataProvider(){
		 
		 
		 XSSFSheet moduleSheet=workbook.getSheet("Module");
		 Iterator moduleRows = moduleSheet.iterator();
		 if(moduleRows.hasNext())
			moduleRows.next();
		 
		 ArrayList<Object> moduleSheetData = new ArrayList<Object>();
		 
		 while (moduleRows.hasNext()) {
				
				Row moduleRowIterator = (Row)  moduleRows.next();
				Iterator moduleCellItr = moduleRowIterator.cellIterator();
				while (moduleCellItr.hasNext()) {
					Cell moduleCell = (Cell) moduleCellItr.next();	
					switch (moduleCell.getCellType()) {
					case STRING:
						moduleSheetData.add(moduleCell.getStringCellValue());
					    break;
					case BOOLEAN:
						moduleSheetData.add(moduleCell.getBooleanCellValue());
					    break;
					case NUMERIC:
						moduleSheetData.add(moduleCell.getNumericCellValue());
					    break;
					
					}
				}
		 }
		 
		 
		 ArrayList<Object[]> data = new ArrayList<Object[]>();
		 for(int moduleDataIterator=0;moduleDataIterator<moduleSheetData.size();moduleDataIterator+=4) {
			if(moduleSheetData.get(moduleDataIterator+3).equals("Y")) {
				
				
				
				System.out.print("[INFO_MSG] [Test Module] ");
				System.out.print(moduleSheetData.get(moduleDataIterator)+" ");
				System.out.print(moduleSheetData.get(moduleDataIterator+1)+" ");
				System.out.println(moduleSheetData.get(moduleDataIterator+2)+" ");
				
				
				XSSFSheet sheet=workbook.getSheet(moduleSheetData.get(moduleDataIterator+2).toString());
				Iterator row = sheet.iterator();
				//Skip first Line
				if(row.hasNext())
					row.next();
				while (row.hasNext()) {
					
					Row rowIterator = (Row) row.next();
					Iterator cellItr = rowIterator.cellIterator();
					ArrayList<Object>subdata=new ArrayList<Object>();
					
					
					while (cellItr.hasNext()) {
						Cell cell = (Cell) cellItr.next();	
						switch (cell.getCellType()) {
						case STRING:
							subdata.add(cell.getStringCellValue());
							break;
						case BOOLEAN:
							subdata.add(cell.getBooleanCellValue());
							break;
						case NUMERIC:
							subdata.add(cell.getNumericCellValue());
							break;
							
						}
					}
					
					if(subdata.get(subdata.size()-1).equals("Y"))
					{
						subdata.remove(subdata.size()-1);
						subdata.add(moduleSheetData.get(moduleDataIterator+1).toString());
						data.add(subdata.toArray());
					}
				}
			
			
			
			
			}
		 }
		 
		 
		 
		 
			
			System.out.println("[INFO_MSG] DATA");
			for(int i=0;i<data.size();i++)
				{   
					System.out.print("[INFO_MSG] [DataReader]");
					for(int j=0;j<data.get(i).length;j++) {
						System.out.print(data.get(i)[j]);
					    System.out.print(" ");
					}
					System.out.println();
				}
	     return data.iterator();
	 }
	 
    @Test (dataProvider = "xlsxDataProvider")
    public void myTest (Object[] data) {
    	System.out.print("[INFO_MSG] [Test Data] ");
    	for(int j=0;j<data.length;j++) {
			System.out.print(data[j]);
		    System.out.print(" ");
		}
    	System.out.println();
    	
    	
    	ReadXSL read= new ReadXSL();
    		try {
    			read.runLeadTest(workbook.getSheet(data[data.length-1].toString()),data);
    		}
    		catch(Exception e)
    		{
    			System.out.println(e);
    			System.out.println("[ERROR_MSG] ReadXSL Object Crashed:");
    		}
    		System.out.println("[INFO_MSG] Successfully TestCase Completed:");
    	
    }
}
/*
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebdriverDemo {
	public static void main(String[] args) throws IOException {
		 // declaration and instantiation of objects/variables
		FileInputStream file = new FileInputStream("/home/robro/Downloads/testing/TestSuite.xlsx");
		XSSFWorkbook workbook  = new XSSFWorkbook(file);
		System.out.println("[INFO_MSG] File Successfully Accessed:");
		int NumberOfSheets=workbook.getNumberOfSheets();
		System.out.println("[INFO_MSG] Number Of Sheets:"+NumberOfSheets);
		for(int i=0;i<NumberOfSheets;i++)
		{
			System.out.println("[INFO_MSG] At index "+i+" Sheet Name : "+workbook.getSheetName(i));
		}
		XSSFSheet sheet=workbook.getSheet("TestData");
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		Iterator row = sheet.iterator();
		//Skip first Line
		if(row.hasNext())
			row.next();
		while (row.hasNext()) {
			
			Row rowIterator = (Row) row.next();
			Iterator cellItr = rowIterator.cellIterator();
			ArrayList<Object>subdata=new ArrayList<Object>();
			while (cellItr.hasNext()) {
				Cell cell = (Cell) cellItr.next();	
				switch (cell.getCellType()) {
				case STRING:
					subdata.add(cell.getStringCellValue());
				    break;
				case BOOLEAN:
					subdata.add(cell.getBooleanCellValue());
				    break;
				case NUMERIC:
					subdata.add(cell.getNumericCellValue());
				    break;
				
				}
			}
			data.add(subdata.toArray());
		}
		System.out.println("[INFO_MSG] DATA");
		for(int i=0;i<data.size();i++)
			{
				for(int j=0;j<data.get(i).length;j++) {
					System.out.print(data.get(i)[j]);
				    System.out.print(" ");
				}
				System.out.println();
			}
	}

}
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
public class WebdriverDemo
{
 @DataProvider (name = "data-provider")
 public Object[][] dpMethod(){
 return new Object[][] {{"First-Value","Second-Value"}, {"Second-Value","Second-Value"}};
 }
 
    @Test (dataProvider = "data-provider")
    public void myTest (String []val) {
        System.out.println("Passed Parameter Is : " + val[0]+' '+val[1]);
    }
}
 */