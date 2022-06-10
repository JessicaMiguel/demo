package com.example.demo.process;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Este metodo atrapa el archivo "cheques_pagos_mes"
 */
public class FileProcessChecks implements FileProcess {

    @Override
    public void readMassiveFile(File file) {

        Workbook workbook = null;
        FileInputStream fileFIS = null;

        try {
            fileFIS = new FileInputStream(file);
            workbook = new XSSFWorkbook(fileFIS);

            Sheet firstSheet = workbook.getSheetAt(workbook.getFirstVisibleTab());
            Iterator<Row> rowIterator = firstSheet.rowIterator();
            //Se tienen que ignorar las primeras 6 lineas
            //Habría que intentar que esas lineas no estan
            for (int i=0; i<5; i++){
                rowIterator.next();
            }
            //TODO: se tiene agregar el List<Clase de Cheque>
            //List<> chequesCreate = new ArrayList<>();

            while(rowIterator.hasNext()){
                Row recordRow = rowIterator.next();
                Cell cell0 = recordRow.getCell(0);
                Cell cell1 = recordRow.getCell(1);
                Cell cell2 = recordRow.getCell(2);
                Cell cell3 = recordRow.getCell(3);
                Cell cell6 = recordRow.getCell(6);
                Cell cell7 = recordRow.getCell(7);
                Cell cell11 = recordRow.getCell(11);
                Cell cell12 = recordRow.getCell(12);
                Cell cell13 = recordRow.getCell(13);


            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
