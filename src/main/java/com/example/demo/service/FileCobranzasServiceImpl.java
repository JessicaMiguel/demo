package com.example.demo.service;

import com.example.demo.domain.Cobranza;
import com.example.demo.repository.CobranzasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileCobranzasServiceImpl implements FileService {

    @Autowired
    private CobranzasRepository cobranzasRepository;

    @Override
    public void insertNewFile(Object objectFile) {

        Cobranza cobranza = (Cobranza) objectFile;
        this.cobranzasRepository.save(cobranza);

    }
}
