package com.example.demo.entity;

import java.util.List;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/*
 * 
 */
@Entity
@Table(name = "Personas")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonasEnti {
    /*
     * id integer [primary key, ref: < Contratos.idPersona]
     * isPK: true
     * isFK: false
    * primary key, ref: < Contratos.idPersona
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /*
     * id_tributario varchar [note: 'Numero Unico de Id. Tributario']
     * isPK: false
     * isFK: false
    * note: 'Numero Unico de Id. Tributario'
     */
    @Column
    private String idTributario;

    /*
     * nombres varchar
     * isPK: false
     * isFK: false
     */
    @Column
    private String nombres;

    /*
     * apellidos varchar
     * isPK: false
     * isFK: false
     */
    @Column
    private String apellidos;

    /*
     * emails_particular varchar
     * isPK: false
     * isFK: false
     */
    @Column
    private String emailsParticular;

    /*
     * numero_celular varchar
     * isPK: false
     * isFK: false
     */
    @Column
    private String numeroCelular;

    /*
     * email_corporativo varchar
     * isPK: false
     * isFK: false
     */
    @Column
    private String emailCorporativo;

    @OneToMany(mappedBy = "personas")
    private List<ContratosEnti> contratos;

}
