package com.example.libreriaapi.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Libro {
    @Id
    private int id;
    private int ejemplares;
    private boolean activo;
    private String titulo;

    @ManyToOne
    private Autor autor;

    @ManyToOne
    private Editorial editorial;

}
