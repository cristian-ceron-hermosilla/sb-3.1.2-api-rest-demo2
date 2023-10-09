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

import com.example.demo.dto.ContratosDtoInput;
import com.example.demo.dto.ContratosDtoOutput;
import com.example.demo.service.ContratosServ;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

/*
 * 
 */
@RestController
@AllArgsConstructor
@RequestMapping("/contratos")
public class ContratosApi {

   private final ContratosServ sContratos;

    /*
    * 
    */
    @GetMapping("/get/{id}")
    public ResponseEntity<ContratosDtoOutput> getById(@PathVariable Integer id) {
        ContratosDtoOutput dto = sContratos.getById(id);
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
    public ResponseEntity<List<ContratosDtoOutput>> getAll() {
        List<ContratosDtoOutput> dtos = sContratos.getAll();
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
    public ResponseEntity<List<ContratosDtoOutput>> addMany(@RequestBody List<ContratosDtoInput> contratosDtoIn) {
        List<ContratosDtoOutput> dtos = sContratos.addMany(contratosDtoIn);
        if (dtos != null) {
            return ResponseEntity.ok(dtos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
