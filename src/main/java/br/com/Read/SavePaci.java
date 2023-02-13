package br.com.Read;

import lombok.RequiredArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

@Controller
@RequiredArgsConstructor
@RequestMapping("/salvar")
public class SavePaci {

        private static final String fileName = "C:\\Estudos\\Read\\Pacientes.xls"; //Caminho Pasta a ser importada

    @Autowired
    private PatientService service;

    @GetMapping(value = "/paciente")
    public void savePaciExcel() throws IOException {

        try {
            FileInputStream arquivo = new FileInputStream(fileName);

            HSSFWorkbook workbook = new HSSFWorkbook(arquivo);

            HSSFSheet sheetColumnReading = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheetColumnReading.iterator();

            Patient lb_paci = new Patient();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    if (cell.getStringCellValue() != null) {
                        switch (cell.getColumnIndex()) {
                            case 0 -> {
                                lb_paci.setNOME(cell.getStringCellValue());
                            }
                            case 1 -> {
                                lb_paci.setSEXO(String.valueOf(cell.getStringCellValue()));
                            }
                            case 2 -> {
                                lb_paci.setNASC(String.valueOf(cell.getStringCellValue()));
                            }
                        }

                        service.salvarInfoPaci(lb_paci);

                    } else {
                        System.out.println("Nenhum paciente encontrado!");
                    }
                }
            }
            arquivo.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo Excel não encontrado!");
        }
    }

}
