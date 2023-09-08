package chat.multiple.edu.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chat.multiple.edu.Dto.MensajeNewDto;
import chat.multiple.edu.Entity.Mensaje;
import chat.multiple.edu.Entity.Usuario;
import chat.multiple.edu.Service.MensajeServiceImpl;
import chat.multiple.edu.Service.UsuarioService;

/**
 *
 * @author juand
 */

 /**
 */
@CrossOrigin(origins ="https://dbt3llfc-4200.use2.devtunnels.ms/",maxAge = 3600)
@RestController
@RequestMapping("/mensajes")
public class MensajeController {
    
    @Autowired
    private MensajeServiceImpl mensajeService;
    @Autowired
    private UsuarioService usuarioService;

    /** 
     * @param p
     * @return ResponseEntity<?>
     */
    //crear un nuevo mensaje
    @PostMapping
    public ResponseEntity<?> create(@RequestBody MensajeNewDto m){
        Optional<Usuario> usuario = usuarioService.findByUser(m.getUsuario());
        Mensaje newMensaje = new Mensaje();
        newMensaje.setMensaje(m.getMensaje());
        usuario.ifPresent(u -> newMensaje.setUsuario(u));
        mensajeService.save(newMensaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMensaje);
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
