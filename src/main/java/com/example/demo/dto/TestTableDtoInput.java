package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import lombok.Data;

/*
 * 
 */
@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class TestTableDtoInput implements Serializable {

    private static final long serialVersionUID = 1697067141418L;

    /*
    * id integer [primary key]
    * primary key
    */
    private Integer id;

    /*
    * value1 varchar
    */
    private String value1;

    /*
    * value2 varchar
    */
    private String value2;

}
