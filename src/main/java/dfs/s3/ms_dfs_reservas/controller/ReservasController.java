package dfs.s3.ms_dfs_reservas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public List<Cita> getCitas() {
        return reservasService.getCitas();
    }

    @GetMapping("/citas/{id}")
    public Cita getCitaById(@PathVariable int id) {
        return reservasService.getCitaById(id);
    }

    @GetMapping("/horarios")
    public List<Horario> getHorariosDisponibles() {
        return reservasService.getHorariosDisponibles();
    }
}
