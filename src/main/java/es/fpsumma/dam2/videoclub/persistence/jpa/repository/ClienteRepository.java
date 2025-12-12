package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.ClienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    //Buscar un cliente por nombre
    Optional<ClienteEntity> findByEmail (String email);

    //Comprobar si existe ya un cliente registrado con un determinado email
    boolean existsByEmail(String email);

    //Paginación: obtener la lista de clientes de forma paginada
    Page<ClienteEntity> findAll (Pageable pageable);
}
