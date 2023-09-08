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

import chat.multiple.edu.Entity.Mensaje;
import chat.multiple.edu.Entity.Persona;
import chat.multiple.edu.Entity.Usuario;
import chat.multiple.edu.Service.MensajeServiceImpl;

/**
 *
 * @author juand
 */

 /**
 *Controlador que responde al llamado de http://localhost:8090/personas
 */
@CrossOrigin(origins ="http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/mensajes")
public class MensajeController {
    
    @Autowired
    private MensajeServiceImpl mensajeService;

    /** 
     * @param p
     * @return ResponseEntity<?>
     */
    //crear un nuevo mensaje
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Usuario p){
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
     


    /** 
     * @return ResponseEntity<?>
     */
    @GetMapping
    public ResponseEntity<?> read() {
        List<Mensaje> oMensaje = mensajeService.findByMensajeOrderBy();
        return ResponseEntity.ok(oMensaje);
    }

}
