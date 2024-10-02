package dfs.s3.ms_dfs_reservas.service;

import dfs.s3.ms_dfs_reservas.model.Cita;
import dfs.s3.ms_dfs_reservas.repository.CitaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CitaServiceTest {

    @InjectMocks
    private CitaServiceImpl citaService;

    @Mock
    private CitaRepository citaRepository;

    @Test
    public void testCreateCita() {
        Cita cita = new Cita();
        cita.setPaciente("Carlos");
        cita.setFechaHora(LocalDateTime.now());
        cita.setMedico("Dr. Lopez");
        cita.setInicio(LocalDateTime.now().minusHours(2));
        cita.setFin(LocalDateTime.now());
        cita.setDisponible(true);

        when(citaRepository.save(any(Cita.class))).thenReturn(cita);

        Cita result = citaService.saveCita(cita);

        assertEquals("Carlos", result.getPaciente());
        verify(citaRepository, times(1)).save(cita);
    }
}
