package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TestTableEnti;
import com.example.demo.repository.ITestTable;
import com.example.demo.dto.TestTableDtoInput;
import com.example.demo.dto.TestTableDtoOutput;

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
public class TestTableServ {

    private static final Logger logger = LoggerFactory.getLogger(TestTableServ.class);

    private final ITestTable iTestTable;

    private final ListConverterHelper listConverter;

    private final ConversionService conversionService;

    public TestTableDtoOutput getById(Integer id) {
        logger.info("Consultando id:", id);
        TestTableDtoOutput dto = conversionService.convert(iTestTable.getById(id), TestTableDtoOutput.class);
        if (dto == null) {
            throw new EntityNotFoundException("TestTable con ID " + id + " no encontrada.");
        }
        return dto;
    }

    public TestTableDtoOutput save(TestTableDtoInput testTable) {
        logger.info("Saving:{}", testTable);
        TestTableDtoOutput dto = conversionService.convert(iTestTable.save(testTable), TestTableDtoOutput.class);
        return dto;
    }

    public List<TestTableDtoOutput> getAll() {
        List<TestTableEnti> entidadesLeidas = iTestTable.findAll();
        logger.info("GetAll({})",entidadesLeidas.size());
        return listConverter.convertList(entidadesLeidas, TestTableDtoOutput.class, conversionService);
    }

    @Transactional
    public List<TestTableDtoOutput> addMany(List<TestTableDtoInput> listaTestTable) {

       logger.info("SaveMany Total Recs:{}", listaTestTable.size());
       List<TestTableEnti> entidadesGuardadas = iTestTable.saveAll(listConverter.convertList(listaTestTable, TestTableEnti.class, conversionService));
       return listConverter.convertList(entidadesGuardadas, TestTableDtoOutput.class, conversionService);
    }
}
