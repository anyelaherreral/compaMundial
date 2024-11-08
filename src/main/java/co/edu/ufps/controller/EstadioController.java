package co.edu.ufps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.entities.Estadio;
import co.edu.ufps.entities.Partido;
import co.edu.ufps.services.EstadioService;



@RestController
@RequestMapping("/estadio")
public class EstadioController {
	
	@Autowired
	EstadioService estadioService;
	
	@GetMapping
	public List<Estadio> list() {
		return estadioService.list();
	}
	
//	buscar en el estadio por id (GET-> obtener)
	@GetMapping("/{id}")
	public Estadio getListar1(@PathVariable Integer id) {
		
		return estadioService.getListar1(id);
	}
	
//	crea un nuevo registro (POST)
	@PostMapping("/crear")
	public Estadio postEstadio(@RequestBody Estadio p) {
		return estadioService.crearPersona(p);
	}
	
	// Modificar (actualizar un Estadio existente)
    @PutMapping("/{id}")
    public Estadio update(@PathVariable Integer id, @RequestBody Estadio updatedEstadio) {
        return estadioService.update(id, updatedEstadio);
    }
	
    @DeleteMapping("/{id}")
    public String deleteEstadio(@PathVariable Integer id) {
        return estadioService.deleteEstadio(id);
    }
    
    @PostMapping("/{id}/add_partidos/{partidoId}")
	public Estadio addPartido(@PathVariable Integer id, @PathVariable Integer partidoId) {
		
		Estadio nuevaEstadio = estadioService.addPartido(id, partidoId);
		return nuevaEstadio;
	}
    
    @GetMapping("/{id}/partidos")
	public List<Partido> getPartidos(@PathVariable Integer id) {
		return estadioService.getListar1(id).getPartidos();
				
	}

}
