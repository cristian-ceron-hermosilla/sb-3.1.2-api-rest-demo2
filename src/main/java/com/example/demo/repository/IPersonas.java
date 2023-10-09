package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.PersonasEnti;
/*
 * 
 */
@Repository
public interface IPersonas extends JpaRepository<PersonasEnti, Integer> {

    PersonasEnti getById(Integer id);
    PersonasEnti save(PersonasEnti Personas);
    List<PersonasEnti> findAll();

}
