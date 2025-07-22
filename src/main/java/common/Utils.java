package common;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

public class Utils {

	public String[][] getTableObject (String xlFilePath, String sheetName) {
		String[][] tabArray = null;
		int ci, cj;
		try {
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);
			int maxOfColumn = sheet.getColumns();
			int maxRows = sheet.getRows() - 1;
			tabArray = new String[maxRows][maxOfColumn];
			ci = 0;
			
			for(int i = 0;i<maxRows;i++,ci++) {
				cj = 0;
				for(int j = 0;j<sheet.getColumns();j++,cj++) {
					tabArray[ci][cj] = sheet.getCell(j, i+1).getContents();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return (tabArray);
	}
		
}
