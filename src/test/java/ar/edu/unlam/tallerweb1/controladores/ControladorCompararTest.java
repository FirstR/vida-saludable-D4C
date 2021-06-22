package ar.edu.unlam.tallerweb1.controladores;

 
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;    
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Receta;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioIngrediente;
import ar.edu.unlam.tallerweb1.servicios.ServicioReceta;
import ar.edu.unlam.tallerweb1.servicios.IngredientesVacios;
import ar.edu.unlam.tallerweb1.servicios.PlatoVacio;
import ar.edu.unlam.tallerweb1.servicios.ServicioIngrediente;
import ar.edu.unlam.tallerweb1.servicios.ServicioPlato;
import ar.edu.unlam.tallerweb1.servicios.ServicioCompararPlato;

import org.hibernate.SessionFactory;
//import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Rollback;
//import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//import javax.transaction.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

 
@Controller
public class ControladorCompararTest  {
	
	 
    private ControladorComparar controladorComparar;  
    private ControladorReceta controladorReceta;  
    private ModelAndView mav; 
    private ServicioReceta servicioReceta;  
    private ServicioIngrediente servicioIngrediente;  
    private ServicioPlato servicioPlato;  
    
     private ServicioCompararPlato servicioCompararPlato;  
     
   @Before
   public void init() {
	   servicioIngrediente = mock(ServicioIngrediente.class);
	   servicioReceta = mock(ServicioReceta.class);
	   servicioPlato= mock(ServicioPlato.class);
	   controladorReceta = new ControladorReceta(servicioReceta,servicioIngrediente,servicioPlato);
	  
	   servicioCompararPlato = mock(ServicioCompararPlato.class);
	   controladorComparar = new ControladorComparar(servicioPlato,servicioCompararPlato);

   }

     
   @Test
   @Transactional
   public void siNoTengoIdUsuarioNoPuedoComparar(){
   	      	
 		Integer idUsuario= 0;  
    	
   	whenBuscoPlatosParaComparar(idUsuario);
   	thanPuedoBuscar();
   }


   private void thanPuedoBuscar() {
		assertThat(mav.getViewName()).isEqualTo("redirect:/login"); 

		
}

 
 
   
@Test
@Transactional
public void siNoTengoPlatosNoPuedoComparar(){
	      	
 	Integer idUsuario= 1 ; 
 	doThrow(PlatoVacio.class)
 	.when(servicioPlato)
 	.damePlatos();
 	 
	whenBuscoPlatosParaComparar(idUsuario);
	thanObtengoListaVaciaynoPuedoComparar();
}



 
private void thanObtengoListaVaciaynoPuedoComparar() {
		assertThat(mav.getModel().get("msj")).isEqualTo("No contamos con platos para comparar."); 		
	
}


@Test
@Transactional
public void siTengoPlatosYIdUsuarioPuedoComparar(){
	
		List<Plato> listaPlatos= new LinkedList<>();
		Plato plato1=new Plato("Pollo y Lechuga");
		Plato plato2=new Plato("Pollo y Lechuga");
		Integer idUsuario= 1;
		 
		listaPlatos.add(plato1);
		listaPlatos.add(plato2); 
		
	when(servicioPlato.damePlatos()).thenReturn(listaPlatos);

	whenBuscoPlatosParaComparar(idUsuario);
	thanObtengoPlatosParaComparar();
}


private void thanObtengoPlatosParaComparar() {

	assertThat(mav.getModel().get("platos")).isNotNull();
	assertThat(mav.getViewName()).isEqualTo("comparar-platos"); 
	
	
}


private void whenBuscoPlatosParaComparar(Integer idUsuario) {
	mav=controladorComparar.buscoPlato(idUsuario);		

}


 
	


}
