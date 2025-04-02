package com.example.libreriaapi.Controller;

import com.example.libreriaapi.Service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.libreriaapi.Entity.Editorial;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/editorial")
public class EditorialController {

    @Autowired
    private EditorialService editorialService;

    // Crear una editorial
    @PostMapping("/crear")
    public ResponseEntity<Editorial> crearEditorial(@RequestParam String nombre) {
        Editorial editorial = editorialService.crearEditorial(nombre);
        return ResponseEntity.status(HttpStatus.CREATED).body(editorial);
    }

    // Obtener una editorial por ID
    @GetMapping("/{id}")
    public ResponseEntity<Editorial> obtenerEditorial(@PathVariable int id) {
        Editorial editorial = editorialService.obtenerEditorialPorId(id);
        return ResponseEntity.ok(editorial);
    }

    // Obtener todas las editoriales activas
    @GetMapping("/activos")
    public ResponseEntity<List<Editorial>> obtenerEditorialesActivas() {
        List<Editorial> editoriales = editorialService.obtenerEditorialesActivas();
        return ResponseEntity.ok(editoriales);
    }

    // Actualizar el nombre de una editorial
    @PutMapping("/{id}")
    public ResponseEntity<Editorial> actualizarEditorial(@PathVariable int id, @RequestParam String nuevoNombre) {
        Editorial editorialActualizada = editorialService.actualizarEditorial(id, nuevoNombre);
        return ResponseEntity.ok(editorialActualizada);
    }

    // "Eliminar" una editorial (soft delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEditorial(@PathVariable int id) {
        editorialService.eliminarEditorial(id);
        return ResponseEntity.ok("Editorial desactivada correctamente");
    }
}

