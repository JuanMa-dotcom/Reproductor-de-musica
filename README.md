# 📖 Manual de Usuario - BleedPlayer

## Índice
1. [Introducción](#introducción)
2. [Instalación](#instalación)
3. [Guía de Uso](#guía-de-uso)
4. [Solución de Problemas](#solución-de-problemas)

---

## 1. Introducción

BleedPlayer es un reproductor de música desarrollado en Java que permite:
- Reproducir archivos MP3
- Gestionar playlists de canciones
- Visualizar portadas de álbum
- Navegar entre canciones con cola de reproducción

### Requisitos del Sistema
- Windows 10/11, macOS 10.14+, o Linux
- Java JDK 17 o superior
- Archivos MP3 con metadatos

---

## 2. Instalación

### Opción A: Ejecutar desde JAR (Recomendado)
1. Descarga `BleedPlayer.jar`
2. Doble clic en el archivo JAR
3. Si no abre, ejecuta desde terminal:
```bash
   java -jar BleedPlayer.jar
```

### Opción B: Compilar desde código fuente
1. Clonar el repositorio:
```bash
   git clone https://github.com/JuanMa-dotcom/Reproductor-de-musica.git
```

2. Abrir en NetBeans o IntelliJ IDEA

3. Ejecutar `mvn clean install`

4. Ejecutar la clase `PlayerUI.java`

---

## 3. Guía de Uso

### 3.1 Agregar Canciones

![Agregar Canción](capturas/agregar_cancion.png)

1. Haz clic en el botón **"Agregar"**
2. Selecciona un archivo MP3 desde tu computadora
3. Los metadatos se cargarán automáticamente:
   - Título
   - Artista
   - Género
   - Duración
   - Portada del álbum (si está disponible)
4. La canción aparecerá en la lista de reproducción

**Nota:** Si el archivo MP3 no tiene metadatos, se usará el nombre del archivo.

---

### 3.2 Reproducir Música

![Reproducir](capturas/reproducir.png)

1. Selecciona una canción de la lista haciendo clic sobre ella
2. Presiona el botón **"Reproducir"**
3. La canción comenzará a sonar y verás:
   - Portada del álbum (lado derecho)
   - Información de la canción (parte inferior)
   - Mensaje "Reproduciendo: [nombre]" (parte inferior)

**Características:**
- Las canciones siguientes se agregan automáticamente a la cola
- Puedes ver la cola en la consola (si ejecutas desde terminal)

---

### 3.3 Navegar entre Canciones

#### Botón "Siguiente"
- Reproduce la siguiente canción en la cola de reproducción
- Si no hay más canciones, mostrará "Cola vacía"

#### Cola de Reproducción
Al reproducir una canción, todas las canciones posteriores en la lista se agregan automáticamente a la cola siguiendo el orden FIFO (First-In-First-Out).

**Ejemplo:**
Lista: [Canción A, Canción B, Canción C, Canción D]
Reproduces: Canción A
Cola: [Canción B → Canción C → Canción D]

---

### 3.4 Pausar/Detener

1. Durante la reproducción, haz clic en **"Pausar"**
2. La música se detendrá
3. El botón cambiará a "Reanudar" (si está implementado)

---

### 3.5 Eliminar Canciones

![Eliminar](capturas/eliminar.png)

1. Selecciona la canción que deseas eliminar de la lista
2. Haz clic en el botón **"Eliminar"**
3. Confirma la eliminación en el diálogo que aparece
4. La canción se eliminará de:
   - La lista visual
   - La playlist interna
   - El archivo de datos guardado

**Nota:** Esta acción no elimina el archivo MP3 de tu computadora, solo lo quita de la playlist.

---

### 3.6 Guardar Playlist

La playlist se guarda **automáticamente** cuando:
- Agregas una canción
- Eliminas una canción

El archivo se guarda en: `playlist_data.txt` en el mismo directorio del programa.

**Formato del archivo:**
nombre|artista|genero|duracion|ruta
Bleed|Meshuggah|Metal Progresivo|7:22|C:\Music\Bleed.mp3

---

### 3.7 Cargar Playlist

Al abrir el programa, se carga automáticamente la playlist guardada anteriormente.

Si un archivo MP3 ya no existe en la ruta guardada, esa canción será omitida con un mensaje en consola.

---

## 4. Solución de Problemas

### Problema: No se reproduce el audio

**Posibles causas:**
- El archivo MP3 está corrupto
- La ruta del archivo ya no es válida
- No tienes permisos para leer el archivo

**Solución:**
1. Verifica que el archivo MP3 exista en la ruta mostrada
2. Intenta reproducir el archivo en otro reproductor
3. Vuelve a agregar la canción al programa

---

### Problema: No aparece la portada

**Causas:**
- El archivo MP3 no tiene imagen embebida en sus metadatos
- El formato de la imagen no es compatible

**Solución:**
- El programa mostrará una portada predeterminada (imagen de Meshuggah)
- Puedes editar los metadatos del MP3 con programas como Mp3tag

---

### Problema: La canción aparece como "Desconocido"

**Causa:**
- El archivo MP3 no tiene etiquetas ID3

**Solución:**
1. Usa un programa como Mp3tag o MusicBrainz Picard
2. Agrega los metadatos manualmente
3. Vuelve a agregar la canción al programa

---

### Problema: Error al guardar/cargar playlist

**Causa:**
- No tienes permisos de escritura en la carpeta
- El archivo está corrupto

**Solución:**
1. Ejecuta el programa como administrador
2. Elimina el archivo `playlist_data.txt` y reinicia
3. Verifica que tengas espacio en disco

---

### Problema: La canción duplicada

**Comportamiento:**
El programa detecta si ya existe una canción con el mismo nombre y pregunta si deseas agregarla de todas formas.

**Solución:**
- Si confirmas, la canción se agregará con sufijo " (2)"
- Si cancelas, la canción no se agregará

---

## 5. Atajos de Teclado

*Nota: Los atajos de teclado pueden implementarse en versiones futuras*

---

## 6. Formatos Soportados

### Audio
- ✅ MP3 (*.mp3)
- ❌ WAV, FLAC, OGG (no soportados actualmente)

### Imágenes de Portada
- ✅ JPG, PNG embebidas en MP3
- ✅ WebP (imagen predeterminada)

---

## 7. Contacto y Soporte

Para reportar errores o sugerir mejoras:
- **GitHub:** https://github.com/JuanMa-dotcom/Reproductor-de-musica
- **Email:** juan.valdez4064@alumnos.udg.mx 

---

## 8. Créditos

- **Desarrollador:** Juan Manuel Valdez López
- **Curso:** Estructura de Datos - 4to Semestre
- **Institución:** CUAltos
- **Bibliotecas:** JLayer, mp3agic
- **Documentacion:** Aaron Becerra, Axel Gutierrez 
---

**Versión:** 3.0  
**Última actualización:** Mayo 24 del 2026