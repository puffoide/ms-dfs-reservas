package dfs.s3.ms_dfs_reservas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "El nombre del paciente no puede estar vacío")
    @NotNull
    @Column(name = "paciente")
    private String paciente;

    @NotNull(message = "La fecha agendada no puede estar vacía")
    @Column(name = "fecha_hora")
    private LocalDateTime fecha_hora;

    @NotBlank(message = "El nombre del médico no puede estar vacío")
    @NotNull
    @Column(name = "medico")
    private String medico;

    @NotNull(message = "La fecha de inicio del horario no puede estar vacía")
    @Column(name = "inicio")
    private LocalDateTime inicio;

    @NotNull(message = "La fecha de fin del horario no puede estar vacía")
    @Column(name = "fin")
    private LocalDateTime fin;

    @NotNull(message = "La disponibilidad no puede estar vacía")
    @Column(name = "disponible")
    private boolean disponible;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getFechaHora() {
        return fecha_hora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fecha_hora = fechaHora;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
