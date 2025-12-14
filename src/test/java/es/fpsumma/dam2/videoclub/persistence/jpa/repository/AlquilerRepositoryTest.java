package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.AlquilerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


import java.util.List;

@DataJpaTest
@ActiveProfiles("test")

class AlquilerRepositoryTest {
    @Autowired
    private AlquilerRepository alquilerRepository;

    //Test para buscar todos los alquileres de un cliente usando su email
    @Test
    void testEncontrarAlquilerClientePorEmail() {
        // La cliente "ana.perez@example.com" tiene 3 alquileres
        String email = "ana.perez@example.com";
        List<AlquilerEntity> alquileres = alquilerRepository.findByClienteEmail(email);

        assertThat(alquileres).as("Ana Pérez tiene 2 alquileres").hasSize(2);
    }

    //Test para buscar todos los alquileres activos de un cliente usando su email @Query
    @Test
    void testEncontrarAlquilerClientePorEmail_ConQuery() {
        String email = "ana.perez@example.com";
        List<AlquilerEntity> alquileres = alquilerRepository.findByClienteEmailAndFechaDevolucionIsNull(email);

        assertThat(alquileres).as("Ana Pérez tiene 1 alquiler activo").hasSize(1)
                // El allSatisfy para comprobar que todas las condiciones son correctas sino dará error.
                .allSatisfy(alquiler -> {
                    assertThat(alquiler.getCliente().getEmail()).isEqualTo(email);
                    assertThat(alquiler.getFechaDevolucion()).isNull();
                });
    }
}
