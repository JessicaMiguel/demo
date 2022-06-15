package com.example.demo.controller;

import com.example.demo.apiDTO.DeltaDiasCliente;
import com.example.demo.service.FileChequesPagoServiceImpl;
import com.example.demo.service.FileCuentaCorrienteServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class ChequesPagoController {

    private final FileChequesPagoServiceImpl fileServiceCheques;
    private final FileCuentaCorrienteServiceImpl fileCuentaCorrienteService;

    public ChequesPagoController(FileChequesPagoServiceImpl fileServiceCheques, FileCuentaCorrienteServiceImpl fileCuentaCorrienteService) {
        this.fileServiceCheques = fileServiceCheques;
        this.fileCuentaCorrienteService = fileCuentaCorrienteService;
    }

    @GetMapping("/getClients")
    public ResponseEntity<List<com.example.demo.controller.DatosCliente>> getClients(){
        return  ResponseEntity.ok().body(fileServiceCheques.getClients());
    }

    @GetMapping("/deltaDays")//depende de lo que Franco este graficando
    public ResponseEntity<List<DeltaDiasCliente>> getDeltaDiasCliente(@RequestParam Long Id_Cliente){
        List<DeltaDiasCliente> result = this.fileServiceCheques.findChequesCliente(Id_Cliente);
        List<DeltaDiasCliente> result2 = this.fileCuentaCorrienteService.findChequesRechazados(Id_Cliente);
        List<DeltaDiasCliente> resultGeneral = Stream.concat(result.stream(),result2.stream()).collect(Collectors.toList());
        return ResponseEntity.ok().body(resultGeneral);
    }

}
