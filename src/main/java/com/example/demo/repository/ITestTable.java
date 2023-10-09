package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.TestTableEnti;
/*
 * 
 */
@Repository
public interface ITestTable extends JpaRepository<TestTableEnti, Integer> {

    TestTableEnti getById(Integer id);
    TestTableEnti save(TestTableEnti TestTable);
    List<TestTableEnti> findAll();

}
