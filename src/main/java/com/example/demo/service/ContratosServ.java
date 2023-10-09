package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ContratosEnti;
import com.example.demo.repository.IContratos;
import com.example.demo.dto.ContratosDtoInput;
import com.example.demo.dto.ContratosDtoOutput;

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
public class ContratosServ {

    private static final Logger logger = LoggerFactory.getLogger(ContratosServ.class);

    private final IContratos iContratos;

    private final ListConverterHelper listConverter;

    private final ConversionService conversionService;

    public ContratosDtoOutput getById(Integer id) {
        logger.info("Consultando id:", id);
        ContratosDtoOutput dto = conversionService.convert(iContratos.getById(id), ContratosDtoOutput.class);
        if (dto == null) {
            throw new EntityNotFoundException("Contratos con ID " + id + " no encontrada.");
        }
        return dto;
    }

    public ContratosDtoOutput save(ContratosDtoInput contratos) {
        logger.info("Saving:{}", contratos);
        ContratosDtoOutput dto = conversionService.convert(iContratos.save(contratos), ContratosDtoOutput.class);
        return dto;
    }

    public List<ContratosDtoOutput> getAll() {
        List<ContratosEnti> entidadesLeidas = iContratos.findAll();
        logger.info("GetAll({})",entidadesLeidas.size());
        return listConverter.convertList(entidadesLeidas, ContratosDtoOutput.class, conversionService);
    }

    @Transactional
    public List<ContratosDtoOutput> addMany(List<ContratosDtoInput> listaContratos) {

       logger.info("SaveMany Total Recs:{}", listaContratos.size());
       List<ContratosEnti> entidadesGuardadas = iContratos.saveAll(listConverter.convertList(listaContratos, ContratosEnti.class, conversionService));
       return listConverter.convertList(entidadesGuardadas, ContratosDtoOutput.class, conversionService);
    }
}
