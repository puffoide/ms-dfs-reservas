package dfs.s3.ms_dfs_reservas.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import dfs.s3.ms_dfs_reservas.model.Cita;

public interface CitaRepository extends JpaRepository<Cita, Long> {
}

