package co.edu.ufps.controller;

import java.util.List;

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

import co.edu.ufps.entities.Continente;
import co.edu.ufps.services.ContinenteService;


@RestController
@RequestMapping("/continente")
public class ContinenteController {
	
	@Autowired
	ContinenteService continenteService;
	
	@GetMapping
	public ResponseEntity<List<Continente>> list() {
		return ResponseEntity.ok(continenteService.list());
	}
	
//	buscar en el continente por id (GET-> obtener)
	@GetMapping("/{id}")
	public ResponseEntity<Continente> getListar1(@PathVariable Integer id) {
		
		return ResponseEntity.ok(continenteService.getListar1(id));
	}
	
//	crea un nuevo registro (POST)
	@PostMapping("/crear")
	public ResponseEntity<Continente> postContinente(@RequestBody Continente p) {
		return ResponseEntity.ok(continenteService.crearPersona(p));
	}
	
	// Modificar (actualizar un Continente existente)
    @PutMapping("/{id}")
    public ResponseEntity<Continente> update(@PathVariable Integer id, @RequestBody Continente updatedContinente) {
    	return ResponseEntity.ok(continenteService.update(id, updatedContinente));
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContinente(@PathVariable Integer id) {
    	
        return ResponseEntity.ok(continenteService.deleteContinente(id));
    }

}
