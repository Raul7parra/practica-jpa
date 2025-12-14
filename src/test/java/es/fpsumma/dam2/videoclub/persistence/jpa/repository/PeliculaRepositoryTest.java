package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.PeliculaEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


@DataJpaTest
@ActiveProfiles("test")

class PeliculaRepositoryTest {
    @Autowired
    private PeliculaRepository peliculaRepository;

    //Test para buscar películas por nombre de director
    @Test
    void testEncontrarPeliculasPorNombreDirector() {
        // El director Christopher Nolan tiene 8 películas
        String nombreDirector = "Christopher Nolan";
        List<PeliculaEntity> peliculas = peliculaRepository.findByDirectorNombre(nombreDirector);

        assertThat(peliculas)
                .as("Las películas son 8 y son de " +nombreDirector)
                .hasSize(8)
                .extracting("director.nombre")
                .containsOnly(nombreDirector);
    }

    //Test para buscar películas por nombre de actor con @Query
    @Test
    void testEncontrarPeliculasPorNombreActor() {
        // El actor Leonardo DiCaprio actua en 3 películas
        String nombreActor = "Leonardo DiCaprio";
        List<PeliculaEntity> peliculas = peliculaRepository.buscarPeliculaPorActor(nombreActor);

        assertThat(peliculas).as("Las películas son 3 y son de " +nombreActor).hasSize(3);
    }

    //Test para buscar películas por género
    @Test
    void testEncontrarPeliculasPorGenero() {
        // Hay 16 películas de Ciencia ficcion
        String genero = "Ciencia ficcion";
        List<PeliculaEntity> peliculas = peliculaRepository.findByGenero(genero);

        assertThat(peliculas).as("Las películas son 16 del género " + genero)
                .hasSize(16)
                .extracting("genero")
                .containsOnly(genero);
    }
}
