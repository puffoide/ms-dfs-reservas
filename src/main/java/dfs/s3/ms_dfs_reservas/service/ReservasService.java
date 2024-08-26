package dfs.s3.ms_dfs_reservas.service;

import dfs.s3.ms_dfs_reservas.model.Cita;
import dfs.s3.ms_dfs_reservas.model.Horario;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservasService {
    private List<Cita> citas = new ArrayList<>();
    private List<Horario> horarios = new ArrayList<>();

    public ReservasService() {
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
                LocalDateTime.of(2024, 8, 26, 13, 0),
                true));
        horarios.add(new Horario(LocalDateTime.of(2024, 8, 26, 13, 0),
                LocalDateTime.of(2024, 8, 26, 14, 0),
                true));
        horarios.add(new Horario(LocalDateTime.of(2024, 8, 26, 14, 0),
                LocalDateTime.of(2024, 8, 26, 15, 0),
                false));
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public Cita getCitaById(int id) {
        return citas.stream()
                .filter(cita -> cita.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Horario> getHorariosDisponibles() {
        return horarios.stream()
                .filter(Horario::isDisponible)
                .collect(Collectors.toList());
    }
}

