package com.example.demo.controller;

import com.example.demo.apiDTO.DeltaDiasCliente;
import com.example.demo.domain.ChequesPago;
import com.example.demo.service.FileChequesPagoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ChequesPagoController {

    private final FileChequesPagoServiceImpl fileServiceCheques;

    public ChequesPagoController(FileChequesPagoServiceImpl fileServiceCheques) {
        this.fileServiceCheques = fileServiceCheques;
    }

    @GetMapping("/getClients")
    public ResponseEntity<List<com.example.demo.controller.DatosCliente>> getClients(){
        return  ResponseEntity.ok().body(fileServiceCheques.getClients());
    }

    @GetMapping("/deltaDays")//depende de lo que Franco este graficando
    public ResponseEntity<List<DeltaDiasCliente>> getDeltaDiasCliente(@RequestParam Long Id_Cliente){

        return ResponseEntity.ok().body(fileServiceCheques.findChequesCliente(Id_Cliente));
    }
}
