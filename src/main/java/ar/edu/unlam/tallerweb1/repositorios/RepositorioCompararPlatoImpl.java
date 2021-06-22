package ar.edu.unlam.tallerweb1.repositorios;

 import ar.edu.unlam.tallerweb1.modelo.CompararPlato; 
import ar.edu.unlam.tallerweb1.modelo.Evaluacion;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Plato;
 
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioCompararPlato")
public class RepositorioCompararPlatoImpl implements RepositorioCompararPlato{

	//  hibernateContext.xml
	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioCompararPlatoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory; 
	}

	@Override
	public void guardar(Plato plato, Integer idUsuario) {

		CompararPlato compararPlato = new CompararPlato();
		compararPlato.setId_usuario((long)idUsuario);
		compararPlato.setPlato(plato);
		sessionFactory.getCurrentSession().save(compararPlato);
		
		
		
	}

	@Override
	public List<CompararPlato> damePlatos(Long idUsuario) {
		
        final Session session = this.sessionFactory.getCurrentSession();
        return session.createCriteria(CompararPlato.class)
               .add( Restrictions.eq("id_usuario", idUsuario ) )
                .list();
        
        
	}

 	@Override
	public void quitarPlato(Long id_comparar) {
 	CompararPlato objetoEliminar = sessionFactory.getCurrentSession().get(CompararPlato.class, id_comparar);
	sessionFactory.getCurrentSession().remove(objetoEliminar);

	}

	@Override
	public Plato buscarPorId(Integer idPlato) {
		return sessionFactory.getCurrentSession().get(Plato.class, idPlato);

	}
 
	
}
