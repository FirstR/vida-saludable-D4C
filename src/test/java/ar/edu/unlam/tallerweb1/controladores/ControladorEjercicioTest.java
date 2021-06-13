package ar.edu.unlam.tallerweb1.controladores;

import org.junit.Test;
import org.springframework.stereotype.Controller;

import ar.edu.unlam.tallerweb1.modelo.Ejercicio;

@Controller
public class ControladorEjercicioTest {
	private final Ejercicio MiEjercicio = new Ejercicio("extensa","moderado",2); //2 he echo un poco de actividad antes.
	private ControladorEjercicioPersonal ControladorEP = new ControladorEjercicioPersonal(null);
	
	@Test
	public void validarInfoEjercicio() {
		//Setear
		elEjercicioEnviadoExiste(MiEjercicio);
		//Correrlo
		
	}
	
	
	
	private void elEjercicioEnviadoExiste(Ejercicio ejercicio) {
		System.out.print("este es el ejercicio: "+ejercicio);
	}
}
