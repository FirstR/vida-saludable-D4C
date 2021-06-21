package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.DatosIMC;
import ar.edu.unlam.tallerweb1.servicios.AlturaInvalida;
import ar.edu.unlam.tallerweb1.servicios.PesoInvalido;
import ar.edu.unlam.tallerweb1.servicios.PlatoVacio;
import ar.edu.unlam.tallerweb1.servicios.ServicioCalcularIMC;
import ar.edu.unlam.tallerweb1.servicios.ServicioCompararPlato;
import ar.edu.unlam.tallerweb1.servicios.ServicioIMCImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioIngrediente;
import ar.edu.unlam.tallerweb1.servicios.ServicioPlato;
import ar.edu.unlam.tallerweb1.servicios.ServicioReceta;

import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Controller
public class ControladorIMCTest {

	

    private ModelAndView mav; 

    private ControladorIMC controladorImc ;
    private Double altura;
    private Double peso;
    private String motivo;
    private ServicioIMCImpl servicioIMC ;
    private ServicioCalcularIMC servicioCalcularIMC ;
    private Integer idUsuario=1;
     
     @Before
     public void init() {
 
     servicioIMC = mock(ServicioIMCImpl.class);
     servicioCalcularIMC = mock(ServicioCalcularIMC.class);
  	 controladorImc = new ControladorIMC(servicioCalcularIMC);

     }

     
     
    @Test
    @Transactional
    @Rollback
    public void siLaAlturaEsInvalidaNoTendriaQuePoderCalcular(){

        altura = 3.80;
        peso = 89.9;
        motivo = "Altura inválida";
        DatosIMC datos = new DatosIMC();
        datos.setAltura(altura);
        datos.setPeso(peso);

        dadoQueLaAlturaEsInvalida(altura); 
        
     	doThrow(AlturaInvalida.class)
     	.when(servicioCalcularIMC)
     	.calcularImcCompleto(altura,peso,(long)idUsuario);
     	 
     	
     	
        cuandoCalculoImc(datos);

        entoncesNoCalculaPorAltura();
    }

    private void entoncesNoCalculaPorAltura() {

        assertThat(mav.getModel().get("IMC")).isEqualTo(Boolean.FALSE);
        assertThat(mav.getViewName()).isEqualTo("calcularIMC");
        assertThat(mav.getModel().get("error")).isEqualTo(motivo);

    }

    private void cuandoCalculoImc(DatosIMC datos) {
         mav = controladorImc.calcularImcCompleto(idUsuario,datos);
    }

    private void dadoQueLaAlturaEsInvalida (Double altura){

        assertThat(servicioIMC.validarAltura(altura)).isEqualTo(Boolean.FALSE);

    }

    @Test
    @Transactional
    @Rollback
    public void siElPesoEsInvalidoNoTendriaQuePoderCalcular(){

        altura = 1.80;
        peso = 1000.0;
        motivo = "Peso inválido";
        DatosIMC datos = new DatosIMC();
        datos.setAltura(altura);
        datos.setPeso(peso);

        dadoQueElPesoEsInvalido(peso);
 
        
     	doThrow(PesoInvalido.class)
     	.when(servicioCalcularIMC)
     	.calcularImcCompleto(altura,peso,(long)idUsuario);
     	 
     	
     	
        cuandoCalculoImc(datos);

        entoncesNoCalculaPorPeso();

    }

    private void entoncesNoCalculaPorPeso() {

        assertThat(mav.getModel().get("IMC")).isEqualTo(Boolean.FALSE);
        assertThat(mav.getViewName()).isEqualTo("calcularIMC");
        assertThat(mav.getModel().get("error")).isEqualTo(motivo);
    }

    private void dadoQueElPesoEsInvalido(Double peso) {

        assertThat(servicioIMC.validarPeso(peso)).isEqualTo(Boolean.FALSE);

    }

    @Test
    @Transactional
    @Rollback
    public void calculoIMCExitoso(){

        altura = 1.80;
        peso = 80.0;
        DatosIMC datos = new DatosIMC();
        datos.setAltura(altura);
        datos.setPeso(peso);

        dadoQueLosDatosSonValidos(altura, peso);
    	when(servicioCalcularIMC.calcularImcCompleto(altura,peso,(long)idUsuario)).thenReturn(datos);

        cuandoCalculoImc(datos);

        entoncesSeCalculaExitosamente();
    }

    private void entoncesSeCalculaExitosamente() {

        assertThat(mav.getModel().get("IMC")).isEqualTo(Boolean.TRUE);
        assertThat(mav.getViewName()).isEqualTo("redirect:/index");

    }

    private void dadoQueLosDatosSonValidos(Double altura, Double peso) {

      //  assertThat(servicioIMC.validarAltura(altura)).isEqualTo(Boolean.TRUE);
      //  assertThat(servicioIMC.validarPeso(peso)).isEqualTo(Boolean.TRUE);

    }
}
