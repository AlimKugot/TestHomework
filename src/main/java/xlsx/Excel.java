package xlsx;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.util.Iterator;

public class Excel {
    private final static String absolutePath = "/home/alim/IdeaProjects/CheckHomework/CheckHomework/src/test/resources";
    protected static Workbook book = new HSSFWorkbook();
    Sheet sheet = book.createSheet("Ratings");
    public File resultFile;

    public Excel(String fileName) {
        resultFile = new File(absolutePath + "/" + fileName + ".xlsx");
    }

    public Excel() {
        resultFile = new File(absolutePath + "/result.xlsx");
    }


    public static Workbook getBook() {
        return book;
    }

    public static String getAbsolutePath() {
        return absolutePath;
    }

    //    //row.createCell() == create column
//    public void createFile() {
//
//        try (FileOutputStream fos = new FileOutputStream(resultFile)) {
//            Workbook book = new HSSFWorkbook();
//            int i = 0;
//            Row header = sheet.createRow(i++);
//            CellStyle headerStyle = Styles.header(book);
//
//            // Entry Head
//            Set<String> keySet = columns.keySet();
//            int j = 0;
//            for (String k : keySet) {
//                Cell cell = header.createCell(j++);
//                cell.setCellValue(k);
//                cell.setCellStyle(headerStyle);
//                sheet.autoSizeColumn(j);
//            }
//
//            for (Map.Entry<String, String[]> m : columns.entrySet()) {
//                sheet.autoSizeColumn(i);
//                Row row = sheet.createRow(i++);
//
//                for (int w = 1; w < m.getValue().length; w++) {
//                    row.createCell(w++).setCellValue(m.getValue()[w]);
//                }
//            }

//            for (String k : keySet) {
//                Row row = sheet.createRow(i);
//                row.createCell(0).setCellValue(k);
//                String[] columnOfCurrentRow = columns.get(k);
//
//                //fill columns
//                int j = 1;
//                for (String c : columnOfCurrentRow) {
//                    Cell cell = row.createCell(j++);
//                    cell.setCellValue(c);
//                }
//                sheet.autoSizeColumn(i++);
////            }
//            book.write(fos);
//        } catch (IOException io) {
//            System.out.println("Error");
//        }
//    }




    public class Row {

        Row() {}

        Row(String rowName) {

        }
    }
}
