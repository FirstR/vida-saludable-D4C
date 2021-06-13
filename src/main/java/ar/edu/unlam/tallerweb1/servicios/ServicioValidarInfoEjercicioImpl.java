package ar.edu.unlam.tallerweb1.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Ejercicio;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioEjercicio;

@Service("ServicioValidarInfoEjercicio")
@Transactional

public class ServicioValidarInfoEjercicioImpl implements ServicioValidarInfoEjercicio {

	
	private RepositorioEjercicio servicioEjercicioDao;
    
    @Autowired
    public ServicioValidarInfoEjercicioImpl(RepositorioEjercicio servicioEjercicioDao) {
    this.servicioEjercicioDao = servicioEjercicioDao;	
    }
	
    @Override
    public Ejercicio consultarEjercicio(Ejercicio ejercicio) {

    	//Usar repositorio para setear valores.
    	//usuario.setDuracion(duracion);
    	//usuario.setDificultad(dificultad);
		//usuario.setEstadoFisico(estadoFisico);
    	
        return new Ejercicio();
    }
    
    @Override
    public void guardarEjercicio(Ejercicio ejercicio) {
    	servicioEjercicioDao.guardarTipoEjercicio(ejercicio);
    	
    }
}