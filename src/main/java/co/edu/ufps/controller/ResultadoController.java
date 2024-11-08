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

import co.edu.ufps.entities.Resultado;
import co.edu.ufps.services.ResultadoService;


@RestController
@RequestMapping("/resultado")
public class ResultadoController {
	
	@Autowired
	ResultadoService resultadoService;
	
	@GetMapping
	public List<Resultado> list() {
		return resultadoService.list();
	}
	
//	buscar en el resultado por id (GET-> obtener)
	@GetMapping("/{id}")
	public Resultado getListar1(@PathVariable Integer id) {
		
		return resultadoService.getListar1(id);
	}
	
//	crea un nuevo registro (POST)
	@PostMapping("/crear")
	public Resultado postResultado(@RequestBody Resultado p) {
		return resultadoService.crearResultado(p);
	}
	
	// Modificar (actualizar un Resultado existente)
    @PutMapping("/{id}")
    public Resultado update(@PathVariable Integer id, @RequestBody Resultado updatedResultado) {
        return resultadoService.update(id, updatedResultado);
    }
	
    @DeleteMapping("/{id}")
    public String deleteResultado(@PathVariable Integer id) {
        return resultadoService.deleteResultado(id);
    }

}
