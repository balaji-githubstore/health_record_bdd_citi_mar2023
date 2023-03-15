package com.citi.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static Object[][] getSheetIntoTwoDimArray(String filePath, String sheetname) throws IOException {

		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet(sheetname);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] data = new Object[rowCount - 1][cellCount];

		DataFormatter format = new DataFormatter();
		for (int r = 1; r < rowCount; r++) {
			for (int c = 0; c < cellCount; c++) {
				String value = format.formatCellValue(sheet.getRow(r).getCell(c));
				data[r - 1][c] = value;
			}
		}
		book.close();
		file.close();

		return data;
	}

	public static List<Map<String, String>> getSheetIntoListOfMap(String filePath, String sheetname)
			throws IOException {

		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet(sheetname);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		DataFormatter format = new DataFormatter();
		for (int r = 1; r < rowCount; r++) {
			HashMap<String, String> map = new HashMap<String, String>();

			for (int c = 0; c < cellCount; c++) {
				map.put(format.formatCellValue(sheet.getRow(0).getCell(c)),
						format.formatCellValue(sheet.getRow(r).getCell(c)));
			}

			list.add(map);
		}
		book.close();
		file.close();

		return list;
	}
}