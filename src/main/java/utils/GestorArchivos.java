package com.mycompany.bleedplayer.utils;

import com.mycompany.bleedplayer.model.Playlist;
import com.mycompany.bleedplayer.model.NodoCancion;
import java.io.*;

/**
 * Gestiona la persistencia de datos (guardar/cargar playlist)
 * @author jv134
 */
public class GestorArchivos {
    
    private static final String ARCHIVO_PLAYLIST = "playlist_data.txt";
    
    /**
     * Guardar playlist en archivo
     */
    public static boolean guardarPlaylist(Playlist playlist) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_PLAYLIST))) {
            
            NodoCancion actual = playlist.getFrente();  // ← CAMBIO AQUÍ
            
            while(actual != null) {
                // Formato: nombre|artista|genero|duracion|ruta
                String linea = actual.nombre + "|" + 
                              actual.artista + "|" + 
                              actual.genero + "|" + 
                              actual.duracion + "|" + 
                              actual.rutaArchivo;
                
                writer.write(linea);
                writer.newLine();
                
                actual = actual.siguiente;
            }
            
            System.out.println("Playlist guardada en: " + ARCHIVO_PLAYLIST);
            return true;
            
        } catch(IOException e) {
            System.out.println("Error al guardar playlist: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Cargar playlist desde archivo
     */
    public static Playlist cargarPlaylist() {
        Playlist playlist = new Playlist();
        File archivo = new File(ARCHIVO_PLAYLIST);
        
        if(!archivo.exists()) {
            System.out.println("No existe archivo de playlist previo");
            return playlist;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            
            String linea;
            while((linea = reader.readLine()) != null) {
                String[] datos = linea.split("\\|");
                
                if(datos.length == 5) {
                    String nombre = datos[0];
                    String artista = datos[1];
                    String genero = datos[2];
                    String duracion = datos[3];
                    String ruta = datos[4];
                    
                    // Verificar que el archivo todavía existe
                    if(Validador.validarRutaArchivo(ruta)) {
                        playlist.agregarCancion(nombre, artista, genero, duracion, ruta);
                        System.out.println("Canción cargada: " + nombre);
                    } else {
                        System.out.println("Archivo no encontrado, omitiendo: " + nombre);
                    }
                }
            }
            
            System.out.println("Playlist cargada desde: " + ARCHIVO_PLAYLIST);
            
        } catch(IOException e) {
            System.out.println("Error al cargar playlist: " + e.getMessage());
            e.printStackTrace();
        }
        
        return playlist;
    }
}