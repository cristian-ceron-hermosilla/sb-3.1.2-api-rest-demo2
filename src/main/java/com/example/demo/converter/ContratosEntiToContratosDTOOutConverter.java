package com.example.demo.converter;

import org.springframework.core.convert.converter.Converter;
import com.example.demo.dto.ContratosDtoOutput;
import com.example.demo.entity.ContratosEnti;
import lombok.NoArgsConstructor;
/*
 * 
 */
@NoArgsConstructor
public class ContratosEntiToContratosDTOOutConverter implements Converter<ContratosEnti, ContratosDtoOutput> {

    @Override
    public ContratosDtoOutput convert(ContratosEnti source) {
        ContratosDtoOutput dto = new ContratosDtoOutput();
        dto.setId(source.getId());
        dto.setIdorganizacion(source.getIdorganizacion());
        dto.setIdpersona(source.getIdpersona());
        dto.setFechadesde(source.getFechadesde());
        dto.setFechahasta(source.getFechahasta());
        return dto;
    }
}
