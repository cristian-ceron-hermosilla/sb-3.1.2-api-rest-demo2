package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ContratosEnti;
/*
 * 
 */
@Repository
public interface IContratos extends JpaRepository<ContratosEnti, Integer> {

    ContratosEnti getById(Integer id);
    ContratosEnti save(ContratosEnti Contratos);
    List<ContratosEnti> findAll();

}
