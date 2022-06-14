package com.example.demo.repository;

import com.example.demo.domain.Cobranza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CobranzasRepository extends JpaRepository<Cobranza, Long> {


}
