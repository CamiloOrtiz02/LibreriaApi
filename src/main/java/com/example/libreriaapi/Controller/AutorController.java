package com.example.libreriaapi.Controller;

import com.example.libreriaapi.Entity.Autor;
import com.example.libreriaapi.Service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    // Crear un autor
    @PostMapping("/crear")
    public ResponseEntity<Autor> crearAutor(@RequestParam String nombre) {
        Autor autor = autorService.crearAutor(nombre);
        return ResponseEntity.status(HttpStatus.CREATED).body(autor);
    }

    // Obtener un autor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Autor> obtenerAutor(@PathVariable String id) {
        Autor autor = autorService.obtenerAutorPorId(id);
        return ResponseEntity.ok(autor);
    }

    // Obtener todos los autores activos
    @GetMapping("/activos")
    public ResponseEntity<List<Autor>> obtenerAutoresActivos() {
        List<Autor> autores = autorService.obtenerAutoresActivos();
        return ResponseEntity.ok(autores);
    }

    // Actualizar un autor
    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizarAutor(@PathVariable String id, @RequestParam String nuevoNombre) {
        Autor autorActualizado = autorService.actualizarAutor(id, nuevoNombre);
        return ResponseEntity.ok(autorActualizado);
    }

    // "Eliminar" un autor (cambia su estado a inactivo)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAutor(@PathVariable String id) {
        autorService.eliminarAutor(id);
        return ResponseEntity.ok("Autor desactivado correctamente");
    }
}
