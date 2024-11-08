package co.edu.ufps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Estadio;
import co.edu.ufps.entities.Partido;
import co.edu.ufps.repositories.EstadioRepository;
import co.edu.ufps.repositories.PartidoRepository;


@Service
public class EstadioService {

	@Autowired
	EstadioRepository estadioRepository;
	
	@Autowired
	public PartidoRepository partidoRepository;
	
	
	public List<Estadio> list() {
		return estadioRepository.findAll();
	}
	
//	buscar en el estadio por id (GET-> obtener)

	public Estadio getListar1(Integer id) {
		Optional<Estadio> estadioOpt =  estadioRepository.findById(id);
		
		if (estadioOpt.isPresent()) {
			return estadioOpt.get();
		}
		
		return null;
		}
	
//	actualizar, crea un nuevo registro (POST)
	
	public Estadio crearPersona(Estadio p) {
		return estadioRepository.save(p);
	}
	
	// Modificar (actualizar un Estadio existente)
    
    public Estadio update(Integer id,Estadio estadioDetails) {
        return estadioRepository.findById(id)
                .map(estadio -> {
                    estadio.setNombre(estadioDetails.getNombre());
                    estadio.setCapacidad(estadioDetails.getCapacidad());
                    return estadioRepository.save(estadio);
                }).orElseThrow(() -> new RuntimeException("Estadio no encontrado con el id: " + id));
    }
    
    public String deleteEstadio(Integer id) {
    	Optional<Estadio> estadioOpt =  estadioRepository.findById(id);
		
		if (estadioOpt.isPresent()) {
			
			Estadio estadio = estadioOpt.get();
			estadioRepository.delete(estadio);
			return "Se ha elimado correctamente a " + estadio;
		}
		
		return null;
	}
    
    //
    public Estadio addPartido(Integer id, Integer partidoId) {
		
		Optional<Estadio> estadioOpt =  estadioRepository.findById(id);
		
		if (estadioOpt.isPresent()) {
			
			Estadio estadio = estadioOpt.get();

			Optional<Partido> partidoOpt = partidoRepository.findById(partidoId);
			
			if (partidoOpt.isPresent()) {
				
				estadio.addPartido(partidoOpt.get());
				
			}

			return estadioRepository.save(estadio);
		}
		
		return null;
	}
	
}
