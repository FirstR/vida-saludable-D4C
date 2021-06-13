package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Ejercicio;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioValidarInfoEjercicio {
	
	Ejercicio consultarEjercicio(Ejercicio ejercicio);
	void guardarEjercicio(Ejercicio ejercicio);
}
