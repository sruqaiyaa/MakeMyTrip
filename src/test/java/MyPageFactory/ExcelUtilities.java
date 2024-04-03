package MyPageFactory;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

	XSSFWorkbook wb;
	XSSFSheet sheet;
	public ExcelUtilities(String filepath) {
		try {
		File f=new File(filepath);
		FileInputStream fis;
			fis = new FileInputStream(f);
			wb=new XSSFWorkbook(fis);
 
	        }
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
		public String getdata(int sheetno,int rowno,int cell) {
			sheet=wb.getSheetAt(sheetno);
			String data=new DataFormatter().formatCellValue(sheet.getRow(rowno).getCell(cell));	
			return data;
		}
		public int getRowCount(int sheetindex) {
			int row=wb.getSheetAt(sheetindex).getLastRowNum();
			//row=row+1;
			return row;
		}
}
