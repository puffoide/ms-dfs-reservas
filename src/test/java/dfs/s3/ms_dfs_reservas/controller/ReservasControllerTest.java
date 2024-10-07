package dfs.s3.ms_dfs_reservas.controller;

import dfs.s3.ms_dfs_reservas.model.Cita;
import dfs.s3.ms_dfs_reservas.service.CitaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@WebMvcTest(ReservasController.class)
public class ReservasControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CitaService citaService;

    @Test
    public void testGetCitas() throws Exception {
        Cita cita1 = new Cita();
        cita1.setId(1L);
        cita1.setPaciente("Juan");
        cita1.setFechaHora(LocalDateTime.now().toString());

        Cita cita2 = new Cita();
        cita2.setId(2L);
        cita2.setPaciente("Maria");
        cita2.setFechaHora(LocalDateTime.now().toString());

        when(citaService.getAllCitas()).thenReturn(List.of(cita1, cita2));

        mockMvc.perform(get("/api/citas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.[0].paciente", is("Juan")))
                .andExpect(jsonPath("$._embedded.[1].paciente", is("Maria")));
    }

    @Test
    public void testGetCitaByIdNotFound() throws Exception {
        when(citaService.getCitaById(999L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/citas/999"))
                .andExpect(status().isNotFound());
    }
}
