package chat.multiple.edu.Repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import chat.multiple.edu.Entity.Persona;

/**
 *
 * @author juand
 */

 //interface en la que se representan las sentencias a la base de datos para la tabla Persona por medio de JpaRepository 

public interface PersonaRepository extends JpaRepository<Persona ,Long>{
    /**
     * 
     * @param numdoc
     * @return
     */
    public Optional<Persona> findByNumdoc(Integer numdoc);

    @Transactional(readOnly = true)
    @Query(
        value = "select * from persona where role = 'ACTOR' or role = 'PRODUCTOR' ",
        nativeQuery = true
        )
        List<Persona>BuscarActorOProductor();
}

