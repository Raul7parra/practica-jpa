package es.fpsumma.dam2.videoclub.persistence.jpa.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "actor")
public class ActorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @ManyToMany(mappedBy = "actores")
    private Set<PeliculaEntity> peliculas;

    public ActorEntity() {}

    public ActorEntity(Long id, String nombre,  Set<PeliculaEntity> peliculas) {
        this.id = id;
        this.nombre = nombre;
        this.peliculas = peliculas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<PeliculaEntity> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(Set<PeliculaEntity> pelicula) {
        this.peliculas = pelicula;
    }
}
