package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.ClienteEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import java.util.Optional;


@DataJpaTest
@ActiveProfiles("test")
class ClienteRepositoryTest {
    @Autowired
    private ClienteRepository clienteRepository;

    //Test para buscar un cliente por email
    @Test
    void testEncontrarClientePorEmail() {
        String email = "ana.perez@example.com";
        Optional<ClienteEntity> cliente = clienteRepository.findByEmail(email);

        assertThat(cliente).isPresent(); //Confirma que el director fue encontrado
        assertThat(cliente.get().getEmail()).isEqualTo(email); //Confirma si la variable cliente es igual a la variable email
    }

    //Test para comprobar si existe un cliente por email
    @Test
    void testExisteClientePorEmail() {
        String email = "ana.perez@example.com";
        boolean existe = clienteRepository.existsByEmail(email);
        assertThat(existe).isTrue(); //Confirma que el director existe

        String emailInexistente = "raul7parrahernandez@gmail.com";
        boolean existeInexistente = clienteRepository.existsByEmail(emailInexistente);
        assertThat(existeInexistente).isFalse(); //Confirma que el director no existe
    }
}
