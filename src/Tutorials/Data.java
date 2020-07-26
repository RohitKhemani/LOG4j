package Tutorials;


	
	

	import java.io.FileInputStream;
	import java.io.IOException;

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	
	public class Data {
		
		public static Workbook book;
		public static Sheet sheet;
		
		
		
		public static Object[][] selection(String sheetname) throws EncryptedDocumentException, IOException {

		
			
			FileInputStream fis = new FileInputStream("‪‪‪‪C:\\Users\\rohit\\Desktop");
			
			
			
	book = WorkbookFactory.create(fis);

	sheet = book.getSheet(sheetname);

	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

	for (int i=0; i<sheet.getLastRowNum(); i++) {
		
		for (int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
			
			data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			
		}
	}
	return data;


}
		
}
