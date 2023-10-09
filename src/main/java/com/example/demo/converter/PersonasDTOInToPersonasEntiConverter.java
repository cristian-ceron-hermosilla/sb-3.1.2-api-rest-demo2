package com.example.demo.converter;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import com.example.demo.dto.PersonasDtoInput;
import com.example.demo.entity.PersonasEnti;
import com.example.demo.entity.ContratosEnti;

import com.example.demo.helpers.ListConverterHelper;
import lombok.NoArgsConstructor;


/*
 * 
 */
@NoArgsConstructor
public class PersonasDTOInToPersonasEntiConverter implements Converter<PersonasDtoInput, PersonasEnti> {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ListConverterHelper listConverter;

    @Override
    public PersonasEnti convert(PersonasDtoInput source) {
        ConversionService conversionService = applicationContext.getBean(ConversionService.class);
        List<ContratosEnti> contratosEntiList = listConverter.convertList(source.getContratos(), ContratosEnti.class, conversionService);
        PersonasEnti enti = new PersonasEnti(
                        source.getId()
                      , source.getIdTributario()
                      , source.getNombres()
                      , source.getApellidos()
                      , source.getEmailsParticular()
                      , source.getNumeroCelular()
                      , source.getEmailCorporativo()
                     ,contratosEntiList
                           );
        return enti;
    }
}
