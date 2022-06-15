package com.example.demo.repository;

import com.example.demo.apiDTO.DeltaDiasCliente;
import com.example.demo.controller.DatosCliente;
import com.example.demo.domain.ChequesPago;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChequesPagoRepository extends JpaRepository<ChequesPago, Long> {

    //query que me traiga todos los cheques de un cliente y hacer la diferencia de fechas
    //la fecha desde que entregas el prod hasta el cobro--> qué se facturo
    //cuando se entrego el pedido y cuando se cobró

    @Query("Select Id_Cliente, razon_social, importe, fecha, cheque_nro, (fecha_vto - fecha) AS dias From ChequesPago Where ID_Cliente = :Id_Cliente AND estado_cheque NOT IN ('RECHAZADO', 'DE BAJA') ORDER BY importe")
    List<DeltaDiasCliente> findById_Cliente(@Param("Id_Cliente") Long Id_Cliente);



    @Query("Select DISTINCT (Id_Cliente),(razon_social) FROM Cheques Pago")
    List<DatosCliente> findAll(Sort.Direction asc, String id_cliente);


}
