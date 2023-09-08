package chat.multiple.edu.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chat.multiple.edu.Entity.Persona;
import chat.multiple.edu.Repository.PersonaRepository;

/**
 *
 * @author juand
 */

// clase que implementa el servicio y retorna el resultados de las sentencias por nuestro dao

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    
    /** 
     * @return List<Persona>
     */
    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    
    /** 
     * @param numdoc
     * @return Optional<Persona>
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> findByNumdoc(Integer numdoc) {
        return personaRepository.findByNumdoc(numdoc);
    }

    
    /** 
     * @param p
     * @return Persona
     */
    @Override
    public Persona save(Persona p) {
        return personaRepository.save(p);
    }

    
    /** 
     * @param Id
     */
    @Override
    @Transactional
    public void deleteById(Long Id) {
        personaRepository.deleteById(Id);
        }

    
    
    /** 
     * @param id
     * @return Optional<Persona>
     */
    @Override
    public Optional<Persona> findById(Long id) {
        return personaRepository.findById(id);
    }


    @Override
    public List<Persona> BuscarActorOProductor() {
        return personaRepository.BuscarActorOProductor();
        }
    

}
