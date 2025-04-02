package com.example.libreriaapi.Service;

import com.example.libreriaapi.Entity.Autor;
import com.example.libreriaapi.Entity.Editorial;
import com.example.libreriaapi.Entity.Libro;
import com.example.libreriaapi.Repository.AutorRepository;
import com.example.libreriaapi.Repository.EditorialRepository;
import com.example.libreriaapi.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private EditorialRepository editorialRepository;

    // Crear un nuevo libro
    public Libro crearLibro(String titulo, int ejemplares, String idAutor, int idEditorial) {
        Autor autor = autorRepository.findById(idAutor)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        Editorial editorial = editorialRepository.findById(idEditorial)
                .orElseThrow(() -> new RuntimeException("Editorial no encontrada"));

        Libro libro = new Libro();
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        libro.setActivo(true);

        return libroRepository.save(libro);
    }

    // Obtener un libro por ID
    public Libro obtenerLibroPorId(int id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    // Obtener todos los libros activos
    public List<Libro> obtenerLibrosActivos() {
        return libroRepository.findByActivoTrue();
    }

    // Actualizar un libro
    public Libro actualizarLibro(int id, String nuevoTitulo, int nuevosEjemplares) {
        Libro libro = obtenerLibroPorId(id);
        libro.setTitulo(nuevoTitulo);
        libro.setEjemplares(nuevosEjemplares);
        return libroRepository.save(libro);
    }

    // "Eliminar" un libro (soft delete)
    public void eliminarLibro(int id) {
        Libro libro = obtenerLibroPorId(id);
        libro.setActivo(false);
        libroRepository.save(libro);
    }
}
