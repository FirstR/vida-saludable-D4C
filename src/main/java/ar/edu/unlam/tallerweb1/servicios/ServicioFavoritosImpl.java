package ar.edu.unlam.tallerweb1.servicios;
import ar.edu.unlam.tallerweb1.modelo.Favoritos;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFavoritos;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioFavoritos")
@Transactional
public class ServicioFavoritosImpl implements ServicioFavoritos {

    private RepositorioPlato repositorioPlato;
    private RepositorioFavoritos repositorioFavoritos;

    @Autowired
    public ServicioFavoritosImpl(RepositorioPlato repositorioPlato, RepositorioFavoritos repositorioFavoritos) {
        this.repositorioPlato = repositorioPlato;
        this.repositorioFavoritos = repositorioFavoritos;

    }

    @Override
    public void agregar(Long idUsuario, Long idPlato) {

        Plato plato = repositorioPlato.damePlatoPorId(idPlato);

        Favoritos fav = new Favoritos(idUsuario,plato);

        repositorioFavoritos.guardar(fav);

    }

    @Override
    public List<Favoritos> mostrar(Long idUsuario) {

        return repositorioFavoritos.devolverFavoritos(idUsuario);
    }
}
