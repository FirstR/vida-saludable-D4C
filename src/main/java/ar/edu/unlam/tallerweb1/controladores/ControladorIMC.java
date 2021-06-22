package ar.edu.unlam.tallerweb1.controladores;
import ar.edu.unlam.tallerweb1.modelo.CompararPlato;
import ar.edu.unlam.tallerweb1.modelo.DatosIMC;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.servicios.AlturaInvalida;
import ar.edu.unlam.tallerweb1.servicios.PesoInvalido;
import ar.edu.unlam.tallerweb1.servicios.PlatoVacio;
import ar.edu.unlam.tallerweb1.servicios.ServicioCalcularIMC;
import ar.edu.unlam.tallerweb1.servicios.UsuarioInvalido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorIMC {

    private ServicioCalcularIMC servicio;

    @Autowired
    public ControladorIMC (ServicioCalcularIMC servicio){
        this.servicio = servicio;
    }

    
     
   	
    @RequestMapping("calcular/{idUsuario}")
    public ModelAndView irACalcularIMC(@PathVariable Integer idUsuario) {

    	 if (idUsuario!=0 ) { 
        ModelMap modelo = new ModelMap();
        DatosIMC datos = new DatosIMC();
        modelo.put("datosIMC", datos);
        return new ModelAndView("calcularIMC", modelo);
    	 }else {
        return new ModelAndView("redirect:/login");

    	 }
    }

    @RequestMapping(path = "calcularImcCompleto/{idUsuario}", method = RequestMethod.POST)
    public ModelAndView calcularImcCompleto(@PathVariable Integer idUsuario,@ModelAttribute("datosIMC") DatosIMC datos) {

        DatosIMC datos1;
        ModelMap model = new ModelMap();

        try {
    		  
            datos1 = servicio.calcularImcCompleto(datos.getAltura(), datos.getPeso(),(long) idUsuario);
        } catch (AlturaInvalida e){
            return IMCFallido(model,"Altura inválida");
        } catch (PesoInvalido e){
            return IMCFallido(model, "Peso inválido");
        }
        return IMCValido(model, datos1);
    }

    private ModelAndView IMCFallido(ModelMap model, String motivo){
        model.put("IMC", false);
        model.put("error", motivo);
        return new ModelAndView("calcularIMC", model);
    }

    private ModelAndView IMCValido(ModelMap model, DatosIMC datos){
        model.put("IMC", true);
        model.put("IMCCalculado", datos.getIMC());
        model.put("compCorporalCalculada", datos.getCompCorporal());
        model.put("mensajeIMC", "Tu indice de masa corporal es: ");
        model.put("mensajeComp", "Por lo tanto, tu composicion corporal es: ");
        
		 model.put("msj","IMCCalculado ."+datos.getIMC()+ ". Por lo tanto, tu composicion corporal es: " + datos.getCompCorporal()+"\n"  );
		 return new ModelAndView("redirect:/index",model);
    }

}