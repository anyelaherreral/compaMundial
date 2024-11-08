package co.edu.ufps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Continente;
import co.edu.ufps.repositories.ContinenteRepository;


@Service
public class ContinenteService {

	@Autowired
	ContinenteRepository continenteRepository;
	
	
	public List<Continente> list() {
		return continenteRepository.findAll();
	}
	
//	buscar en el continente por id (GET-> obtener)

	public Continente getListar1(Integer id) {
		Optional<Continente> continenteOpt =  continenteRepository.findById(id);
		
		if (continenteOpt.isPresent()) {
			return continenteOpt.get();
		}
		
		return null;
		}
	
//	actualizar, crea un nuevo registro (POST)
	
	public Continente crearPersona(Continente p) {
		return continenteRepository.save(p);
	}
	
	// Modificar (actualizar un Continente existente)
    
    public Continente update(Integer id,Continente continenteDetails) {
        return continenteRepository.findById(id)
                .map(continente -> {
                    continente.setNombre(continenteDetails.getNombre());
           
                    return continenteRepository.save(continente);
                }).orElseThrow(() -> new RuntimeException("Continente no encontrado con el id: " + id));
    }
    
    public String deleteContinente(Integer id) {
    	Optional<Continente> continenteOpt =  continenteRepository.findById(id);
		
		if (continenteOpt.isPresent()) {
			
			Continente continente = continenteOpt.get();
			continenteRepository.delete(continente);
			return "Se ha elimado correctamente a " + continente;
		}
		
		return null;
	}
	
}
