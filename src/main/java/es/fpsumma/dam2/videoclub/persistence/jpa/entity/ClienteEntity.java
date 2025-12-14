package es.fpsumma.dam2.videoclub.persistence.jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "cliente")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 150, unique = true)
    private String email;

    @OneToMany(mappedBy = "cliente")
    private List<AlquilerEntity> alquileres;

    public ClienteEntity() {}

    public ClienteEntity(Long id, String nombre, String email,  List<AlquilerEntity> alquileres) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.alquileres = alquileres;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<AlquilerEntity> getAlquileres() {
        return alquileres;
    }
    public void setAlquileres(List<AlquilerEntity> alquileres) {
        this.alquileres = alquileres;
    }
}
