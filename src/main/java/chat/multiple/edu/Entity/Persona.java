/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.multiple.edu.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author juand
 */

 //clase que representa la tabla persona en la base de datos con sus respectivos getters and setters para cada columna.

@Entity
@Table (name = "persona")
public class Persona {
    private static final Long serialVersionUID = -969060843698080433L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = serialVersionUID;
    
    @Column(length = 11)
    private Integer numdoc;
    
    @Column(length = 15)
    private String nombre;
     
    @Column(length = 15)
    private String apeper;
    
    @Column(length = 15)
    private String tipodoc;

    @Column(length = 20)
    private String correo;

    /** 
     * @return Long
     */
    public Long getId() {
        return id;
    }

    
    /** 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    
    /** 
     * @return Integer
     */
    public Integer getNumdoc() {
        return numdoc;
    }

    
    /** 
     * @param numdoc
     */
    public void setNumdoc(Integer numdoc) {
        this.numdoc = numdoc;
    }

    
    /** 
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    
    /** 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    /** 
     * @return String
     */
    public String getApeper() {
        return apeper;
    }

    
    /** 
     * @param apeper
     */
    public void setApeper(String apeper) {
        this.apeper = apeper;
    }

    
    /** 
     * @return String
     */
    public String getTipodoc() {
        return tipodoc;
    }

    
    /** 
     * @param tipodoc
     */
    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }

    
    /** 
     * @return String
     */
    public String getCorreo() {
        return correo;
    }

    
    /** 
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
}
