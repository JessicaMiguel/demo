package com.example.demo.controller;

import com.example.demo.exception.ControllerException;
import com.example.demo.process.BeginProcess;
import com.example.demo.process.FileProcess;
import com.example.demo.process.ResultProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class FileController {

    @Autowired
    private BeginProcess fileProcess;

    /**
     * Metodo que recibe un archivo con información para cargar en el sistema.
     * Llama a otro metodo para comience el proceso de carga y devolver un mensaje de que el proceso
     * corre en segundo plano.
     * @param file Archivo original sin cambios
     * @return responseEntity con la estructura de un ResultProcess
     * @throws ControllerException lanza una excepcion con el mensaje de error
     */
    @PostMapping(value = "file", consumes = {"multipart/import-data"})
    public ResponseEntity<ResultProcess> loadMassive(@RequestParam(value = "file")MultipartFile file)
            throws ControllerException {
        try{
            File temporalFile = File.createTempFile("Temp", "xlsx");
            file.transferTo(temporalFile);
            ResultProcess resultProcess = fileProcess.massiveProcess(temporalFile);

            return ResponseEntity.status(resultProcess.getStatus()).body(resultProcess);
        } catch (Exception e) {
            throw new ControllerException(e);
        }
    }
}
