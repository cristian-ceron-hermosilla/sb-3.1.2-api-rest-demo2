package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.converter.TestTableDTOInToTestTableEntiConverter;
import com.example.demo.converter.PersonasDTOInToPersonasEntiConverter;
import com.example.demo.converter.ContratosDTOInToContratosEntiConverter;
import com.example.demo.converter.TestTableEntiToTestTableDTOOutConverter;
import com.example.demo.converter.PersonasEntiToPersonasDTOOutConverter;
import com.example.demo.converter.ContratosEntiToContratosDTOOutConverter;


/*
 * 
 */
@Configuration
public class ConversionConfig {

    @Bean
    public TestTableDTOInToTestTableEntiConverter testTableDTOInToTestTableEntiConverter() {
        return new TestTableDTOInToTestTableEntiConverter();
    }

    @Bean
    public TestTableEntiToTestTableDTOOutConverter testTableEntiToTestTableDTOOutConverter() {
        return new PersonasEntiToPersonasDTOOutConverter();
    }

    @Bean
    public PersonasDTOInToPersonasEntiConverter personasDTOInToPersonasEntiConverter() {
        return new PersonasDTOInToPersonasEntiConverter();
    }

    @Bean
    public PersonasEntiToPersonasDTOOutConverter personasEntiToPersonasDTOOutConverter() {
        return new PersonasEntiToPersonasDTOOutConverter();
    }

    @Bean
    public ContratosDTOInToContratosEntiConverter contratosDTOInToContratosEntiConverter() {
        return new ContratosDTOInToContratosEntiConverter();
    }

    @Bean
    public ContratosEntiToContratosDTOOutConverter contratosEntiToContratosDTOOutConverter() {
        return new PersonasEntiToPersonasDTOOutConverter();
    }

}
