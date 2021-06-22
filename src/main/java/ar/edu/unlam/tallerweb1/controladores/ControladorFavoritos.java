package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.CompararPlato;
import ar.edu.unlam.tallerweb1.modelo.DatosIMC;
import ar.edu.unlam.tallerweb1.modelo.Favoritos;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.servicios.AlturaInvalida;
import ar.edu.unlam.tallerweb1.servicios.PesoInvalido;
import ar.edu.unlam.tallerweb1.servicios.SeNecesitaLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioFavoritosImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorFavoritos {

    private ServicioFavoritosImpl servicio;

    @Autowired
    public ControladorFavoritos (ServicioFavoritosImpl servicio){
        this.servicio = servicio;
    }

    @RequestMapping(path = "selecciona-plato/{idUsuario}/{idPlato}", method = RequestMethod.POST)
    public ModelAndView agregar(@PathVariable Long idUsuario, @PathVariable Long idPlato) {

        ModelMap model = new ModelMap();
        try {
            servicio.agregar(idUsuario, idPlato);
        } catch (SeNecesitaLogin e){
            return agregarFallido(model,"Necesita loguearse para agregar favoritos");
        }
        return agregarValido(model, "Se agregó a favoritos");
    }

    private ModelAndView agregarFallido(ModelMap model, String motivo){
        model.put("agregar", false);
        model.put("fallo", motivo);
        return new ModelAndView("redirect:/selecciona-plato", model);
    }

    private ModelAndView agregarValido(ModelMap model, String exito){
        model.put("agregar", true);
        return new ModelAndView("redirect:/selecciona-plato",model);
    }

    @RequestMapping(path = "mostrar-favoritos/{idUsuario}" , method = RequestMethod.GET)
    public ModelAndView muestroFavoritos(@PathVariable Long idUsuario) {
        ModelMap model = new ModelMap();
        List<Favoritos>	favsAgregados = servicio.mostrar(idUsuario);

        model.put("favAgregados", favsAgregados);
        return new ModelAndView("mostrarfav",model);

    }
}
