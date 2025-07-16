package common;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

public class Utils {

	public static String[][] getTableObject (String xlFilePath, String sheetName) {
		String[][] tabArray = null;
		int ci, cj;
		try {
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);
			int maxOfColumn = sheet.getColumns();
			tabArray = new String[sheet.getRows() - 1][maxOfColumn];
			ci = 0;
			
			for(int i =0;i<sheet.getRows();i++,ci++) {
				cj = 0;
				for(int j = 0;j<sheet.getColumns();j++,cj++) {
					tabArray[ci][cj] = sheet.getCell(j, i).getContents();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return (tabArray);
	}
		
}
