package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository <ActorEntity, Long> {
    //Buscar un actor por nombre


    //Obtener todos los actores que han participado en una película cuyo título se pasa como parámetro


    //Ordenación: obtener actores ordenados alfabéticamente por nombre
}
