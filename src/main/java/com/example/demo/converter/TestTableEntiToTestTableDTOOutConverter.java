package com.example.demo.converter;

import org.springframework.core.convert.converter.Converter;
import com.example.demo.dto.TestTableDtoOutput;
import com.example.demo.entity.TestTableEnti;
import lombok.NoArgsConstructor;
/*
 * 
 */
@NoArgsConstructor
public class TestTableEntiToTestTableDTOOutConverter implements Converter<TestTableEnti, TestTableDtoOutput> {

    @Override
    public TestTableDtoOutput convert(TestTableEnti source) {
        TestTableDtoOutput dto = new TestTableDtoOutput();
        dto.setId(source.getId());
        dto.setValue1(source.getValue1());
        dto.setValue2(source.getValue2());
        return dto;
    }
}
