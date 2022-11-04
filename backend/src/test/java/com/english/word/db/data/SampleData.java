package com.english.word.db.data;

import com.english.word.db.entity.Word;
import com.english.word.db.repository.WordRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

@SpringBootTest
public class SampleData {
    private final String filePath = "C:\\ysys\\EnglishWordsTest\\backend\\src\\main\\resources\\data\\words.xlsx";

    @Autowired
    WordRepository wordRepository;

    @Test
    void readExcel() throws Exception {
        FileInputStream fis = new FileInputStream(new File(filePath));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();
            Cell cell = cellIterator.next();
            String krName = cell.getStringCellValue();

            cell = cellIterator.next();
            String enName = cell.getStringCellValue();

            cell = cellIterator.next();
            int unit = (int) cell.getNumericCellValue();

            cell = cellIterator.next();
            int page = (int) cell.getNumericCellValue();

            wordRepository.save(new Word(krName, enName, unit, page));
        }
    }
}
