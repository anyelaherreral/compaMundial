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

import co.edu.ufps.entities.Partido;
import co.edu.ufps.services.PartidoService;


@RestController
@RequestMapping("/partido")
public class PartidoController {
	
	@Autowired
	PartidoService partidoService;
	
	@GetMapping
	public List<Partido> list() {
		return partidoService.list();
	}
	
//	buscar en el partido por id (GET-> obtener)
	@GetMapping("/{id}")
	public Partido getListar1(@PathVariable Integer id) {
		
		return partidoService.getListar1(id);
	}
	
//	crea un nuevo registro (POST)
	@PostMapping("/crear")
	public Partido postPartido(@RequestBody Partido p) {
		return partidoService.crearPartido(p);
	}
	
	// Modificar (actualizar un Partido existente)
    @PutMapping("/{id}")
    public Partido update(@PathVariable Integer id, @RequestBody Partido updatedPartido) {
        return partidoService.update(id, updatedPartido);
    }
	
    @DeleteMapping("/{id}")
    public String deletePartido(@PathVariable Integer id) {
        return partidoService.deletePartido(id);
    }

}
