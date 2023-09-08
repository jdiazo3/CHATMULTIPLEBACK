package chat.multiple.edu.Service;

import java.util.List;
import java.util.Optional;
import chat.multiple.edu.Entity.Persona;

/**
 *
 * @author juand
 */

  // interface que exporta el servicio hacia nuestro controlador


public interface PersonaService {
  /**
   * 
   * @return
   */
    public List<Persona>findAll();
    /**
     * 
     * @param id
     * @return
     */
    public Optional<Persona> findById(Long id);
    /**
     * 
     * @param numdoc
     * @return
     */
    public Optional<Persona> findByNumdoc(Integer numdoc);
    /**
     * 
     * @param p
     * @return
     */
    public Persona save(Persona p);
    /**
     * 
     * @param Id
     */
    public void deleteById(Long Id);
    /**
     * 
     * @return
     */
    public List<Persona>BuscarActorOProductor();
}
