package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.CompararPlato;
import ar.edu.unlam.tallerweb1.modelo.Plato; 

import java.util.List;

 public interface RepositorioCompararPlato {

	void guardar(Plato plato, Integer idUsuario);

	List<CompararPlato> damePlatos(Long idUsuario);

	void quitarPlato(Long idPlato);

	Plato buscarPorId(Integer idPlato);
	  
 
 	
 }
