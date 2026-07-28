package org.karo.eg66;

import java.io.*;

public class GestorArchivos {
    // Método para GUARDAR cualquier objeto en disco
    public static void guardar(Object objeto, String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(objeto);
        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

    // Método para CARGAR un objeto desde el disco
    public static Object cargar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) return null; // Si no existe el archivo aún, retorna null

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return ois.readObject(); // Lee y devuelve el objeto guardado
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar: " + e.getMessage());
            return null;
        }
    }
}
