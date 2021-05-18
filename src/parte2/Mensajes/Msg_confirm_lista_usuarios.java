package parte2.Mensajes;

import java.util.List;
import parte2.Usuario;

public class Msg_confirm_lista_usuarios extends Mensaje{
    private List<String> usuarios;

    public Msg_confirm_lista_usuarios(List<String> usuarios){
        super(TipoMensaje.MSG_CONFIRM_LISTA_USUARIOS);  
        this.usuarios = usuarios;
    }

    public List<String> getLista(){
        return this.usuarios;
    }

    public void sacarLista(){
        System.out.println(usuarios);
    }
}