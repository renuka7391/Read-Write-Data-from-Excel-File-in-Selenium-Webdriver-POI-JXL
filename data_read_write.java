package main_pacakge;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class data_read_write

{
	public int rowcount;

public String[] read_file(String arg) throws IOException
{	 String userid[]=new String[100];
     String password[]=new String[100];
     String returnvar[]=new String[100]; 
     

	File file = new File("/Users/renuka/Documents/workspace/bank_application/credentials.xlsx");
	FileInputStream input = new FileInputStream(file);
	XSSFWorkbook seleniumWorkbook = new XSSFWorkbook(input);
	XSSFSheet s1 = seleniumWorkbook.getSheet("Main");
	rowcount = s1.getLastRowNum()-s1.getFirstRowNum();
	 
	for(int i=1;i<=rowcount;i++)
	{
		XSSFRow row1 = s1.getRow(i);
		   
		userid[i-1]= row1.getCell(1).getStringCellValue();
		password[i-1]=row1.getCell(2).getStringCellValue();
	} 
	seleniumWorkbook.close();
	if(arg=="uid")
	 {
		 returnvar=userid;
	 }else if(arg=="pwd")
	 {
		
		 returnvar=password;
	 }
	
	return returnvar;
	
}
public void write_data(String[] casestatus)throws IOException{
	
    

	File file = new File("/Users/renuka/Documents/workspace/bank_application/credentials.xlsx");
	FileInputStream input = new FileInputStream(file);
	XSSFWorkbook seleniumWorkbook = new XSSFWorkbook(input);
	XSSFSheet s1 = seleniumWorkbook.getSheet("Main");
	 rowcount = s1.getLastRowNum()-s1.getFirstRowNum();
	 
	for(int i=1;i<=rowcount;i++)
	{
		XSSFRow row1 = s1.getRow(i);
		Cell cell = row1.createCell(3);
        cell.setCellValue(casestatus[i-1]);
		   

	} 
	
	FileOutputStream output=new FileOutputStream(file);
	seleniumWorkbook.write(output);
	output.close();
	seleniumWorkbook.close();
	
	
}
}
