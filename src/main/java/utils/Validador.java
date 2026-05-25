/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bleedplayer.utils;

import java.io.File;

/**
 * Clase para validar datos del sistema
 * @author jv134
 */
public class Validador {
    
    /**
     * Valida que una ruta de archivo sea válida y exista
     */
    public static boolean validarRutaArchivo(String ruta) {
        if(ruta == null || ruta.trim().isEmpty()) {
            return false;
        }
        
        File archivo = new File(ruta);
        return archivo.exists() && archivo.isFile();
    }
    
    /**
     * Valida que un archivo sea MP3
     */
    public static boolean esArchivoMP3(String ruta) {
        return ruta != null && ruta.toLowerCase().endsWith(".mp3");
    }
    
    /**
     * Valida que un campo de texto no esté vacío
     */
    public static boolean validarCampoVacio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }
    
    /**
     * Valida que no haya caracteres especiales peligrosos
     */
    public static boolean validarCaracteresPermitidos(String texto) {
        if(texto == null) return false;
        
        // Permitir letras, números, espacios y algunos símbolos musicales
        String regex = "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s\\-_.,!?'()&]+$";
        return texto.matches(regex);
    }
    
    /**
     * Valida el formato de duración (ej: 3:45, 10:22)
     */
    public static boolean validarFormatoDuracion(String duracion) {
        if(duracion == null) return false;
        
        String regex = "^\\d+:\\d{2}$";
        return duracion.matches(regex);
    }
}