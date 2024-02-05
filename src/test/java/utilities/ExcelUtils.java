package utilities;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtils {
public static FileInputStream fi;
public static FileOutputStream fo;
public static XSSFWorkbook wb;
public static XSSFSheet ws;
public static XSSFRow row;
public static XSSFCell cell;


public static String getcelldata(String xlfile,String xlsheet,int rowno,int cellno) throws IOException
{
	//Reading from the Excel Sheet
	 fi=new FileInputStream(xlfile);
	 wb=new XSSFWorkbook(fi);
	 ws=wb.getSheet(xlsheet);
	 row=ws.getRow(rowno);
	 cell=row.getCell(cellno);
	 String data;
	 try
	 {
		 DataFormatter formatter=new DataFormatter();
		 data=formatter.formatCellValue(cell);
		 return data;
	 }
	 catch(Exception e)
	 {
		 data="";
	 }
	 wb.close();
	 fi.close();
	 return data;
}
public static void setcelldata(String xlfile,String xlsheet,int rno,int cno,String data) throws IOException
{
	//Writing on Excel Sheet
	 fi=new FileInputStream(xlfile);
	 wb=new XSSFWorkbook(fi);
	 ws=wb.getSheet(xlsheet);
	 if(ws.getRow(rno)==null) {
		 row=ws.createRow(rno);
	 }
	 else {
		 row=ws.getRow(rno);
	 }
	 cell=row.createCell(cno);
	 cell.setCellValue(data);
	 fo=new FileOutputStream(xlfile);
	 wb.write(fo);
	 wb.close();
	 fi.close();
	 fo.close();
}
}