package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Favoritos;
import ar.edu.unlam.tallerweb1.modelo.Plato;

import java.util.List;

public interface RepositorioFavoritos {

    void guardar(Favoritos favoritos);
    Favoritos buscarPorId(Long id);
    List<Favoritos> devolverFavoritos(Long idUsuario);

}
