package com.example.libreriaapi.Repository;

import com.example.libreriaapi.Entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
    List<Libro> findByActivoTrue();  // Devuelve solo los libros activos
}
