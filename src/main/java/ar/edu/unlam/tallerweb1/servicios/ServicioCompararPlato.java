package ar.edu.unlam.tallerweb1.servicios;

 import java.util.ArrayList; 
import java.util.HashMap;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.CompararPlato;
import ar.edu.unlam.tallerweb1.modelo.Plato;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioCompararPlato {

	void agregarPlatos(List<Integer> platos, Integer idUsuario);

	List<CompararPlato> damePlatos(Long idUsuario);

	void quitarPlato(Long id_comparar);

 
 
 	
	
}
