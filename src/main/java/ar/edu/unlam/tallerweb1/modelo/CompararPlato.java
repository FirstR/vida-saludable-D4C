package ar.edu.unlam.tallerweb1.modelo;

import java.util.Set; 

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

 

@Entity
@Table(name = "comparar_platos")

public class CompararPlato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_comparar; 
	
    @ManyToOne
    @JoinColumn(name = "id_plato")
	private Plato plato; 
    
	private Long id_usuario; 
 
	public Plato getPlato() {
		return plato;
	}
	
	public Long getId_comparar() {
		return id_comparar;
	}
	public void setId_comparar(Long id_comparar) {
		this.id_comparar = id_comparar;
	}


	public void setPlato(Plato plato) {
		this.plato = plato;
	}
	
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public CompararPlato(){}
    public CompararPlato(Plato plato,Long id_usuario){
		this.plato =plato;
		this.id_usuario =id_usuario;

	}
 
}
