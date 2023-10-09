package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PersonasEnti;
import com.example.demo.repository.IPersonas;
import com.example.demo.dto.PersonasDtoInput;
import com.example.demo.dto.PersonasDtoOutput;

import jakarta.transaction.Transactional;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * 
 */
@Service
@Data
@AllArgsConstructor
public class PersonasServ {

    private static final Logger logger = LoggerFactory.getLogger(PersonasServ.class);

    private final IPersonas iPersonas;

    private final ListConverterHelper listConverter;

    private final ConversionService conversionService;

    public PersonasDtoOutput getById(Integer id) {
        logger.info("Consultando id:", id);
        PersonasDtoOutput dto = conversionService.convert(iPersonas.getById(id), PersonasDtoOutput.class);
        if (dto == null) {
            throw new EntityNotFoundException("Personas con ID " + id + " no encontrada.");
        }
        return dto;
    }

    public PersonasDtoOutput save(PersonasDtoInput personas) {
        logger.info("Saving:{}", personas);
        PersonasDtoOutput dto = conversionService.convert(iPersonas.save(personas), PersonasDtoOutput.class);
        return dto;
    }

    public List<PersonasDtoOutput> getAll() {
        List<PersonasEnti> entidadesLeidas = iPersonas.findAll();
        logger.info("GetAll({})",entidadesLeidas.size());
        return listConverter.convertList(entidadesLeidas, PersonasDtoOutput.class, conversionService);
    }

    @Transactional
    public List<PersonasDtoOutput> addMany(List<PersonasDtoInput> listaPersonas) {

       logger.info("SaveMany Total Recs:{}", listaPersonas.size());
       List<PersonasEnti> entidadesGuardadas = iPersonas.saveAll(listConverter.convertList(listaPersonas, PersonasEnti.class, conversionService));
       return listConverter.convertList(entidadesGuardadas, PersonasDtoOutput.class, conversionService);
    }
}
