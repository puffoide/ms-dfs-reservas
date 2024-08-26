package dfs.s3.ms_dfs_reservas.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dfs.s3.ms_dfs_reservas.model.Cita;
import dfs.s3.ms_dfs_reservas.model.Horario;

@RestController
public class ReservasController {

    private List<Cita> citas = new ArrayList<>();
    private List<Horario> horarios = new ArrayList<>();

    public ReservasController() {

        citas.add(new Cita(1, "Felipe Salgado", LocalDateTime.of(2024, 8, 26, 11, 0), "Gabriel"));
        citas.add(new Cita(2, "Melanie Contreras", LocalDateTime.of(2024, 8, 26, 14, 0), "Juan"));

        horarios.add(new Horario(LocalDateTime.of(2024, 8, 26, 9, 0),
                LocalDateTime.of(2024, 8, 26, 10, 0),
                true));
        horarios.add(new Horario(LocalDateTime.of(2024, 8, 26, 10, 0),
                LocalDateTime.of(2024, 8, 26, 11, 0),
                true));
        horarios.add(new Horario(LocalDateTime.of(2024, 8, 26, 11, 0),
                LocalDateTime.of(2024, 8, 26, 12, 0),
                false));
        horarios.add(new Horario(LocalDateTime.of(2024, 8, 26, 12, 0),
                LocalDateTime.of(2024, 8, 26, 10, 0),
                true));
        horarios.add(new Horario(LocalDateTime.of(2024, 8, 26, 13, 0),
                LocalDateTime.of(2024, 8, 26, 11, 0),
                true));
        horarios.add(new Horario(LocalDateTime.of(2024, 8, 26, 14, 0),
                LocalDateTime.of(2024, 8, 26, 12, 0),
                false));
    }

    @GetMapping("/citas")
    public List<Cita> getCita() {

        return citas;
    }

    @GetMapping("/citas/{id}")
    public Cita getCitaById(@PathVariable int id) {
        for (Cita cita : citas) {
            if (cita.getId() == id) {
                return cita;
            }
        }
        return null;
    }

    @GetMapping("/horarios")
    public List<Horario> getHorarioByDisp() {

        List<Horario> horariosDisp = horarios.stream()
                .filter(horarios -> horarios.isDisponible() == true)
                .collect(Collectors.toList());

        return horariosDisp;
    }

}
