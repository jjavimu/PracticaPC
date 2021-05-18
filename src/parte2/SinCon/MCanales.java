package parte2.SinCon;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class MCanales {

    // Clave - nombre usuario , Valor - flujo entrada y salida
    private HashMap<String, Pair<ObjectInputStream,ObjectOutputStream>> tabla = new HashMap<>();

    public MCanales(){}

    public synchronized void setCanales(String nombre, ObjectInputStream in,ObjectOutputStream out){
        Pair<ObjectInputStream,ObjectOutputStream> par = new Pair<ObjectInputStream,ObjectOutputStream>(in, out);
        tabla.put(nombre, par);
    }
    
    public synchronized Pair<ObjectInputStream,ObjectOutputStream> getCanales (String nombre_usuario){
        return tabla.get(nombre_usuario);
    }

    public synchronized void desconectar(String nombre_usuario) {
        tabla.remove(nombre_usuario);
    }
}
