package dfs.s3.ms_dfs_reservas.model;

import org.springframework.hateoas.RepresentationModel;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "cita")
public class Cita extends RepresentationModel<Cita> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "paciente")
    private String paciente;

    @Column(name = "fecha_hora")
    @NotNull(message = "La fecha agendada no puede estar vacía")
    private String fecha_hora;

    @Column(name = "medico")
    @NotBlank(message = "El nombre del médico no puede estar vacío")
    @NotNull
    private String medico;

    @Column(name = "inicio")
    @NotNull(message = "La fecha de inicio del horario no puede estar vacía")
    private String inicio;
    
    @Column(name = "fin")
    @NotNull(message = "La fecha de fin del horario no puede estar vacía")
    private String fin;

    @Column(name = "disponible", columnDefinition = "CHAR(1)", nullable = false)
    @NotNull(message = "La disponibilidad no puede estar vacía")
    private String disponible;  // Almacenado como CHAR(1), 'S' o 'N'

    // Getters y Setters
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

    public String getFechaHora() {
        return fecha_hora;
    }

    public void setFechaHora(String fechaHora) {
        this.fecha_hora = fechaHora;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    // Getter que devuelve boolean
    public boolean isDisponible() {
        return this.disponible != null && this.disponible.equals("S");
    }

    // Setter que recibe boolean y lo convierte a 'S' o 'N'
    public void setDisponible(boolean disponible) {
        this.disponible = disponible ? "S" : "N";
    }
}
