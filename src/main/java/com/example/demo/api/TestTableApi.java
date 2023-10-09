package com.example.demo.api;

import java.util.List;
import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TestTableDtoInput;
import com.example.demo.dto.TestTableDtoOutput;
import com.example.demo.service.TestTableServ;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

/*
 * 
 */
@RestController
@AllArgsConstructor
@RequestMapping("/test-table")
public class TestTableApi {

   private final TestTableServ sTestTable;

    /*
    * 
    */
    @GetMapping("/get/{id}")
    public ResponseEntity<TestTableDtoOutput> getById(@PathVariable Integer id) {
        TestTableDtoOutput dto = sTestTable.getById(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            throw new EntityNotFoundException("Persona con ID " + id + " no encontrada.");
        }
    }

    /*
    * 
    */
    @GetMapping("/get-all")
    public ResponseEntity<List<TestTableDtoOutput>> getAll() {
        List<TestTableDtoOutput> dtos = sTestTable.getAll();
        if (!dtos.isEmpty()) {
            return ResponseEntity.ok(dtos);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /*
    * 
    */
    @PostMapping("/add-many")
    public ResponseEntity<List<TestTableDtoOutput>> addMany(@RequestBody List<TestTableDtoInput> testTableDtoIn) {
        List<TestTableDtoOutput> dtos = sTestTable.addMany(testTableDtoIn);
        if (dtos != null) {
            return ResponseEntity.ok(dtos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
