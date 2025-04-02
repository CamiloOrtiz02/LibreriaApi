package com.example.libreriaapi.Repository;

import com.example.libreriaapi.Entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, String> {
    List<Autor> findByActivoTrue();
}
