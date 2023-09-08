package chat.multiple.edu.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.json.Json;
import javax.json.JsonObject;

import chat.multiple.edu.Entity.Persona;
import chat.multiple.edu.Entity.Usuario;
import chat.multiple.edu.Service.PersonaService;
import chat.multiple.edu.Service.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 *
 * @author juand
 */

/**
 *Controlador que responde al llamado de http://localhost:8090/usuarios
 */
@CrossOrigin(origins ="http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PersonaService personaService;

    
    /** 
     * @return List<Usuario>
     */
    //obtiene los usuarios
    @GetMapping(value = "")
    public List<Usuario>findAll(){
        List<Usuario> oUsuario = StreamSupport
        .stream(usuarioService.findAll().spliterator(), false)
        .collect(Collectors.toList());
        return oUsuario;
    }

    
    /** 
     * @param p
     * @return ResponseEntity<?>
     */
    //crear un usuario
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Usuario p){
        String user = p.getUser();
        Optional<Persona> personaa = personaService.findById(p.getPersona().getId());
        if(!usuarioService.findByUser(user).isPresent() && personaa.isPresent()){
            p.setPersona(personaa.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(p));
        }else{
            return ResponseEntity.notFound().build();
        }
        
    }
     
    
    /** 
     * @param nom
     * @return ResponseEntity<?>
     */
    //buscar por usuario
    @GetMapping(value = "/doc/{nom}")
    public ResponseEntity<?> read(@PathVariable String nom) {
        Optional<Usuario> oUsuario = usuarioService.findByUser(nom);
        if(!usuarioService.findByUser(nom).isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oUsuario);
    }


    
    /** 
     * @param p
     * @return ResponseEntity<?>
     */
    @PostMapping(value = "/auth")
    public ResponseEntity<?> auth(@RequestBody Usuario p){
       Optional<Usuario> status = usuarioService.UserAndPassword(p.getUser(),p.getPassword());
       if(status.isPresent()){
        String KEY = "asdfjgkglldkkd";
        Long tiempo = System.currentTimeMillis();
        String usuario = status.get().getUser();
        String id = status.get().getId().toString(status.get().getId());
        String jwt = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, KEY)
                    .setSubject(usuario)
                    .setIssuedAt(new Date(tiempo))
                    .setExpiration(new Date(tiempo+20000000))
                    .claim("id", id)
                    .compact();
        JsonObject json = Json.createObjectBuilder().add("JWT",jwt).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(json);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}

