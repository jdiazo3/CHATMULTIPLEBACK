package chat.multiple.edu.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chat.multiple.edu.Entity.Persona;
import chat.multiple.edu.Entity.Usuario;
import chat.multiple.edu.Repository.UsuarioRepository;


/**
 *
 * @author juand
 */

  // clase que implementa el servicio y retorna el resultados de las sentencias por nuestro dao
 
@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    
    /** 
     * @return List<Usuario>
     */
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }


    
    /** 
     * @param p
     * @return Usuario
     */
    @Override
    public Usuario save(Usuario p) {
        return usuarioRepository.save(p);
    }

    
    /** 
     * @param Id
     */
    @Override
    @Transactional
    public void deleteById(Long Id) {
        usuarioRepository.deleteById(Id);
        }


    
    /** 
     * @param user
     * @return Optional<Usuario>
     */
    @Override
    public Optional<Usuario> findByUser(String user) {
        return usuarioRepository.findByUser(user);
    }


    
    /** 
     * @param id
     * @return Optional<Usuario>
     */
    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }



    
    /** 
     * @param user
     * @param password
     * @return Optional<Usuario>
     */
    @Override
    public Optional<Usuario> UserAndPassword(String user, String password) {
        return usuarioRepository.UserAndPassword( user, password);
    }



    
    /** 
     * @param persona
     * @return Optional<Usuario>
     */
    @Override
    public Optional<Usuario> findByPersona(Persona persona) {
        return usuarioRepository.findByPersona( persona);
    }
    
}
