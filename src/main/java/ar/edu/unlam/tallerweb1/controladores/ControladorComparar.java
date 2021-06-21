package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioPlato;
import ar.edu.unlam.tallerweb1.servicios.UsuarioInvalido;
import ar.edu.unlam.tallerweb1.servicios.ServicioCompararPlato;   
import ar.edu.unlam.tallerweb1.servicios.IngredientesVacios;
import ar.edu.unlam.tallerweb1.servicios.PlatoVacio;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.modelo.CompararPlato;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Plato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ControladorComparar{

	private ServicioPlato servicioPlato;
	private ServicioCompararPlato servicioCompararPlato;
    private ModelAndView mav; 
    
	@Autowired
	public ControladorComparar(ServicioPlato servicioPlato,ServicioCompararPlato servicioCompararPlato) {
		this.servicioPlato = servicioPlato;
		this.servicioCompararPlato = servicioCompararPlato;
	}
 
	
	
    @RequestMapping(value = {"comparar-platos/{idUsuario}" }  , method = RequestMethod.GET)
	public ModelAndView buscoPlato(@PathVariable Integer idUsuario) {
        ModelMap model = new ModelMap();
       	try {

       	 if (idUsuario!=0) { 
	 		List<Plato>	platos = servicioPlato.damePlatos();
			List<CompararPlato>	platosAgregados = servicioCompararPlato.damePlatos((long)idUsuario); 
			model.put("platosAgregados", platosAgregados);
	 		model.put("platos", platos);
       	 } else {
       		throw new UsuarioInvalido();
       	 }   
     	   
       	   
       	}catch(UsuarioInvalido e){
			 return new ModelAndView("redirect:/login");
       	}catch(PlatoVacio e){
            model.put("msj","No contamos con platos para comparar.");         
       	}
       	
		return new ModelAndView("comparar-platos",model); 

	 
    }
    
    @RequestMapping(path = "buscar-platos/{idUsuario}" , method = RequestMethod.GET)
	public ModelAndView buscoPlatoPorNombre(@RequestParam("nombre") String nombre,@PathVariable Integer idUsuario) {
        ModelMap model = new ModelMap();
      	try {
		List<Plato>	platos = servicioPlato.buscarPlato(nombre);
		
		List<CompararPlato>	platosAgregados = servicioCompararPlato.damePlatos((long)idUsuario);
		
			 model.put("platosAgregados", platosAgregados);
			 model.put("platos", platos);
      	}catch(PlatoVacio e){
            model.put("msj","No contamos con platos para comparar.");         
       	}
			 return new ModelAndView("comparar-platos",model); 
	 
    }
    
    
	
    @RequestMapping(path = "agregar-a-la-comparacion/{idUsuario}" , method = RequestMethod.GET)
	public ModelAndView agregarAlaComparacion(@RequestParam("platos[]") Optional <List<Integer>> platos,@PathVariable Integer idUsuario) {
		ModelMap model = new ModelMap();
		
		if(platos.isPresent()) {
             servicioCompararPlato.agregarPlatos(platos.get(),idUsuario); 
			 model.put("msj", "Platos Agregados Correctamente");
    		  }else { 
            model.put("msj","Debe Seleccionar un plato para comparar.");         
    		}
	 
		 return new ModelAndView("comparar-platos",model);

	 
 }
  
    
    
    @RequestMapping(path = "ver-resultado-comparacion/{idUsuario}" , method = RequestMethod.GET)
	public ModelAndView resultadoComparacion(@PathVariable Integer idUsuario) {
	 try {
	   	 	if (idUsuario!=0) {  
	   		 List<CompararPlato>	resultadoBusqueda = servicioCompararPlato.damePlatos((long)idUsuario);
	   		 ModelMap model = new ModelMap();  
			 model.put("platos", resultadoBusqueda);
  			 return new ModelAndView("resultado-comparacion",model);
	   	 	} else {
       		throw new UsuarioInvalido();
	   	 	}  
 
	 }catch(UsuarioInvalido e){
		 return new ModelAndView("redirect:/login");
     }
 
	 
	 
	
	 
 }
    
      
 
  
      
    @RequestMapping(path = "quitar-plato/{idPlatoQuitar}" , method = RequestMethod.GET)
    public ModelAndView quitarPlato(@PathVariable Long idPlatoQuitar){
    	
 		 servicioCompararPlato.quitarPlato(idPlatoQuitar);
		 ModelMap model = new ModelMap(); 
  			 model.put("msj", "Plato Quitado Correctamente");
 			 return new ModelAndView("comparar-platos",model);
 
	  
    }
      
      
      

 
}
