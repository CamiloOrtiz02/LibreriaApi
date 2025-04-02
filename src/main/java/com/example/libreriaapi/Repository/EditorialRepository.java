package com.example.libreriaapi.Repository;

import com.example.libreriaapi.Entity.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Integer> {
    List<Editorial> findByActivoTrue();
}

