package com.example.demo.converter;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import com.example.demo.dto.ContratosDtoInput;
import com.example.demo.entity.ContratosEnti;

import com.example.demo.helpers.ListConverterHelper;
import lombok.NoArgsConstructor;


/*
 * 
 */
@NoArgsConstructor
public class ContratosDTOInToContratosEntiConverter implements Converter<ContratosDtoInput, ContratosEnti> {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ListConverterHelper listConverter;

    @Override
    public ContratosEnti convert(ContratosDtoInput source) {
        ConversionService conversionService = applicationContext.getBean(ConversionService.class);
        ContratosEnti enti = new ContratosEnti(
                        source.getId()
                      , source.getIdorganizacion()
                      , source.getIdpersona()
                      , source.getFechadesde()
                      , source.getFechahasta()
                           );
        return enti;
    }
}
