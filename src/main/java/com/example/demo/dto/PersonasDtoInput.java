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
public class PersonasDtoInput implements Serializable {

    private static final long serialVersionUID = 1697067141438L;

    /*
    * id integer [primary key, ref: < Contratos.idPersona]
    * primary key, ref: < Contratos.idPersona
    */
    private Integer id;

    /*
    * id_tributario varchar [note: 'Numero Unico de Id. Tributario']
    * note: 'Numero Unico de Id. Tributario'
    */
    private String idTributario;

    /*
    * nombres varchar
    */
    private String nombres;

    /*
    * apellidos varchar
    */
    private String apellidos;

    /*
    * emails_particular varchar
    */
    private String emailsParticular;

    /*
    * numero_celular varchar
    */
    private String numeroCelular;

    /*
    * email_corporativo varchar
    */
    private String emailCorporativo;

    // Rel:id --> < Contratos.idPersona
    // private List<ContratosDtoInput> contratos;

}
