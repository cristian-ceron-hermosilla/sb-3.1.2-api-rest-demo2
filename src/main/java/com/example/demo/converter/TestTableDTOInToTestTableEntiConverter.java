package com.example.demo.converter;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import com.example.demo.dto.TestTableDtoInput;
import com.example.demo.entity.TestTableEnti;

import com.example.demo.helpers.ListConverterHelper;
import lombok.NoArgsConstructor;


/*
 * 
 */
@NoArgsConstructor
public class TestTableDTOInToTestTableEntiConverter implements Converter<TestTableDtoInput, TestTableEnti> {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ListConverterHelper listConverter;

    @Override
    public TestTableEnti convert(TestTableDtoInput source) {
        ConversionService conversionService = applicationContext.getBean(ConversionService.class);
        TestTableEnti enti = new TestTableEnti(
                        source.getId()
                      , source.getValue1()
                      , source.getValue2()
                           );
        return enti;
    }
}
