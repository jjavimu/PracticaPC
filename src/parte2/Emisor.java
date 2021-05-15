package parte2;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.File;
import java.nio.file.Files;


public class Emisor implements Runnable { // Funciona como el servidor de la entrega 1
    private String nombre_fichero;

    public Emisor(String nombre_fichero) {
        this.nombre_fichero = nombre_fichero;
    }

    public void run() {
        try {
            // Crear ServerSocket
            ServerSocket es = new ServerSocket(500); // Cambiar puertos *******

            // Me quedo esperando a la peticion del receptor
            Socket si = es.accept();

            // Accedo flujo de salida del emisor
            ObjectOutputStream fout = new ObjectOutputStream(si.getOutputStream());

            // Conexion establecida
            System.out.println("[Emisor]: Conexion establecida con el Receptor");

            
            
            // -----------------------------------------------------------
            System.out.print("Buscando...");
            File fichero = new File("src/parte2/ClienteRecursos/" + this.nombre_fichero); // ruta
            byte[] contenido = Files.readAllBytes(fichero.toPath());
            
            // Escribir informacion por salida
            fout.write(contenido); // out es outputStream
            fout.flush();
            System.out.print("Mensaje enviado");
            // ------------------------------------------------------------

            // Conexion finalizada
            System.out.println("[Emisor]: Conexion finalizada con el Receptor");

            fout.close();
            si.close();
            es.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[Emisor]: Error");
        }

    }

}