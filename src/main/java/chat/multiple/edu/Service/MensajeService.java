package chat.multiple.edu.Service;

import java.util.List;
import chat.multiple.edu.Entity.Mensaje;

public interface MensajeService {
    /**
     * 
     * @param p
     * @return
     */
    public Mensaje save(Mensaje p);
    /**
     * 
     * @return
     */
    public List<Mensaje>findByMensajeOrderBy();

}