package chat.multiple.edu.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chat.multiple.edu.Entity.Persona;
import chat.multiple.edu.Entity.Usuario;
import chat.multiple.edu.Service.PersonaService;
import chat.multiple.edu.Service.UsuarioService;

/**
 *
 * @author juand
 */

 /**
 *Controlador que responde al llamado de http://localhost:8090/personas
 */
@CrossOrigin(origins ="http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/personas")
public class PersonaController {
    
    @Autowired
    private PersonaService personaService;

    @Autowired
    private UsuarioService usuarioService;
    
    
    /** 
     * @param p
     * @return ResponseEntity<?>
     */
    //crear un nueva persona
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Usuario p){
        Integer docu = p.getPersona().getNumdoc();
        Usuario adicionU = null;
        Usuario newUsuario = null;
        Persona newPersona = null;
            if(!personaService.findByNumdoc(docu).isPresent() &&  !usuarioService.findByUser(p.getUser()).isPresent() ){
                newPersona = p.getPersona();
                usuarioService.save(adicionU);
                Persona newPersonacreada = crearpersonanueva(newPersona);;
                newUsuario=p;
                newUsuario.setPersona(newPersonacreada);
                usuarioService.save(newUsuario);
                    return ResponseEntity.status(HttpStatus.CREATED).body(newUsuario);
            }else if(usuarioService.findByUser(p.getUser()).isPresent()){
                return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
            }else{
                return ResponseEntity.notFound().build();
            }
    }
     

    private Persona crearpersonanueva(Persona persona){
       return personaService.save(persona);
    }


    /** 
     * @param numdoc
     * @return ResponseEntity<?>
     */
    //buscar por documento
    @GetMapping(value = "/doc/{numdoc}")
    public ResponseEntity<?> read(@PathVariable Integer numdoc) {
        Optional<Persona> oPersona = personaService.findByNumdoc(numdoc);
        if(!personaService.findByNumdoc(numdoc).isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oPersona);
    }
    
    
    /** 
     * @param numdoc
     * @return ResponseEntity<?>
     */
    //elimina personas por documento
    @DeleteMapping("/{numdoc}")
         public ResponseEntity<?> delete(@PathVariable Integer numdoc){
            Optional<Persona> oPersona = personaService.findByNumdoc(numdoc);
         if(!personaService.findByNumdoc(numdoc).isPresent()){
            return ResponseEntity.notFound().build();
         }
         personaService.deleteById(oPersona.get().getId());
         return ResponseEntity.ok().build();
         }
}
