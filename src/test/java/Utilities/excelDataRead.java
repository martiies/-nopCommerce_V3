package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/*=================================================================================================
 * HSSF (Horrible Spreadsheet Format) − It is used to read and write xls format of MS-Excel files. 
 * XSSF (XML Spreadsheet Format) − It is used for xlsx file format of MS-Excel.
 * SS is a package that provides common support for both formats xls and xlsx with a common API
 * ===============================================================================================
 * import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 * 
 */
public class excelDataRead {
	static String TestData_Path="./src/test/resources/inputData.xlsx";
	private static Workbook book;
	private static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) throws InvalidFormatException{
		FileInputStream file = null;
		try{
			file= new FileInputStream(TestData_Path);
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		int rownum = sheet.getLastRowNum();
		int colnum = sheet.getRow(0).getLastCellNum();
		System.out.println("num of rows is :"+rownum +"num of column is :"+colnum);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum(); i++){
			for (int j=0; j<sheet.getRow(0).getLastCellNum(); j++){
				String browser = sheet.getRow(i+1).getCell(j).toString();
				//System.out.println("un in the first row is :"+unpwd);
				data[i][j]= sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	
	

}
