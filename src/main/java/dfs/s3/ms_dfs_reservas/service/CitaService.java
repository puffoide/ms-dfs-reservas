package dfs.s3.ms_dfs_reservas.service;

import dfs.s3.ms_dfs_reservas.model.Cita;

import java.util.List;
import java.util.Optional;

public interface CitaService {

    List<Cita> getAllCitas();
    Optional<Cita> getCitaById(Long id);
    Cita saveCita(Cita cita);
    void cancelCita(Long id);
    Cita updateCita(Long id, Cita citaActualizada);
    List<Cita> getCitasDisponibles();

}
