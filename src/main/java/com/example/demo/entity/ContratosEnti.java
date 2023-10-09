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
import lombok.ToString;
import lombok.EqualsAndHashCode;

/*
 * 
 */
@Entity
@Table(name = "Contratos")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"personas"})
@ToString(exclude = {"personas"})
public class ContratosEnti {
    /*
     * id integer [primary key]
     * isPK: true
     * isFK: false
    * primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /*
     * idOrganizacion integer
     * isPK: false
     * isFK: false
     */
    @Column
    private Integer idorganizacion;

    /*
     * fechaDesde date
     * isPK: false
     * isFK: false
     */
    @Column
    private Date fechadesde;

    /*
     * fechaHasta date
     * isPK: false
     * isFK: false
     */
    @Column
    private Date fechahasta;

    @ManyToOne
    private PersonasEnti personas;

}
