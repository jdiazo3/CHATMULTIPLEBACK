package chat.multiple.edu.Repository;


import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import chat.multiple.edu.Entity.Persona;
import chat.multiple.edu.Entity.Usuario;

/**
 *
 * @author juand
 */

  //interface en la que se representan las sentencias a la base de datos para la tabla Usuario por medio de JpaRepository 

public interface UsuarioRepository extends JpaRepository<Usuario ,Long>{
  /**
   * 
   * @param user
   * @return
   */
    public Optional<Usuario> findByUser(String user);

    /**
     * 
     * @param nombreUsuario
     * @return
     */
    boolean existsByUser(String nombreUsuario);
    /**
     * 
     * @param Persona
     * @return
     */
    Optional<Usuario> findByPersona(Persona Persona);
    /**
    * 
    * @param user
    * @param password
    *  @return
    */
    @Query(
                value = " SELECT * FROM user WHERE user = :user AND password = :password",
                nativeQuery = true
            )
    Optional<Usuario>UserAndPassword(@Param("user")String user,
                    @Param("password")String password);
}
