package co.edu.ufps.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import co.edu.ufps.entities.Seleccion;
import co.edu.ufps.services.SeleccionService;


@RestController
@RequestMapping("/selecciones")
public class SeleccionController {
	
	@Autowired
	SeleccionService seleccionService;
	
	@GetMapping
	public ResponseEntity<List<Seleccion>> list() {
		return ResponseEntity.ok(seleccionService.list());
	}
	
//	buscar en el seleccion por id (GET-> obtener)
	@GetMapping("/{id}")
	public ResponseEntity<Seleccion> getListar1(@PathVariable Integer id) {
		
		return ResponseEntity.ok(seleccionService.getListar1(id));
	}
	
//	crea un nuevo registro (POST)
	@PostMapping("/crear")
	public ResponseEntity<Seleccion> postSeleccion(@RequestBody Seleccion p) {
		return ResponseEntity.ok(seleccionService.crearSeleccion(p));
	}
	
	// Modificar (actualizar un Seleccion existente)
    @PutMapping("/{id}")
    public Seleccion update(@PathVariable Integer id, @RequestBody Seleccion updatedSeleccion) {
        return seleccionService.update(id, updatedSeleccion);
    }
	
    @DeleteMapping("/{id}")
    public String deleteSeleccion(@PathVariable Integer id) {
        return seleccionService.deleteSeleccion(id);
    }
    
    @GetMapping("/grupo/{grupo}")
    public List<Seleccion> listarPorGrupo(@PathVariable String grupo) {
        return seleccionService.listarPorGrupo(grupo);
    }
	
    @GetMapping("/{id}/resultados")
    public List<Map<String, Object>> listarResultadosPorSeleccion(@PathVariable Integer id) {
        return seleccionService.listarResultadosPorSeleccion(id);
    }
}