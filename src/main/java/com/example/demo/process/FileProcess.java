package com.example.demo.process;

import java.io.File;

public interface FileProcess {

    /**
     * Tiene que incluir metodos los cuales se adpten al formato del archivo que se quiere
     * importar.
     * Pregunta: Hay alguna forma de no depender de si el formato del archivo cambia?
     */

    public void readMassiveFile(File file);
}
