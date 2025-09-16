package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	static FileInputStream f; //used to read excel file 
	static XSSFWorkbook w; //Book1 //Filename //Represents the entire Excel file (Workbook)
	static XSSFSheet s;// sheets //Sheet name // Represents a specific Sheet in the workbook.

	public static String getStringData(int a,int b, String sheet) throws IOException {
		// a is row ,b is column or cell, sheet is name of the sheet in the excel
		//FileInputStream, XSSFRow, XSSFCell - inbuilt class
		f=new FileInputStream("C:\\Users\\112ra\\eclipse-workspace\\GroceryApplication\\src\\test\\resources\\testdata.xlsx");//Copy as path - the file location where it is saved
		w=new XSSFWorkbook(f);
		s=w.getSheet(sheet);
		XSSFRow r=s.getRow(a);
		XSSFCell c=r.getCell(b);
		return c.getStringCellValue(); //inbuilt method for excelsheet connection. Returns the value from the cell as a String.
	
	}

	public static String getIntegerData(int a,int b, String sheet) throws IOException { 
		f=new FileInputStream("C:\\Users\\112ra\\eclipse-workspace\\GroceryApplication\\src\\test\\resources\\testdata.xlsx");
		w=new XSSFWorkbook(f); //get file name
		s=w.getSheet(sheet); // get sheet name
		XSSFRow r=s.getRow(a); // get row
		XSSFCell c=r.getCell(b); // get column/cell
		int y=(int) c.getNumericCellValue();// string - integer  = typecasting
		return String.valueOf(y);
	
	}


}
