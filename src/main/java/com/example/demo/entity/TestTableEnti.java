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
@Table(name = "TestTable")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestTableEnti {
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
     * value1 varchar
     * isPK: false
     * isFK: false
     */
    @Column
    private String value1;

    /*
     * value2 varchar
     * isPK: false
     * isFK: false
     */
    @Column
    private String value2;

}
