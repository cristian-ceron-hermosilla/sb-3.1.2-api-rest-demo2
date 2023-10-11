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
public class ContratosDtoInput implements Serializable {

    private static final long serialVersionUID = 1697067141462L;

    /*
    * id integer [primary key]
    * primary key
    */
    private Integer id;

    /*
    * idOrganizacion integer
    */
    private Integer idorganizacion;

    /*
    * idPersona integer
    */
    private Integer idpersona;

    /*
    * fechaDesde date
    */
    private Date fechadesde;

    /*
    * fechaHasta date
    */
    private Date fechahasta;

    // Rel:idpersona --> < Contratos.idPersona
    // private PersonasDtoInput personas;

}
