package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Ejercicio;

public  interface RepositorioEjercicio {
		 
		Ejercicio devolverTipoEjercicio(Long id);
		
		void guardarTipoEjercicio(Ejercicio ejercicio);

		List<Ejercicio> EjercicioPorDefault();

		List<Ejercicio> EjercicioConFiltros();
	 	
}
