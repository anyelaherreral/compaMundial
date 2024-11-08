package co.edu.ufps.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ufps.entities.Resultado;


public interface ResultadoRepository extends JpaRepository<Resultado,Integer>{
	List<Resultado> findBySeleccionId(Integer seleccionId);
	
}
