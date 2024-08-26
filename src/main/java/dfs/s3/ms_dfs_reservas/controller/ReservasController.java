package dfs.s3.ms_dfs_reservas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import dfs.s3.ms_dfs_reservas.model.Cita;
import dfs.s3.ms_dfs_reservas.model.Horario;
import dfs.s3.ms_dfs_reservas.service.ReservasService;

import java.util.List;

@RestController
public class ReservasController {

    @Autowired
    private ReservasService reservasService;

    @GetMapping("/citas")
    public ResponseEntity<List<Cita>> getCitas() {
        List<Cita> cita = reservasService.getCitas();
        return ResponseEntity.ok(cita);
    }

    @GetMapping("/citas/{id}")
    public ResponseEntity<Cita> getCitaById(@PathVariable int id) {
        Cita cita = reservasService.getCitaById(id);
        if (cita == null) {
            return ResponseEntity.notFound().build();
        } else
            return ResponseEntity.ok(cita);
    }

    @GetMapping("/horarios")
    public ResponseEntity<List<Horario>> getHorariosDisponibles() {
        List<Horario> horarios = reservasService.getHorariosDisponibles();
        return ResponseEntity.ok(horarios);
    }
}
