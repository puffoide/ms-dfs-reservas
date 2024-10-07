package dfs.s3.ms_dfs_reservas.repository;

import dfs.s3.ms_dfs_reservas.model.Cita;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CitaRepositoryTest {

    @Autowired
    private CitaRepository citaRepository;

    @Test
    public void testSaveCita() {
        Cita cita = new Cita();
        cita.setPaciente("Pedro");
        cita.setFechaHora(LocalDateTime.now().toString());
        cita.setMedico("Dr. Smith");
        cita.setInicio(LocalDateTime.now().minusHours(1).toString());
        cita.setFin(LocalDateTime.now().toString());
        cita.setDisponible(true);

        Cita savedCita = citaRepository.save(cita);

        assertNotNull(savedCita.getId());
        assertEquals("Pedro", savedCita.getPaciente());
    }
}
