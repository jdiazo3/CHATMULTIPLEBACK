/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chat.multiple.edu.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author juand
 */

//clase que representa la tabla facturaccion en la base de datos con sus respectivos getters and setters para cada columna.

@Entity
@Table (name = "user")
public class Usuario {
    private static final Long serialVersionUID = -969060843698080433L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = serialVersionUID;
    
    @Column(length = 25)
    private String user;

    @Column(length = 15)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idper", referencedColumnName = "id")
    private Persona persona;

    
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
     * @return String
     */
    public String getUser() {
        return user;
    }

    
    /** 
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    
    /** 
     * @return String
     */
    public String getPassword() {
        return password;
    }

    
    /** 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    
    /** 
     * @return Persona
     */
    public Persona getPersona() {
        return persona;
    }

    
    /** 
     * @param persona
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
}
