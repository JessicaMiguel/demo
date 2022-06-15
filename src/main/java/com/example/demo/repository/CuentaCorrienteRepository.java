package com.example.demo.repository;

import com.example.demo.apiDTO.DeltaDiasCliente;
import com.example.demo.domain.CuentaCorriente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaCorrienteRepository extends JpaRepository<CuentaCorriente, Long> {

    @Query("Select (B.fecha_vto - A.fecha) AS DiasPago, Id_Cliente, razon_social, A.tot_gen    FROM CuentaCorriente A, CuentaCorriente B WHERE A.Id_Cliente = B.Id_Cliente AND A.Id_Cliente = :Id_Cliente AND A.debe = B.haber")
    List<DeltaDiasCliente> findDeltaDiasPago(@Param("Id_Cliente") Long Id_cliente);
}
