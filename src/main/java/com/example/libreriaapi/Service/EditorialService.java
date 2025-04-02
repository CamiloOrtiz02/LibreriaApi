package com.example.libreriaapi.Service;

import com.example.libreriaapi.Entity.Editorial;
import com.example.libreriaapi.Repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    // Crear una nueva editorial
    public Editorial crearEditorial(String nombre) {
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorial.setActivo(true);
        return editorialRepository.save(editorial);
    }

    // Obtener una editorial por ID
    public Editorial obtenerEditorialPorId(int id) {
        return editorialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Editorial no encontrada"));
    }

    // Obtener todas las editoriales activas
    public List<Editorial> obtenerEditorialesActivas() {
        return editorialRepository.findByActivoTrue();
    }

    // Actualizar el nombre de una editorial
    public Editorial actualizarEditorial(int id, String nuevoNombre) {
        Editorial editorial = obtenerEditorialPorId(id);
        editorial.setNombre(nuevoNombre);
        return editorialRepository.save(editorial);
    }

    // "Eliminar" una editorial (soft delete)
    public void eliminarEditorial(int id) {
        Editorial editorial = obtenerEditorialPorId(id);
        editorial.setActivo(false);
        editorialRepository.save(editorial);
    }
}
