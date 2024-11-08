package co.edu.ufps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Partido;
import co.edu.ufps.repositories.PartidoRepository;


@Service
public class PartidoService {

	@Autowired
	PartidoRepository partidoRepository;
	
	
	public List<Partido> list() {
		return partidoRepository.findAll();
	}
	
//	buscar en el partido por id (GET-> obtener)

	public Partido getListar1(Integer id) {
		Optional<Partido> partidoOpt =  partidoRepository.findById(id);
		
		if (partidoOpt.isPresent()) {
			return partidoOpt.get();
		}
		
		return null;
		}
	
//	actualizar, crea un nuevo registro (POST)
	
	public Partido crearPartido(Partido p) {
		return partidoRepository.save(p);
	}
	
	// Modificar (actualizar un Partido existente)
    
    public Partido update(Integer id,Partido partidoDetails) {
        return partidoRepository.findById(id)
                .map(partido -> {
                    partido.setFecha(partidoDetails.getFecha());
           
                    return partidoRepository.save(partido);
                }).orElseThrow(() -> new RuntimeException("Partido no encontrado con el id: " + id));
    }
    
    public String deletePartido(Integer id) {
    	Optional<Partido> partidoOpt =  partidoRepository.findById(id);
		
		if (partidoOpt.isPresent()) {
			
			Partido partido = partidoOpt.get();
			partidoRepository.delete(partido);
			return "Se ha elimado correctamente a " + partido;
		}
		
		return null;
	}
	
}
