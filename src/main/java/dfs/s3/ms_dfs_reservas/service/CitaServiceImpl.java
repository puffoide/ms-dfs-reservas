package dfs.s3.ms_dfs_reservas.service;

import dfs.s3.ms_dfs_reservas.model.Cita;
import dfs.s3.ms_dfs_reservas.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Override
    public List<Cita> getAllCitas() {
        return citaRepository.findAll();
    }

    @Override
    public Optional<Cita> getCitaById(Long id) {
        return citaRepository.findById(id);
    }

    @Override
    public Cita saveCita(Cita cita) {
        if (cita.getInicio() == null || cita.getFin() == null) {
            throw new RuntimeException("El horario de la cita no está definido correctamente");
        }

        if (!cita.isDisponible()) {
            throw new RuntimeException("El horario no está disponible");
        }

        return citaRepository.save(cita);
    }

    @Override
    public void cancelCita(Long id) {
        Optional<Cita> citaOpt = citaRepository.findById(id);
        if (citaOpt.isPresent()) {
            Cita cita = citaOpt.get();
            cita.setDisponible(true); // Marcar el horario como disponible
            citaRepository.save(cita);
            citaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cita no encontrada");
        }
    }

    @Override
    public Cita updateCita(Long id, Cita citaActualizada) {
        Optional<Cita> citaOpt = citaRepository.findById(id);
        if (citaOpt.isPresent()) {
            Cita citaExistente = citaOpt.get();

            citaExistente.setPaciente(citaActualizada.getPaciente());
            citaExistente.setFechaHora(citaActualizada.getFechaHora());
            citaExistente.setMedico(citaActualizada.getMedico());
            citaExistente.setInicio(citaActualizada.getInicio());
            citaExistente.setFin(citaActualizada.getFin());
            citaExistente.setDisponible(citaActualizada.isDisponible());

            return citaRepository.save(citaExistente);
        } else {
            throw new RuntimeException("Cita no encontrada");
        }
    }
}
