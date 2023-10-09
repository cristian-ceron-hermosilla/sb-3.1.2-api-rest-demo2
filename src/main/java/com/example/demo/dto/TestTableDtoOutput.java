package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import lombok.Data;
import lombok.Builder;

/*
 * 
 */
@Data
@Builder
public class TestTableDtoOutput implements Serializable {

    private static final long serialVersionUID = 1696858283614L;

    /*
    * id integer [primary key]
    * isPK:true
    * isFK:false
    * primary key
    */
    private Integer id;

    /*
    * value1 varchar
    * isPK:false
    * isFK:false
    */
    private String value1;

    /*
    * value2 varchar
    * isPK:false
    * isFK:false
    */
    private String value2;

}
