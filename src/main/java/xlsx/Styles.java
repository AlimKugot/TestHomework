package xlsx;

import org.apache.poi.ss.usermodel.*;

public class Styles {
    static CellStyle header(Workbook book) {
        CellStyle headerStyle = book.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        Font font = book.createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 12);
        headerStyle.setFont(font);
        return headerStyle;
    }


}
