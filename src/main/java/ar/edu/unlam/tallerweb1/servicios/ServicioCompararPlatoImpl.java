package ar.edu.unlam.tallerweb1.servicios;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCompararPlato;
import ar.edu.unlam.tallerweb1.modelo.CompararPlato;
import ar.edu.unlam.tallerweb1.modelo.Plato;

@Service("servicioCompararPlato")
@Transactional
public class ServicioCompararPlatoImpl implements ServicioCompararPlato {

 
    private RepositorioCompararPlato repositorioCompararPlato;
    private RepositorioPlato repositorioPlato;
    
    @Autowired
    public ServicioCompararPlatoImpl(RepositorioCompararPlato repositorioCompararPlato,RepositorioPlato repositorioPlato) {
    this.repositorioCompararPlato = repositorioCompararPlato;	
    this.repositorioPlato = repositorioPlato;	
    }

	@Override
 	public void agregarPlatos(List<Integer> platos, Integer idUsuario) {
			
		Integer cantidadplatos= platos.size();
		if(cantidadplatos==0) {
			throw new PlatoVacio();  
		}
		  for (int i=0;i<cantidadplatos;i++) {
			Integer idPlato=  platos.get(i);
			Plato plato = repositorioPlato.damePlatoPorId((long)idPlato);
			repositorioCompararPlato.guardar(plato,idUsuario);
		  }
		  
		  
	}

	@Override
	public List<CompararPlato> damePlatos(Long idUsuario) {
		// TODO Auto-generated method stub
		return repositorioCompararPlato.damePlatos(idUsuario);
	}

	@Override
	public void quitarPlato(Long id_comparar) {
		repositorioCompararPlato.quitarPlato(id_comparar);		
	}
 
 

 
} 
 