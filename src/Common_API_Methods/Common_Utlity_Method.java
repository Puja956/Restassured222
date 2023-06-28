package Common_API_Methods;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Common_Utlity_Method {

	public static void EvidenceCreater(String Filename, String RequestBody, String ResponseBody, int StatusCode)
			throws IOException {
		File TextFile = new File("/Users/souvikmallik/Desktop/abcd.txt" + Filename + ".txt");
		 //System.out.println("New blank text file of name : " + TextFile.getName());

		FileWriter dataWrite = new FileWriter(TextFile);

		dataWrite.write("RequestBody is : " + RequestBody + "\n\n");
		dataWrite.write("StatusCode is : " + StatusCode + "\n\n");
		dataWrite.write("ResponseBody is : " + ResponseBody);

		dataWrite.close();

		System.out.println("RequestBody and ResponseBody written in textfile : " +
		 TextFile.getName());

	}

	public static ArrayList<String> ReadDataExcel(String sheetName, String TestCaseName) throws IOException {
		ArrayList<String> ArrayData = new ArrayList<String>();
		// step1:create the object file input stream to locate the excel file
		FileInputStream Fis = new FileInputStream(
				"/Users/souvikmallik/Desktop/REST ASSURED DATA DRIVEN/POST_DATA_TC1.xlsx");

		// step2:open the excel file by creating the object file XSSFWordBook
		XSSFWorkbook WorkBook = new XSSFWorkbook(Fis);
		// step3: open the desire sheet
		int countofsheet = WorkBook.getNumberOfSheets();
		for (int i = 0; i < countofsheet; i++) {
			String SheetName = WorkBook.getSheetName(i);

			// step4:access the desire sheet
			if (sheetName.equalsIgnoreCase(SheetName)) {
				// use XSSFSheet to save the sheet into the variable
				XSSFSheet Sheet = WorkBook.getSheetAt(i);

				// create an iterator iterate through rows and find out in which column the test
				// case names are found
				Iterator<Row> Rows = Sheet.iterator();
				Row FirstRow = Rows.next();
				// create the iterator to iterate through the shell of first row to find out
				// which cell cointains test case name

				Iterator<Cell> CellsOfFirstRow = FirstRow.cellIterator();
				int k = 0;
				int TC_column = 0;
				while (CellsOfFirstRow.hasNext()) {
					Cell CellValue = CellsOfFirstRow.next();
					if (CellValue.getStringCellValue().equalsIgnoreCase("TestCaseName")) {
						TC_column = k;
						 //System.out.println("expected column for test case name :" +k);
						break;
					}
					k++;
				}
				// verify the row where the desire test case is found and fetch the entire row
				while (Rows.hasNext()) {
					Row Datarow = Rows.next();
					String TCName = Datarow.getCell(TC_column).getStringCellValue();
					//Datarow.getCell(TC_column).getNumericCellValue()
					if (TCName.equalsIgnoreCase(TestCaseName)) {
						Iterator<Cell> CellsValues = Datarow.cellIterator();
						while (CellsValues.hasNext()) {
							
							String Data = "";
							Cell CurrentCell = CellsValues.next();
							try
							{
								String StringData = CurrentCell.getStringCellValue();
								Data = StringData;
							}
							catch(IllegalStateException e)
							{
							    double doubledata = CurrentCell.getNumericCellValue();
							    Data = Double.toString(doubledata);
							}
							
							ArrayData.add(Data);
						}
						break;
					}
				}

			}
		}
		return ArrayData;
	}
						}
							
