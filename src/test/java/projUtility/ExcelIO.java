package projUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelIO {
	XSSFWorkbook wb;
	File file;
	public ExcelIO() throws IOException {
		file=new File(ObjectPropsReader.get_usersExcelLocation());
		FileInputStream fis = new FileInputStream(file);
		// creating workbook instance that refers to users .xlsx file
		wb = new XSSFWorkbook(fis);
	}
	public List<Object[]> getSheetDataAsMap(int SheetNumber) {
		//String[][][][][] users = null;
		XSSFSheet sheet = wb.getSheetAt(SheetNumber);
	 List<Object[]> usersList =new ArrayList<Object[]>();
		 for(int i =1;i<sheet.getPhysicalNumberOfRows();i++) {
			 Row row = sheet.getRow(i);
//			 Object[] obj1=new Object[5] ;
			 Object[] obj1=new Object[5] ;
			 for (int j=0;j<row.getPhysicalNumberOfCells();j++) {
				 Cell cell = row.getCell(j);
					switch (cell.getCellType()) {
					case STRING: // field that represents string cell type
						if (!cell.getStringCellValue().isEmpty())
						obj1[j]= cell.getStringCellValue();
						break;
					case NUMERIC: // field that represents number cell type
						DataFormatter dataFormatter = new DataFormatter();
						String formattedCellStr = dataFormatter.formatCellValue(cell);
						if (!formattedCellStr.isEmpty())
						 obj1[j]= formattedCellStr;
						break;
					default:
					}
			 }
			 usersList.add(obj1);
		 }
//		 while (itrRow.hasNext()) {
//			 int c=-1;
//				Row row = itrRow.next();
//				Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column
//				 Object[] obj1=new Object[5] ;
//				while (cellIterator.hasNext()) {
//					 c++;
//					// System.out.println(c);
//				
//					
//					Cell cell = cellIterator.next();
//					switch (cell.getCellType()) {
//					case STRING: // field that represents string cell type
//						
//						 obj1[c]= cell.getStringCellValue();
//						break;
//					case NUMERIC: // field that represents number cell type
//						 obj1[c]= ""+cell.getNumericCellValue();
//						break;
//					default:
//					}
//					usersList.add(obj1);
//				}
//			}
		 
		 
		// System.out.println(iteUsers.next());
		 return usersList;
	}
	
}
