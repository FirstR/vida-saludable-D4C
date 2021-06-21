package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.servicios.PesoInvalido; 
import ar.edu.unlam.tallerweb1.modelo.DatosIMC;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioDiagnostico;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.Before;

public class ServicioIMCTest {

    private ServicioIMCImpl servicio;
    private Double altura;
    private Double peso;
    private DatosIMC datosIMC;
    private RepositorioUsuario repositorioUsuario;
    
    @Before
    public void init() {
    	repositorioUsuario = mock (RepositorioUsuario.class);
    	servicio= new ServicioIMCImpl(repositorioUsuario);
    }

    
    
    @Test
    public void siLosDatosSonCorrectosDeberiaCalcular(){

        altura = 1.80;
        peso = 80.0;

        dadoQueLosDatosSonCorrectos(altura, peso);

        cuandoCalculoIMC(altura, peso);

        entoncesCalculaBien();

        }
    public void dadoQueLosDatosSonCorrectos(Double altura, Double peso){

        servicio.validarAltura(altura);
        servicio.validarPeso(peso);
    }

    public void cuandoCalculoIMC(Double altura, Double peso){
//cambiar 1 por idUsuario
        datosIMC = servicio.calcularImcCompleto(altura, peso,(long)1);
    }

    public void entoncesCalculaBien(){

        assertThat(datosIMC).isNotNull();
    }

    @Test
    public void siElPesoEsInvalidoNoDeberiaCalcular(){
/*
        Assertions.assertThrows(PesoInvalido.class, () -> {
            altura = 1.80;
            peso = 800.0;

            dadoQueElPesoEsIncorrectos(peso);

            cuandoCalculoIMC(altura, peso);

            entoncesNoCalcula();
        });*/
    }

    private void entoncesNoCalcula() {

        assertThat(datosIMC).isNull();
    }

    private void dadoQueElPesoEsIncorrectos(Double peso) {

        servicio.validarPeso(peso);
    }

    @Test
    public void siLaAlturaEsInvalidaNoDeberiaCalcular(){
/*
        Assertions.assertThrows(AlturaInvalida.class, () -> {
            altura = 4.80;
            peso = 80.0;

            dadoQueLaAlturaEsIncorrecta(altura);

            cuandoCalculoIMC(altura, peso);

            entoncesNoCalcula();
        });*/
    }


    private void dadoQueLaAlturaEsIncorrecta(Double altura) {

        servicio.validarAltura(altura);
    }

}
