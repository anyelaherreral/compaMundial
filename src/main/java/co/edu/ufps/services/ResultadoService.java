package co.edu.ufps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Resultado;
import co.edu.ufps.repositories.ResultadoRepository;


@Service
public class ResultadoService {

	@Autowired
	ResultadoRepository resultadoRepository;
	
	
	public List<Resultado> list() {
		return resultadoRepository.findAll();
	}
	
//	buscar en el resultado por id (GET-> obtener)

	public Resultado getListar1(Integer id) {
		Optional<Resultado> resultadoOpt =  resultadoRepository.findById(id);
		
		if (resultadoOpt.isPresent()) {
			return resultadoOpt.get();
		}
		
		return null;
		}
	
//	actualizar, crea un nuevo registro (POST)
	
	public Resultado crearResultado(Resultado p) {
		return resultadoRepository.save(p);
	}
	
	// Modificar (actualizar un Resultado existente)
    
    public Resultado update(Integer id,Resultado resultadoDetails) {
        return resultadoRepository.findById(id)
                .map(resultado -> {
                    resultado.setGoles(resultadoDetails.getGoles());
                    resultado.setAmarillas(resultadoDetails.getAmarillas());
                    resultado.setRojas(resultadoDetails.getRojas());
                    
                    return resultadoRepository.save(resultado);
                }).orElseThrow(() -> new RuntimeException("Resultado no encontrado con el id: " + id));
    }
    
    public String deleteResultado(Integer id) {
    	Optional<Resultado> resultadoOpt =  resultadoRepository.findById(id);
		
		if (resultadoOpt.isPresent()) {
			
			Resultado resultado = resultadoOpt.get();
			resultadoRepository.delete(resultado);
			return "Se ha elimado correctamente a " + resultado;
		}
		
		return null;
	}
	
}
