package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.ActorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;
import java.util.Optional;


@DataJpaTest
@ActiveProfiles("test")
class ActorRepositoryTest {
    @Autowired
    private ActorRepository actorRepository;

    //Test para buscar por actor por nombre
    @Test
    void testEncontrarActorPorNombre() {
        String nombre = "Tom Hanks";
        Optional<ActorEntity> actor = actorRepository.findByNombre(nombre);

        assertThat(actor).isPresent();
        assertThat(actor.get().getNombre()).isEqualTo(nombre);
    }

    //Test para obtener los actores por película
    @Test
    void testEncontrarActorPorPelicula() {
        String pelicula = "Inception";
        String nombre = "Leonardo DiCaprio";
        List<ActorEntity> actores = actorRepository.findByPeliculasTitulo(pelicula);

        assertThat(actores).as(pelicula + "tiene 1 actor").hasSize(1);

        assertThat(actores.get(0).getNombre()).as("El actor es " +nombre).isEqualTo(nombre);
    }
}
