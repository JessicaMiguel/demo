package com.example.demo.repository;

import com.example.demo.domain.CuentaCorriente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaCorrienteRepository extends JpaRepository<CuentaCorriente, Long> {
}
