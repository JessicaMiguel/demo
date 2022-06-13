package com.example.demo.service;

import com.example.demo.domain.ChequesPago;
import com.example.demo.repository.ChequesPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileChequesPagoServiceImpl implements FileService{

    @Autowired
    private ChequesPagoRepository chequesPagoRepository;

    @Override
    public void insertNewFile(Object objectFile) {

        ChequesPago chequesPago = (ChequesPago) objectFile;
        this.chequesPagoRepository.save(chequesPago);

    }

}
