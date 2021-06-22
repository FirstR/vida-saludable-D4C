package ar.edu.unlam.tallerweb1.servicios;  
 

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("servicioPlato")
@Transactional
public class ServicioPlatoImpl implements ServicioPlato {

 
    private RepositorioPlato repositorioPlato;
    private RepositorioUsuario repositorioUsuario;
    
    @Autowired
    public ServicioPlatoImpl(RepositorioPlato repositorioPlato,RepositorioUsuario repositorioUsuario) {
        this.repositorioPlato = repositorioPlato;	
        this.repositorioUsuario = repositorioUsuario;	
    }

	@Override
	public List<Plato> buscarPlato(String nombre) {
 		List<Plato> listadoPlatos=	 repositorioPlato.buscarPlatoPorNombre(nombre);

		if(listadoPlatos.size()==0) {
			throw new PlatoVacio();
		}
		
 		return listadoPlatos;
 		

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
	public List<Plato> buscarPlatoPorIngredientes(List<Integer> ingredientes,Integer idUsuario) {
		String estadoIMCusuario = "";
		String ordenar = "DESC";
		
		if(ingredientes.size()==0) {
			throw new IngredientesVacios();
		}
		
		Usuario usuario = repositorioUsuario.buscarPorId((long)idUsuario);
		estadoIMCusuario = usuario.getCompCorporal();
		if(estadoIMCusuario.equals("Sobrepeso") || estadoIMCusuario.equals("Obeso")) {
 			//ordeno calorias de menor a mayor
			 ordenar = "ASC";
 
		} 
		
 		
		
	 	return repositorioPlato.damePlatosPorIngredientes(ingredientes,ordenar);

 		
	}

	@Override
	public Plato buscarPorId(Integer id_plato) { 
		if(id_plato==null) {
			throw new PlatoVacio();
		} 
		
 		return repositorioPlato.damePlatoPorId((long) id_plato);

	}
    
    
	@Override
	public List<Plato> buscarPorCalorias(Integer calorias) {
 		List<Plato> listadoPlatos=	 repositorioPlato.buscarPlatoPorCalorias(calorias);

		if(listadoPlatos.size()==0) {
			throw new PlatoVacio();
		}
		
 		return listadoPlatos;
 		

	}

 
} 
 