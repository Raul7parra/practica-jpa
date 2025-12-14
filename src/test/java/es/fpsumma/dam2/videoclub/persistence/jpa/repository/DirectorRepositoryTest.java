package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.DirectorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class DirectorRepositoryTest {

    @Autowired
    private DirectorRepository directorRepository;

    //Test para buscar por nombre exacto
    @Test
    void deberiaEncontrarDirectorPorNombre() {
        String nombre = "Christopher Nolan";
        Optional<DirectorEntity> resultado = directorRepository.findByNombre("Christopher Nolan");

        assertThat(resultado).isPresent(); //Confirma que el director fue encontrado
        assertThat(resultado.get().getNombre()).isEqualTo(nombre); //Confirma si la variable resultado es igual a la variable nombre
    }

    //Test para buscar por nombre exacto con @Query
    @Test
    void deberiaEncontrarDirectorPorNombre_conQuery() {
        String nombre = "Steven Spielberg";
        Optional<DirectorEntity> director = directorRepository.buscarPorNombre(nombre);

        assertThat(director).isPresent(); //Confirma que el director fue encontrado
        assertThat(director.get().getNombre()).isEqualTo(nombre); //Confirma si la variable director es igual a la variable nombre
    }

    //Test para comprobar si existe un director por nombre
    @Test
    void deberiaEncontrarExistenciaDirector(){
        String nombre = "Christopher Nolan";
        boolean existe = directorRepository.existsByNombre(nombre);
        assertThat(existe).isTrue(); //Confirma que el director existe

        String nombreInexistente = "Raul Parra";
        boolean noExiste = directorRepository.existsByNombre(nombreInexistente);
        assertThat(noExiste).isFalse(); //Confirma que el director no existe
    }
}
