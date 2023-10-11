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
public class ContratosDtoOutput implements Serializable {

    private static final long serialVersionUID = 1697067664510L;

    /*
    * id integer [primary key]
    * isPK:true
    * isFK:false
    * primary key
    */
    private Integer id;

    /*
    * idOrganizacion integer
    * isPK:false
    * isFK:false
    */
    private Integer idorganizacion;

    /*
    * fechaDesde date
    * isPK:false
    * isFK:false
    */
    private Date fechadesde;

    /*
    * fechaHasta date
    * isPK:false
    * isFK:false
    */
    private Date fechahasta;

    private PersonasDtoOutput personas;

}
