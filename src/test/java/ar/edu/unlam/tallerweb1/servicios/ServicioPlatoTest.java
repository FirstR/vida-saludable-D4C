package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Plato; 
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPlato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


@Controller
public class ServicioPlatoTest {
	
    private ServicioPlato servicioPlato ;  
    private RepositorioPlato repositorioPlato;
    private RepositorioUsuario repositorioUsuario;
    private Integer idUsuario =1;
    
    @Before
    public void init() {
    	repositorioPlato = mock (RepositorioPlato.class);
    	repositorioUsuario = mock (RepositorioUsuario.class);
    	servicioPlato= new ServicioPlatoImpl(repositorioPlato,repositorioUsuario);
    }
 
   @Test(expected = IngredientesVacios.class)
   public void siNoSeleccionoIngredientesLaBusquedaFalla() {
   final ArrayList ingredientes = new ArrayList(); 
   givenBuscoPlatos(ingredientes,idUsuario);  
   }

   

	
	 
	@Test
	public void tengoIngredientesDevuelvoResultados() {
    ArrayList ingredientes = new ArrayList();
    ingredientes.add(1); 
    
	Usuario UsuarioNew = new Usuario((long)1,"Sobrepeso");
	
	when(repositorioUsuario.buscarPorId((long)idUsuario)).thenReturn(UsuarioNew);

    givenBuscoPlatos(ingredientes,idUsuario);
	thenUtiliceElRepositoio(ingredientes,idUsuario);
	}

	private void thenUtiliceElRepositoio(ArrayList ingredientes,Integer idUsuario) { 
		//al tener ingredientes verifico que logre ejecutar la funcion damePlatosPorIngredientes
		verify(repositorioPlato,times(1)).damePlatosPorIngredientes(ingredientes,"ASC");
	}
	  
	  private void givenBuscoPlatos(ArrayList ingredientes,Integer idUsuario) {
		  //no va a encontrar platos por que el ingrediente esta vacio, entonces va a pasar por la expected
	  servicioPlato.buscarPlatoPorIngredientes(ingredientes,idUsuario);
	  }
		  


}
