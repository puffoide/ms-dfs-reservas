package dfs.s3.ms_dfs_reservas.repository;

import dfs.s3.ms_dfs_reservas.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<Cita, Long> {
}

