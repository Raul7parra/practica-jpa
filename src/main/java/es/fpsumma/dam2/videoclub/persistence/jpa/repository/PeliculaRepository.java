package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.PeliculaEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeliculaRepository extends JpaRepository <PeliculaEntity,Long> {
    //Obtener todas las películas de un determinado director, usando el nombre del director
    List<PeliculaEntity> findByDirectorNombre(String director);

    //Obtener todas las películas de un determinado género
    List<PeliculaEntity> findByGenero(String genero);

    //Obtener las películas con una puntuación mínima
    List<PeliculaEntity> findByPuntuacionGreaterThanEqual(Double puntuacion);

    //(@QUERY)Obtener todas las películas en las que participe en las que participe
    //un actor cuyo nombre se pasa por parámetro, usando la relación muchos-a-muchos Película-Actor
    @Query ("SELECT p FROM PeliculaEntity p JOIN p.actores a WHERE a.nombre = :nombreActor")
    List<PeliculaEntity> buscarPeliculaPorActor (@Param("nombreActor") String nombreActor);

    //Paginación: obtener las películas de un género concreto de forma paginada
    List<PeliculaEntity> findByGenero(String genero, Pageable pageable);

    //Ordenación: obtener las películas ordenadas por año de estreno o por puntuación
    List<PeliculaEntity> findAll(Sort sort);

}
