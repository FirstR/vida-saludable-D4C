package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ejercicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String duracion;
	private String dificultad;
	private Integer estadoFisico;
	
	 public Ejercicio (String duracion, String dificultad, Integer estadoFisico){

	        this.duracion = duracion;
	        this.dificultad = dificultad;
	        this.estadoFisico = estadoFisico;
	    }
	 
	public Ejercicio() {
	}
	
	public Long getid() {
		return id;
	}
	public void setid(Long id) {
		this.id = id;
	}

	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public String getDificultad() {
		return dificultad;
	}
	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	public Integer getestadoFisico() {
		return estadoFisico;
	}
	public void setestadoFisico(Integer estadoFisico) {
		this.estadoFisico = estadoFisico;
	}
	
	
}
