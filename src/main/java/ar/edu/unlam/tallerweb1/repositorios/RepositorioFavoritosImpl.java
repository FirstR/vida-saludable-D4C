package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.CompararPlato;
import ar.edu.unlam.tallerweb1.modelo.Favoritos;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioFavoritos")
public class RepositorioFavoritosImpl implements RepositorioFavoritos{

    private SessionFactory sessionFactory;


    @Autowired
    public RepositorioFavoritosImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Favoritos favoritos) {
        sessionFactory.getCurrentSession().save(favoritos);
    }

    @Override
    public Favoritos buscarPorId(Long id) {
        return sessionFactory.getCurrentSession().get(Favoritos.class, id);
    }

    @Override
    public List<Favoritos> devolverFavoritos(Long idUsuario) {
        final Session session = this.sessionFactory.getCurrentSession();
        return session.createCriteria(Favoritos.class)
                .add( Restrictions.eq("id_usuario", idUsuario ) )
                .list();
    }
}
