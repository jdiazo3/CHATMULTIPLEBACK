package chat.multiple.edu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import chat.multiple.edu.Entity.Mensaje;
import chat.multiple.edu.Repository.MensajeRepository;

@Service
public class MensajeServiceImpl implements MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;
    
    /** 
     * @param p
     * @return Persona
     */
    @Override
    public Mensaje save(Mensaje p) {
        return mensajeRepository.save(p);
    }


    @Override
    public List<Mensaje> findByMensajeOrderBy() {
        return mensajeRepository.findByMensajeOrderBy();
        }



}
