package dfs.s3.ms_dfs_reservas.controller;

import dfs.s3.ms_dfs_reservas.model.Cita;
import dfs.s3.ms_dfs_reservas.service.CitaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservasController {

    private static final Logger log = LoggerFactory.getLogger(ReservasController.class);

    @Autowired
    private CitaService citaService;

    @GetMapping("/citas")
    public List<Cita> getCitas() {
        log.info("GET /citas");
        log.info("Retornando todas las citas registradas.");
        return citaService.getAllCitas();
    }

    @GetMapping("/citas/{id}")
    public Cita getCitaById(@PathVariable Long id) {
        log.info("Obteniendo cita con ID: {}", id);
    
        return citaService.getCitaById(id).orElse(null);
    }

    @PostMapping("/citas")
    public Cita createCita(@RequestBody Cita cita) {
        log.info("Creando nueva cita: {}", cita);
        try {
            Cita nuevaCita = citaService.saveCita(cita);
            log.info("Cita creada exitosamente: {}", nuevaCita);
            return nuevaCita;
        } catch (RuntimeException e) {
            log.error("Error al crear cita: {}", e.getMessage());
            throw e; // Re-throw to let the caller handle it
        }
    }

    @PutMapping("/citas/{id}")
    public Cita updateCita(@PathVariable Long id, @RequestBody Cita citaActualizada) {
        log.info("Actualizando cita con ID: {}", id);
        try {
            Cita citaActualizadaFinal = citaService.updateCita(id, citaActualizada);
            log.info("Cita actualizada exitosamente: {}", citaActualizadaFinal);
            return citaActualizadaFinal;
        } catch (RuntimeException e) {
            log.error("Error al actualizar cita: {}", e.getMessage());
            throw e; // Re-throw to let the caller handle it
        }
    }

    @DeleteMapping("/citas/{id}")
    public void cancelCita(@PathVariable Long id) {
        log.info("Cancelando cita con ID: {}", id);
        try {
            citaService.cancelCita(id);
            log.info("Cita con ID {} cancelada exitosamente", id);
        } catch (RuntimeException e) {
            log.error("Error al cancelar cita: {}", e.getMessage());
            throw e; // Re-throw to let the caller handle it
        }
    }
}
