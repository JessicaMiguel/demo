package com.example.demo.process;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileProcess {

    /**
     * metodo que se encarga de empezar el proceso de carga del archivo original.
     * Se llama a un metodo que se encarga de cargar el archivo en la base de datos, todos los datos
     * del archivo a "wacha pelada"
     * Por otro lado, se devuelve un resultado del proceso donde se expresa que el proceso de carga
     * del archivo se realiza en segundo plano, mientras se puede seguir utilizando el programa.
     * @param file Archivo que contiene los datos originales
     * @return resultProcess, contiene status, el idProcess, errores y mensages.
     */
    public ResultProcess massiveProcess (File file){

        ResultProcess resultProcess = new ResultProcess();

        return resultProcess;
    }
}
