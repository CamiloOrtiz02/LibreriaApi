package com.example.libreriaapi.Controller;

import com.example.libreriaapi.Entity.Libro;
import com.example.libreriaapi.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libro")
public class LibroController {

    @Autowired
    private LibroService libroService;

    // Crear un libro
    @PostMapping("/crear")
    public ResponseEntity<Libro> crearLibro(
            @RequestParam String titulo,
            @RequestParam int ejemplares,
            @RequestParam String idAutor,
            @RequestParam int idEditorial) {
        Libro libro = libroService.crearLibro(titulo, ejemplares, idAutor, idEditorial);
        return ResponseEntity.status(HttpStatus.CREATED).body(libro);
    }

    // Obtener un libro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerLibro(@PathVariable int id) {
        Libro libro = libroService.obtenerLibroPorId(id);
        return ResponseEntity.ok(libro);
    }

    // Obtener todos los libros activos
    @GetMapping("/activos")
    public ResponseEntity<List<Libro>> obtenerLibrosActivos() {
        List<Libro> libros = libroService.obtenerLibrosActivos();
        return ResponseEntity.ok(libros);
    }

    // Actualizar un libro
    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(
            @PathVariable int id,
            @RequestParam String nuevoTitulo,
            @RequestParam int nuevosEjemplares) {
        Libro libroActualizado = libroService.actualizarLibro(id, nuevoTitulo, nuevosEjemplares);
        return ResponseEntity.ok(libroActualizado);
    }

    // "Eliminar" un libro (soft delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLibro(@PathVariable int id) {
        libroService.eliminarLibro(id);
        return ResponseEntity.ok("Libro desactivado correctamente");
    }
}

