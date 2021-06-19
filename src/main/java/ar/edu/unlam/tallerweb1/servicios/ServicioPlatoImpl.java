package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlato;
import ar.edu.unlam.tallerweb1.modelo.Plato;

@Service("servicioPlato")
@Transactional
public class ServicioPlatoImpl implements ServicioPlato {

 
    private RepositorioPlato repositorioPlato;
    
    @Autowired
    public ServicioPlatoImpl(RepositorioPlato repositorioPlato) {
    this.repositorioPlato = repositorioPlato;	
    }

	@Override
	public List<Plato> buscarPlato(String nombre) {
 		return repositorioPlato.buscarPlatoPorNombre(nombre);

	}

	@Override
	public List<Plato> damePlatos() {
		List<Plato> listadoPlatos=	repositorioPlato.damePlatos();
		 
		if(listadoPlatos.size()==0) {
			throw new PlatoVacio();
		}
		
 		return listadoPlatos;
 		 
	}

	@Override
	public List<Plato> buscarPlatoPorIngredientes(List<Integer> ingredientes) {
		
		if(ingredientes.size()==0) {
			throw new IngredientesVacios();
		}
 		return repositorioPlato.damePlatosPorIngredientes(ingredientes);
 		
	}

	@Override
	public Plato buscarPorId(Integer id_plato) { 
		if(id_plato==null) {
			throw new PlatoVacio();
		} 
		
 		return repositorioPlato.damePlatoPorId((long) id_plato);

	}
    
    
 

 
} 
 