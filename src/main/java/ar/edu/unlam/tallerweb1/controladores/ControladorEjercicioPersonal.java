package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Ejercicio;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioValidarInfoEjercicio;

@Controller
public class ControladorEjercicioPersonal {
	
	private ServicioValidarInfoEjercicio servicio;
	
	@Autowired
    public ControladorEjercicioPersonal (ServicioValidarInfoEjercicio servicio){
        this.servicio = servicio;
    }
	
	@RequestMapping("/infoEjercicio")
    public ModelAndView irAEjercicio() {
		//Vamos directamente a la vista infoEjercicio
        ModelMap modelo = new ModelMap();
        //Usuario datos = new Usuario();
        Ejercicio ejercicio = new Ejercicio();
        modelo.put("ejercicio", ejercicio);
        return new ModelAndView("info-ejercicio", modelo);
    }
	
	
	@RequestMapping(path = "/validateInfo", method = RequestMethod.GET)
	public ModelAndView validarInfoEjercicio(@ModelAttribute("ejercicio")Ejercicio ejercicio) {
		
		ModelMap modelo = new ModelMap();
		
		if(validarNoVacio(ejercicio.getDuracion(), ejercicio.getDificultad()).equals(false)) {
			exerciseEmpy(modelo, "Seleccione alguna opcion");
    	}	
    	
    	if(validarEstadoFisico(ejercicio.getestadoFisico()).equals(false)) {
    		exerciseEmpy(modelo, "Seleccione opcion de su estado");
    	}
    	servicio.guardarEjercicio(ejercicio);
		Usuario usuario = new Usuario(); //TODO como obtener el usuario con el que se logeo.
		//Ejercicio ejercicio = new Ejercicio();//TODO  setear los valores en la base obtenidos de la vista, generar un long autonumerico.	
		
		//TODO Consultar a la base, 
		//Si todo sale bien, vamos a la proxima pagina con la info.
    	modelo.put("usuario", usuario);
		return new ModelAndView("calendarioPersonal", modelo);
	}
	
	private ModelAndView exerciseFailed(ModelMap model, String motive){
        model.put("error", motive);
        return new ModelAndView("redirect:/infoEjercicio", model);
        
    }
	
	private ModelAndView exerciseEmpy(ModelMap model, String motive){
        model.put("mensaje", motive);
        return new ModelAndView("redirect:/infoEjercicio", model);
        
    }
	//ValidarInfoEjercicio
	private Boolean validarEstadoFisico(Integer estadoFisico) {
		
		if(estadoFisico>0 && estadoFisico<6) {
			return true;
		}
		return false;
	}
	//ValidarInfoEjercicio
	private Boolean validarNoVacio(String duracion, String dificultad) {
		
		if(duracion == null || duracion.isEmpty()) {
			if(dificultad == null || dificultad.isEmpty()) {
				return true;
			}
		}
			
		return false;
	}

}
