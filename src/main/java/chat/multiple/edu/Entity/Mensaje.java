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
@Table (name = "mensaje")
public class Mensaje {
    private static final Long serialVersionUID = -969060843698080433L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = serialVersionUID;
    
    @Column(length = 25)
    private String mensaje;

    @Column(length = 255)
    private String orden;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idusu", referencedColumnName = "id")
    private Usuario usuario;

    
    public String getMensaje() {
        return mensaje;
    }


    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


    public String getOrden() {
        return orden;
    }


    public void setOrden(String orden) {
        this.orden = orden;
    }


    public Usuario getUsuario() {
        return usuario;
    }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


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

    
}
