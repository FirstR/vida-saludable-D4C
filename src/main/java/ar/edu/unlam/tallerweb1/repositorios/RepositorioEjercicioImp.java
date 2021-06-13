package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Ejercicio;

@Repository("RepositorioEjercicio")
public class RepositorioEjercicioImp implements RepositorioEjercicio{
	
	
		//  hibernateContext.xml
		private SessionFactory sessionFactory;

	    @Autowired
		public RepositorioEjercicioImp(SessionFactory sessionFactory){
			this.sessionFactory = sessionFactory; 
		}
	    
	    @Override
		public Ejercicio devolverTipoEjercicio(Long id) {
	        final Session session = this.sessionFactory.getCurrentSession();
	        return (Ejercicio) session.createCriteria(Ejercicio.class)
	                 .list();
		}
	    
	    @Override
		public  void guardarTipoEjercicio(Ejercicio ejercicio) {
	    	sessionFactory.getCurrentSession().save(ejercicio);
		}

		@Override
		public List<Ejercicio> EjercicioPorDefault() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Ejercicio> EjercicioConFiltros() {
			// TODO Auto-generated method stub
			return null;
		}
	    
	    

}
