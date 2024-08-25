package dfs.s3.ms_dfs_reservas.model;

import java.time.LocalDateTime;

public class Horario {
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private boolean disponible;

    public Horario(LocalDateTime inicio, LocalDateTime fin, boolean disponible) {
        this.inicio = inicio;
        this.fin = fin;
        this.disponible = disponible;
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
