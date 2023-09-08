package chat.multiple.edu.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import chat.multiple.edu.Entity.Persona;
import chat.multiple.edu.Entity.Usuario;

/**
 *
 * @author juand
 */

 // interface que exporta el servicio hacia nuestro controlador

public interface UsuarioService {
    /**
     * 
     * @return
     */
    public List<Usuario>findAll();
    /**
     * 
     * @param id
     * @return
     */
    public Optional<Usuario>findById(Long id);
    /**
     * 
     * @param persona
     * @return
     */
    public Optional<Usuario> findByPersona(Persona persona);
    /**
     * 
     * @param user
     * @return
     */
    public Optional<Usuario> findByUser(String user);
    
    /**
     * 
     * @param user
     * @param password
     * @return
     */
    public Optional<Usuario> UserAndPassword(@Param("user")String user ,@Param("user")String  password);

    /**
     * 
     * @param p
     * @return
     */
    public Usuario save(Usuario p);

    /**
     * 
     * @param Id
     */
    public void deleteById(Long Id);
}

