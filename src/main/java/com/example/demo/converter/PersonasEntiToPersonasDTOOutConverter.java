package com.example.demo.converter;

import org.springframework.core.convert.converter.Converter;
import com.example.demo.dto.PersonasDtoOutput;
import com.example.demo.entity.PersonasEnti;
import lombok.NoArgsConstructor;
/*
 * 
 */
@NoArgsConstructor
public class PersonasEntiToPersonasDTOOutConverter implements Converter<PersonasEnti, PersonasDtoOutput> {

    @Override
    public PersonasDtoOutput convert(PersonasEnti source) {
        PersonasDtoOutput dto = new PersonasDtoOutput();
        dto.setId(source.getId());
        dto.setIdTributario(source.getIdTributario());
        dto.setNombres(source.getNombres());
        dto.setApellidos(source.getApellidos());
        dto.setEmailsParticular(source.getEmailsParticular());
        dto.setNumeroCelular(source.getNumeroCelular());
        dto.setEmailCorporativo(source.getEmailCorporativo());
        return dto;
    }
}
