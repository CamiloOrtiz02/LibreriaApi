package com.example.libreriaapi.Service;

import com.example.libreriaapi.Entity.Autor;
import com.example.libreriaapi.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    // Crear un nuevo autor
    public Autor crearAutor(String nombre) {
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setActivo(true);
        return autorRepository.save(autor);
    }

    // Obtener autor por ID
    public Autor obtenerAutorPorId(String id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
    }

    // Obtener todos los autores activos
    public List<Autor> obtenerAutoresActivos() {
        return autorRepository.findByActivoTrue();
    }

    // Actualizar el nombre de un autor
    public Autor actualizarAutor(String id, String nuevoNombre) {
        Autor autor = obtenerAutorPorId(id);
        autor.setNombre(nuevoNombre);
        return autorRepository.save(autor);
    }

    // Eliminar (desactivar) un autor sin borrarlo de la base de datos
    public void eliminarAutor(String id) {
        Autor autor = obtenerAutorPorId(id);
        autor.setActivo(false);
        autorRepository.save(autor);
    }
}
