package dfs.s3.ms_dfs_reservas.model;

import java.time.LocalDateTime;

public class Cita {
    private int id;
    private String paciente;
    private LocalDateTime fechaHora;
    private String medico;

    public Cita(int id, String paciente, LocalDateTime fechaHora, String medico) {
        this.id = id;
        this.paciente = paciente;
        this.fechaHora = fechaHora;
        this.medico = medico;
    }

    public int getId() {
        return id; 
    }

    public void setId(int id) {
        this.id = id; 
    }

    public String getPaciente() {
        return paciente; 
    
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente; 
    }

    public LocalDateTime getFechaHora() {
        return fechaHora; 
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora; 
    }

    public String getMedico() {
        return medico; 
    }

    public void setMedico(String medico) {
        this.medico = medico; 
    }

}
