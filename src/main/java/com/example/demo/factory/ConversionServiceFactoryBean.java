package com.example.demo.factory;


import java.util.Map;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Component;

import com.example.demo.converter.TestTableDTOInToTestTableEntiConverter;
import com.example.demo.converter.PersonasDTOInToPersonasEntiConverter;
import com.example.demo.converter.ContratosDTOInToContratosEntiConverter;
import com.example.demo.converter.TestTableEntiToTestTableDTOOutConverter;
import com.example.demo.converter.PersonasEntiToPersonasDTOOutConverter;
import com.example.demo.converter.ContratosEntiToContratosDTOOutConverter;

@Component
@Primary
public class ConversionServiceFactoryBean implements FactoryBean<ConversionService> {
    
    private ConversionService conversionService;

    @Autowired
    private TestTableDTOInToTestTableEntiConverter testTableDTOInToTestTableEntiConverter;

    @Autowired
    private PersonasDTOInToPersonasEntiConverter personasDTOInToPersonasEntiConverter;

    @Autowired
    private ContratosDTOInToContratosEntiConverter contratosDTOInToContratosEntiConverter;

    @Autowired
    private TestTableEntiToTestTableDTOOutConverter testTableEntiToTestTableDTOOutConverter;

    @Autowired
    private PersonasEntiToPersonasDTOOutConverter personasEntiToPersonasDTOOutConverter;

    @Autowired
    private ContratosEntiToContratosDTOOutConverter contratosEntiToContratosDTOOutConverter;

    @Override
    public ConversionService getObject() {
        if (conversionService == null) {
            conversionService = createConversionService();
        }
        return conversionService;
    }


    private ConversionService createConversionService() {
        GenericConversionService service = new GenericConversionService();
        service.addConverter(testTableDTOInToTestTableEntiConverter);
        service.addConverter(personasDTOInToPersonasEntiConverter);
        service.addConverter(contratosDTOInToContratosEntiConverter);
        service.addConverter(testTableEntiToTestTableDTOOutConverter);
        service.addConverter(personasEntiToPersonasDTOOutConverter);
        service.addConverter(contratosEntiToContratosDTOOutConverter);
 
        return service;
      }

    @Override
    public Class<?> getObjectType() {
        return ConversionService.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
