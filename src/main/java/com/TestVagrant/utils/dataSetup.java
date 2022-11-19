package com.TestVagrant.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class dataSetup {

    private static final Logger LOG = LogManager.getLogger(dataSetup.class);
    public static HashMap<String, String> setExcelData(int TestCaseNumber) {
        String fileName = "data.xlsx";
        String path = "\\src\\main\\java\\com\\TestVagrant\\resource\\excel\\";
        String filePath = System.getProperty("user.dir") + path + fileName;
        String tcName = "TC_" + TestCaseNumber;
        String sheetName = Data.get("dataSheet");
        HashMap<String, String> map = new HashMap<>();
        try {
            FileInputStream file = new FileInputStream(filePath);
            XSSFWorkbook wb = new XSSFWorkbook(file);
            String curSheetName;
            int totalSheet = wb.getNumberOfSheets();
            int i;
            Row irow = null, headrow = null;
            Cell icell = null, headcell = null;
            for (i = 0; i < totalSheet; i++) {
                curSheetName = wb.getSheetName(i);
                if (curSheetName.equals(sheetName)) {
                    break;
                }
            }
            XSSFSheet sheet = wb.getSheetAt(i);

            Iterator<Row> rows = sheet.iterator();
            while (rows.hasNext()) {
                irow = rows.next();
                String tcValue = irow.getCell(0).getStringCellValue();
                if (tcValue.equals("testCases")) {
                    headrow = irow;
                }
                if (tcValue.equals(tcName)) {
                    break;
                }
            }

            Iterator<Cell> headcells = headrow.cellIterator();
            Iterator<Cell> cells = irow.cellIterator();
            while (cells.hasNext() && headcells.hasNext()) {
                icell = cells.next();
                headcell = headcells.next();
                String cellKey = headcell.getStringCellValue();
                String cellValue;
                if (icell.getCellTypeEnum() == CellType.STRING)
                    cellValue = icell.getStringCellValue();
                else
                    cellValue = NumberToTextConverter.toText(icell.getNumericCellValue());
                map.put(cellKey, cellValue);
            }
            LOG.info("Successfully passed data from excel to @dataprovider map" );
        } catch (Exception e) {
            LOG.error("Unsuccessfully to pass data from excel to @dataprovider map" );
            e.printStackTrace();
        }
        return map;
    }

    public static void setPropertiesData() {
        String fileName = "data.properties";
        String path = "\\src\\main\\java\\com\\TestVagrant\\resource\\properties\\";
        String filePath = System.getProperty("user.dir") + path + fileName;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Properties props = new Properties();
            props.load(fis);
            for (Map.Entry<Object, Object> entry : props.entrySet()) {
                Data.put((String) entry.getKey(), entry.getValue());
            }
            LOG.info("Successfully set properties data to be used" );
        }
        catch (Exception e) {
            LOG.info("Unsuccessfully to set properties data to be used" );
            e.printStackTrace();
        }
    }
}
