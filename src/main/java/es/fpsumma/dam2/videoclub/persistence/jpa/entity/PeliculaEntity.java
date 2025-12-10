package es.fpsumma.dam2.videoclub.persistence.jpa.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table (name = "pelicula")
public class PeliculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String titulo;

    @Column(length = 50, nullable = true)
    private String genero;

    @Column(name = "anio_estreno", nullable = true)
    private Integer anioEstreno;

    @Column(nullable = true)
    private Double puntuacion;

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private DirectorEntity director;

    @ManyToMany
    @JoinTable(
            name = "pelicula_actor",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<ActorEntity> actores;

    public PeliculaEntity() {}

    public PeliculaEntity(Long id, String titulo, String genero, Integer anioEstreno, Double puntuacion, DirectorEntity director,  Set<ActorEntity> actores) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.anioEstreno = anioEstreno;
        this.puntuacion = puntuacion;
        this.director = director;
        this.actores = actores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(Integer anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public DirectorEntity getDirector() {
        return director;
    }

    public void setDirector(DirectorEntity director) {
        this.director = director;
    }

    public Set<ActorEntity> getActores() {
        return actores;
    }

    public void setActores(Set<ActorEntity> actores) {
        this.actores = actores;
    }
}
