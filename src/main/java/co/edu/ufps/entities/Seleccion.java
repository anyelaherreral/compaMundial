package co.edu.ufps.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="seleccion")
public class Seleccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="grupo")
	private String grupo;
	
	@ManyToOne
	@JoinColumn(name="continente_id")
	private Continente continente;
	
	@OneToMany(mappedBy="seleccion",cascade= CascadeType.ALL)
	@JsonIgnore
	private List<Resultado> resultados;
	
}
