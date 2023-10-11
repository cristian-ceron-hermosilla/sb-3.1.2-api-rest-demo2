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
public class PersonasDtoOutput implements Serializable {

    private static final long serialVersionUID = 1697067482615L;

    /*
    * id integer [primary key, ref: < Contratos.idPersona]
    * isPK:true
    * isFK:false
    * primary key, ref: < Contratos.idPersona
    */
    private Integer id;

    /*
    * id_tributario varchar [note: 'Numero Unico de Id. Tributario']
    * isPK:false
    * isFK:false
    * note: 'Numero Unico de Id. Tributario'
    */
    private String idTributario;

    /*
    * nombres varchar
    * isPK:false
    * isFK:false
    */
    private String nombres;

    /*
    * apellidos varchar
    * isPK:false
    * isFK:false
    */
    private String apellidos;

    /*
    * emails_particular varchar
    * isPK:false
    * isFK:false
    */
    private String emailsParticular;

    /*
    * numero_celular varchar
    * isPK:false
    * isFK:false
    */
    private String numeroCelular;

    /*
    * email_corporativo varchar
    * isPK:false
    * isFK:false
    */
    private String emailCorporativo;

    private List<ContratosDtoOutput> contratos;

}
