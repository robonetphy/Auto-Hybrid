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

     

	public void runLeadTest(XSSFSheet workSheetObject,Object[] testData) throws IOException, InterruptedException {
		Keywords keyword = new Keywords();
		XSSFSheet sheet = workSheetObject;
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

		System.out.print("[INFO_MSG]");
		System.out.println(data);
		int indexForTestData=0;
		try {
			
		for (int i=3;i<data.size();i++){
				
				if (data.get(i).equals("openbrowser")) {
					System.out.print("[INFO_MSG]");
					System.out.println(data.get(i));
					System.out.print("[INFO_MSG]");
					System.out.println(data.get(i+1));
					System.out.print("[INFO_MSG]");
					System.out.println(data.get(i+2));
					String objectFilePath=(String) data.get(i+2);
					if(objectFilePath == "data")
						{
						objectFilePath=(String)testData[indexForTestData++];
						System.out.println("[INFO_MSG][TestDataCurrent] "+objectFilePath);
						}
					keyword.openbrowser(objectFilePath);
				}
				if (data.get(i).equals("navigate")) {
					String key = (String) data.get(i);
					String ExpectedTestData = (String) data.get(i+1);
					String objectName = (String) data.get(i+2);
					System.out.print("[INFO_MSG]");
					System.out.println(key);
					System.out.print("[INFO_MSG]");
					System.out.println(ExpectedTestData);
					if(ExpectedTestData.equals("data"))
						{
						ExpectedTestData=(String)testData[indexForTestData++];
						System.out.println("[INFO_MSG][TestDataCurrent] "+ExpectedTestData);
						}
					System.out.print("[INFO_MSG]");
					System.out.println(objectName);
					keyword.navigate(ExpectedTestData);
				}
				if (data.get(i).equals("input")) {
					String key = (String) data.get(i);
					String ExpectedTestData = (String) data.get(i+1);
					String objectName = (String) data.get(i+2);
					System.out.print("[INFO_MSG]");
					System.out.println(key);
					System.out.print("[INFO_MSG]");
					System.out.println(ExpectedTestData);
					if(ExpectedTestData.equals("data"))
						{
						ExpectedTestData=(String)testData[indexForTestData++];
						System.out.println("[INFO_MSG][TestDataCurrent] "+ExpectedTestData);
						}
					System.out.print("[INFO_MSG]");
					System.out.println(objectName);
					keyword.input(ExpectedTestData,objectName);	
				}
				if (data.get(i).equals("click")){
					String key = (String) data.get(i);
					String ExpectedTestData = (String) data.get(i+1);
					String objectName = (String) data.get(i+2);
					System.out.print("[INFO_MSG]");
					System.out.println(key);
					System.out.print("[INFO_MSG]");
					System.out.println(ExpectedTestData);
					if(ExpectedTestData.equals("data"))
						{
						ExpectedTestData=(String)testData[indexForTestData++];
						System.out.println("[INFO_MSG][TestDataCurrent] "+ExpectedTestData);
						}
					System.out.print("[INFO_MSG]");
					System.out.println(objectName);
					keyword.click(objectName);	
				}
				
				if (data.get(i).equals("selectlist")) {
					String key = (String) data.get(i);
					String ExpectedTestData = (String) data.get(i+1);
					String objectName = (String) data.get(i+2);
					System.out.print("[INFO_MSG]");
					System.out.println(key);
					System.out.print("[INFO_MSG]");
					System.out.println(ExpectedTestData);
					if(ExpectedTestData.equals("data"))
							{
							ExpectedTestData=(String)testData[indexForTestData++];
							System.out.println("[INFO_MSG][TestDataCurrent] "+ExpectedTestData);
							}
	
					System.out.print("[INFO_MSG]");
					System.out.println(objectName);
					keyword.selectlist(ExpectedTestData,objectName);
					
				}
				if (data.get(i).equals("verifypagetext")) {
					String key = (String) data.get(i);
					String ExpectedTestData = (String) data.get(i+1);
					String objectName = (String) data.get(i+2);
					System.out.print("[INFO_MSG]");
					System.out.println(key);
					System.out.print("[INFO_MSG]");
					System.out.println(ExpectedTestData);
					if(ExpectedTestData.equals("data"))
					{
					ExpectedTestData=(String)testData[indexForTestData++];
					System.out.println("[INFO_MSG][TestDataCurrent] "+ExpectedTestData);
					}
					System.out.print("[INFO_MSG]");
					System.out.println(objectName);
					String actualValue = keyword.verifypagetext(ExpectedTestData,objectName);
				
				}
				if (data.get(i).equals("verifyeditboxtext")) {
					String key = (String) data.get(i);
					String ExpectedTestData = (String) data.get(i+1);
					String objectName = (String) data.get(i+2);
					System.out.print("[INFO_MSG]");
					System.out.println(key);
					System.out.print("[INFO_MSG]");
					System.out.println(ExpectedTestData);
					if(ExpectedTestData.equals("data"))
					{
					ExpectedTestData=(String)testData[indexForTestData++];
					System.out.println("[INFO_MSG][TestDataCurrent] "+ExpectedTestData);
					}
					System.out.print("[INFO_MSG]");
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
					String ExpectedTestData = (String) data.get(i+1);
					String objectName = (String) data.get(i+2);
					System.out.print("[INFO_MSG]");
					System.out.println(key);
					System.out.print("[INFO_MSG]");
					System.out.println(ExpectedTestData);
					if(ExpectedTestData.equals("data"))
					{
					ExpectedTestData=(String)testData[indexForTestData++];
					System.out.println("[INFO_MSG][TestDataCurrent] "+ExpectedTestData);
					}
					System.out.print("[INFO_MSG]");
					System.out.println(objectName);
					keyword.screenshot(ExpectedTestData);	
				}
				if (data.get(i).equals("closebrowser")){
					String key = (String) data.get(i);
					String ExpectedTestData = (String) data.get(i+1);
					String objectName = (String) data.get(i+2);
					System.out.print("[INFO_MSG]");
					System.out.println(key);
					System.out.print("[INFO_MSG]");
					System.out.println(ExpectedTestData);
					if(ExpectedTestData.equals("data"))
					{
					ExpectedTestData=(String)testData[indexForTestData++];
					System.out.println("[INFO_MSG][TestDataCurrent] "+ExpectedTestData);
					}
					System.out.print("[INFO_MSG]");
					System.out.println(objectName);
					keyword.closebrowser();;	
				}
							
			}
		}
		catch(Exception e) {
			System.out.println("[ERROR_MSG][TestDataCurrent] Due to number of Data in TestSteps not match with column in TestData ");
		}
	
	}

}