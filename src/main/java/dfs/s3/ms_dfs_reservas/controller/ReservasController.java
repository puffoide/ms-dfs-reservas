package dfs.s3.ms_dfs_reservas.controller;

import dfs.s3.ms_dfs_reservas.controller.ReservaNotFoundException;
import dfs.s3.ms_dfs_reservas.model.Cita;
import dfs.s3.ms_dfs_reservas.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/citas")
public class ReservasController {

    private static final Logger log = LoggerFactory.getLogger(ReservasController.class);

    @Autowired
    private CitaService citaService;

    // Obtener todas las citas 
    @GetMapping
    public CollectionModel<EntityModel<Cita>> getCitas() {
        log.info("GET /citas");
        log.info("Retornando todas las citas registradas.");
        List<Cita> citas = citaService.getAllCitas();

        List<EntityModel<Cita>> citaResources = citas.stream()
                .map(cita -> EntityModel.of(cita,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getCitaById(cita.getId())).withSelfRel()))
                .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getCitas());
        return CollectionModel.of(citaResources, linkTo.withRel("citas"));
    }

    // Obtener una cita por ID 
    @GetMapping("/{id}")
public EntityModel<Cita> getCitaById(@PathVariable Long id) {
    log.info("GET /citas/{}", id);
    Optional<Cita> cita = citaService.getCitaById(id);

    if (cita.isPresent()) {
        return EntityModel.of(cita.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getCitaById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getCitas()).withRel("all-citas"));
    } else {
        throw new ReservaNotFoundException("Cita no encontrada con id: " + id);
    }
}


    // Crear una nueva cita 
    @PostMapping
    public EntityModel<Cita> createCita(@Validated @RequestBody Cita cita) {
        log.info("POST /citas");
        Cita nuevaCita = citaService.saveCita(cita);
        return EntityModel.of(nuevaCita,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getCitaById(nuevaCita.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getCitas()).withRel("all-citas"));
    }

    // Actualizar una cita 
    @PutMapping("/{id}")
    public EntityModel<Cita> updateCita(@PathVariable Long id, @RequestBody Cita citaActualizada) {
        log.info("PUT /citas/{}", id);
        Cita citaActualizadaFinal = citaService.updateCita(id, citaActualizada);
        return EntityModel.of(citaActualizadaFinal,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getCitaById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getCitas()).withRel("all-citas"));
    }

    // Cancelar una cita
    @DeleteMapping("/{id}")
    public void cancelCita(@PathVariable Long id) {
        log.info("DELETE /citas/{}", id);
        citaService.cancelCita(id);
    }

    // Clase para manejar excepciones
    static class ReservaNotFoundException extends RuntimeException {
        public ReservaNotFoundException(String message) {
            super(message);
        }
    }
}
