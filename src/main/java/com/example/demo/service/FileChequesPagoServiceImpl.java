package com.example.demo.service;

import com.example.demo.apiDTO.DeltaDiasCliente;
import com.example.demo.controller.DatosCliente;
import com.example.demo.domain.ChequesPago;
import com.example.demo.repository.ChequesPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileChequesPagoServiceImpl implements FileService{

    @Autowired
    private ChequesPagoRepository chequesPagoRepository;

    @Override
    public void insertNewFile(Object objectFile) {

        ChequesPago chequesPago = (ChequesPago) objectFile;
        this.chequesPagoRepository.save(chequesPago);

    }

    public List<DeltaDiasCliente> findChequesCliente(Long Id_Cliente){

        return this.chequesPagoRepository.findChequesCliente(Id_Cliente);
    }

    public List<DatosCliente> getClients(){
        return this.chequesPagoRepository.findAll(Sort.Direction.ASC, "Id_Cliente");
    }


}
