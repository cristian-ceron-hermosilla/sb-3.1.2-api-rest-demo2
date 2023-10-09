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

import com.example.demo.dto.PersonasDtoInput;
import com.example.demo.dto.PersonasDtoOutput;
import com.example.demo.service.PersonasServ;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

/*
 * 
 */
@RestController
@AllArgsConstructor
@RequestMapping("/personas")
public class PersonasApi {

   private final PersonasServ sPersonas;

    /*
    * 
    */
    @GetMapping("/get/{id}")
    public ResponseEntity<PersonasDtoOutput> getById(@PathVariable Integer id) {
        PersonasDtoOutput dto = sPersonas.getById(id);
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
    public ResponseEntity<List<PersonasDtoOutput>> getAll() {
        List<PersonasDtoOutput> dtos = sPersonas.getAll();
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
    public ResponseEntity<List<PersonasDtoOutput>> addMany(@RequestBody List<PersonasDtoInput> personasDtoIn) {
        List<PersonasDtoOutput> dtos = sPersonas.addMany(personasDtoIn);
        if (dtos != null) {
            return ResponseEntity.ok(dtos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
