package co.edu.ufps.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Resultado;
import co.edu.ufps.entities.Seleccion;
import co.edu.ufps.repositories.ResultadoRepository;
import co.edu.ufps.repositories.SeleccionRepository;


@Service
public class SeleccionService {

	@Autowired
	SeleccionRepository seleccionRepository;
	
	@Autowired
    ResultadoRepository resultadoRepository;
	
	
	public List<Seleccion> list() {
		return seleccionRepository.findAll();
	}
	
//	buscar en el seleccion por id (GET-> obtener)

	public Seleccion getListar1(Integer id) {
		Optional<Seleccion> seleccionOpt =  seleccionRepository.findById(id);
		
		if (seleccionOpt.isPresent()) {
			return seleccionOpt.get();
		}
		
		return null;
	}
	
//	actualizar, crea un nuevo registro (POST)
	
	public Seleccion crearSeleccion(Seleccion p) {
		return seleccionRepository.save(p);
	}
	
	// Modificar (actualizar un Seleccion existente)
    
    public Seleccion update(Integer id,Seleccion seleccionDetails) {
		Optional<Seleccion> SelecionOpt = seleccionRepository.findById(id);

		if (!SelecionOpt.isPresent()) {
			return null;
		}

		Seleccion seleccion = SelecionOpt.get();
		seleccion.setNombre(seleccionDetails.getNombre());
		seleccion.setGrupo(seleccionDetails.getGrupo());

		return seleccionRepository.save(seleccion);
	}
    
    public String deleteSeleccion(Integer id) {
    	Optional<Seleccion> seleccionOpt =  seleccionRepository.findById(id);
		
		if (seleccionOpt.isPresent()) {
			
			Seleccion seleccion = seleccionOpt.get();
			seleccionRepository.delete(seleccion);
			return "Se ha elimado correctamente a " + seleccion;
		}
		
		return null;
	}
    
    public List<Seleccion> listarPorGrupo(String grupo) {
        return seleccionRepository.findByGrupo(grupo);
    }
    
    public List<Map<String, Object>> listarResultadosPorSeleccion(Integer seleccionId) {
        List<Resultado> resultados = resultadoRepository.findBySeleccionId(seleccionId);
        List<Map<String, Object>> response = new ArrayList<>();
        
        for (Resultado resultado : resultados) {
            Map<String, Object> resultadoMap = new HashMap<>();
            resultadoMap.put("nombre", resultado.getSeleccion().getNombre());
            resultadoMap.put("goles", resultado.getGoles());
            resultadoMap.put("amarillas", resultado.getAmarillas());
            resultadoMap.put("rojas", resultado.getRojas());
            response.add(resultadoMap);
        }

        return response;
    }
}