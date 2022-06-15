package com.example.demo.service;

import com.example.demo.apiDTO.DeltaDiasCliente;
import com.example.demo.domain.CuentaCorriente;
import com.example.demo.repository.CuentaCorrienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileCuentaCorrienteServiceImpl implements FileService {

    @Autowired
    private CuentaCorrienteRepository cuentaRepository;

    @Override
    public void insertNewFile(Object objectFile) {

        CuentaCorriente cuentaCorriente = (CuentaCorriente) objectFile;
        this.cuentaRepository.save(cuentaCorriente);
    }

    public List<DeltaDiasCliente> findChequesRechazados(Long Id_Cliente){
        return this.cuentaRepository.findDeltaDiasPago(Id_Cliente);
    }
}
