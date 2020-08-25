package samplePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadXSL {

	static Keywords keyword;

	public void runLeadTest() throws IOException, InterruptedException {
		keyword = new Keywords();
		FileInputStream file = new FileInputStream("/home/robro/Downloads/testing/LeadSuite.xlsx");
		XSSFWorkbook workbook  = new XSSFWorkbook(file);
		int NumberOfSheets=workbook.getNumberOfSheets();
		System.out.println("Number Of Sheets:"+NumberOfSheets);
		for(int i=0;i<NumberOfSheets;i++)
		{
			System.out.println("At index "+i+" Sheet Name : "+workbook.getSheetName(i));
		}
		for(int currentSheet=0;currentSheet<NumberOfSheets;currentSheet++) {
		System.out.println("Pivoting Sheet with  Name : "+workbook.getSheetName(currentSheet));
		XSSFSheet sheet = workbook.getSheet(workbook.getSheetName(currentSheet));
		ArrayList data = new ArrayList();
		Iterator row = sheet.iterator();
		while (row.hasNext()) {
			
			Row rowIterator = (Row) row.next();
			Iterator cellItr = rowIterator.cellIterator();
			
			while (cellItr.hasNext()) {
				Cell cell = (Cell) cellItr.next();	
				switch (cell.getCellType()) {
				case STRING:
					data.add(cell.getStringCellValue());
				    break;
				case BOOLEAN:
					data.add(cell.getBooleanCellValue());
				    break;
				case NUMERIC:
					data.add(cell.getNumericCellValue());
				    break;
				
				}
			}	
		}
		System.out.println(data);
		for (int i=3;i<data.size();i++){
			
			if (data.get(i).equals("openbrowser")) {
				System.out.println(data.get(i));
				System.out.println(data.get(i+1));
				System.out.println(data.get(i+2));
				String objectFilePath=(String) data.get(i+2);
				keyword.openbrowser(objectFilePath);
			}
			if (data.get(i).equals("navigate")) {
				String key = (String) data.get(i);
				String testData = (String) data.get(i+1);
				String objectName = (String) data.get(i+2);
				keyword.navigate(testData);
			}
			if (data.get(i).equals("input")) {
				String key = (String) data.get(i);
				String testData = (String) data.get(i+1);
				String objectName = (String) data.get(i+2);
				System.out.println(key);
				System.out.println(testData);
				System.out.println(objectName);
				keyword.input(testData,objectName);	
			}
			if (data.get(i).equals("click")){
				String key = (String) data.get(i);
				String testData = (String) data.get(i+1);
				String objectName = (String) data.get(i+2);
				System.out.println(key);
				System.out.println(testData);
				System.out.println(objectName);
				keyword.click(objectName);	
			}
			
			if (data.get(i).equals("selectlist")) {
				String key = (String) data.get(i);
				String testData = (String) data.get(i+1);
				String objectName = (String) data.get(i+2);
				System.out.println(key);
				System.out.println(testData);
				System.out.println(objectName);
				keyword.selectlist(testData,objectName);
				
			}
			if (data.get(i).equals("verifypagetext")) {
				String key = (String) data.get(i);
				String ExpectedTestData = (String) data.get(i+1);
				String objectName = (String) data.get(i+2);
				System.out.println(key);
				System.out.println(ExpectedTestData);
				System.out.println(objectName);
				String actualValue = keyword.verifypagetext(ExpectedTestData,objectName);
			
			}
			if (data.get(i).equals("verifyeditboxtext")) {
				String key = (String) data.get(i);
				String ExpectedTestData = (String) data.get(i+1);
				String objectName = (String) data.get(i+2);
				System.out.println(key);
				System.out.println(ExpectedTestData);
				System.out.println(objectName);
				String actualValue = keyword.verifyeditboxtext(ExpectedTestData,objectName);
				
			}
			if (data.get(i).equals("verifypagetitle")) {
				String key = (String) data.get(i);
				String ExpectedTestData = (String) data.get(i+1);
				String objectName = (String) data.get(i+2);
				String actualValue = keyword.verifypagetitle(ExpectedTestData);
				
			}
			if (data.get(i).equals("screenshot")){
				String key = (String) data.get(i);
				String testData = (String) data.get(i+1);
				String objectName = (String) data.get(i+2);
				System.out.println(key);
				System.out.println(testData);
				System.out.println(objectName);
				keyword.screenshot(testData);	
			}
						
		}
		
		}

	}

}