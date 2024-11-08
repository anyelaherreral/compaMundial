package co.edu.ufps.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ufps.entities.Seleccion;


public interface SeleccionRepository extends JpaRepository<Seleccion,Integer>{

	List<Seleccion> findByGrupo(String grupo);
}
