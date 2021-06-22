package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Favoritos;
import ar.edu.unlam.tallerweb1.modelo.Plato;

import java.util.List;

public interface ServicioFavoritos {

    void agregar(Long idUsuario, Long idPlato);
    List<Favoritos> mostrar(Long idUsuario);
}
