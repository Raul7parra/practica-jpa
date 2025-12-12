package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.AlquilerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlquilerRepository extends JpaRepository <AlquilerEntity, Long>{
    //Obtener todos los alquiler de un cliente usando su email
    List<AlquilerEntity> findByClienteEmail (String email);

    //Obtener todos los alquileres de una película usando su título
    List<AlquilerEntity> findByPeliculaTitulo (String titulo);

    //Obtener todos los alquileres activos, es decir, aquellos que aún no tienen fecha de devolución
    List<AlquilerEntity> findByFechaDevolucionIsNull ();

    //(@Query) Crear una consulta que devuelva los alquileres activos de un determinado cliente a partir de su email
    @Query ("SELECT a FROM AlquilerEntity a WHERE a.cliente.email = :emailCliente AND a.fechaDevolucion IS NULL")
    List<AlquilerEntity> findByClienteEmailAndFechaDevolucionIsNull(@Param("emailCliente") String email);
}

