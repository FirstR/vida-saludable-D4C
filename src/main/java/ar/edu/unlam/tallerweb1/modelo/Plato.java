package ar.edu.unlam.tallerweb1.modelo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

 

@Entity
@Table(name = "platos")

public class Plato {

	// La anotacion id indica que este atributo es el utilizado como clave primaria de la entity, se indica que el valor es autogenerado.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_plato;
	private String nombre; 
	private Integer calorias; 
	private String descripcion; 
	private String dificultad; 

	private String grasastrans; 
	private String grasassaturadas; 
	private String carbohidratoscomplejo; 
	private String proteinasmagras; 
	private String grasasinsaturadas; 
	private String fibras; 
	private String carbohidratosrefinado; 
	private String proteinasnomagras; 

	
	
    public String getGrasastrans() {
		return grasastrans;
	}


	public void setGrasastrans(String grasastrans) {
		this.grasastrans = grasastrans;
	}


	public String getGrasassaturadas() {
		return grasassaturadas;
	}


	public void setGrasassaturadas(String grasassaturadas) {
		this.grasassaturadas = grasassaturadas;
	}


	public String getCarbohidratoscomplejo() {
		return carbohidratoscomplejo;
	}


	public void setCarbohidratoscomplejo(String carbohidratoscomplejo) {
		this.carbohidratoscomplejo = carbohidratoscomplejo;
	}


	public String getProteinasmagras() {
		return proteinasmagras;
	}


	public void setProteinasmagras(String proteinasmagras) {
		this.proteinasmagras = proteinasmagras;
	}


	public String getGrasasinsaturadas() {
		return grasasinsaturadas;
	}


	public void setGrasasinsaturadas(String grasasinsaturadas) {
		this.grasasinsaturadas = grasasinsaturadas;
	}


	public String getFibras() {
		return fibras;
	}


	public void setFibras(String fibras) {
		this.fibras = fibras;
	}


	public String getCarbohidratosrefinado() {
		return carbohidratosrefinado;
	}


	public void setCarbohidratosrefinado(String carbohidratosrefinado) {
		this.carbohidratosrefinado = carbohidratosrefinado;
	}


	public String getProteinasnomagras() {
		return proteinasnomagras;
	}


	public void setProteinasnomagras(String proteinasnomagras) {
		this.proteinasnomagras = proteinasnomagras;
	}
	@ManyToMany(mappedBy = "platos")
    private Set<Ingrediente> ingredientes;
    
    
    public Integer getCalorias() {
		return calorias;
	}


	public void setCalorias(Integer  calorias) {
		this.calorias = calorias;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Set<Ingrediente> getIngredientes() {
		return ingredientes;
	}


	public void setIngredientes(Set<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}


	public String getDificultad() {
		return dificultad;
	}


	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}


	public Long getId_plato() {
		return id_plato;
	}


	public void setId_plato(Long id_plato) {
		this.id_plato = id_plato;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Plato(){}
    public Plato(String nombre){
		this.nombre = nombre;

	}
 
}
