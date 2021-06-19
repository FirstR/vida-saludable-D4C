package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.DatosIMC;

public interface ServicioCalcularIMC {

    DatosIMC calcularImcCompleto(Double altura, Double peso,Long idUsuario);
    Boolean validarAltura(Double altura);
    Boolean validarPeso(Double peso);
}
