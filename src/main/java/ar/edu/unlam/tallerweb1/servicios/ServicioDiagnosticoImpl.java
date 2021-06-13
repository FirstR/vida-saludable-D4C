package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;    
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioDiagnostico;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlato;
import ar.edu.unlam.tallerweb1.modelo.Diagnostico;
import ar.edu.unlam.tallerweb1.modelo.Evaluacion;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
 
@Service("servicioDiagnostico")
@Transactional
public class ServicioDiagnosticoImpl implements ServicioDiagnostico {
 
	 Integer respuestas_a= 0;
	 Integer respuestas_b= 0;
	 Integer respuestas_c= 0;
    String respuestasGanadoras = "a,b,c";

    private RepositorioDiagnostico repositorioDiagnostico;
    
    
    @Autowired
	public ServicioDiagnosticoImpl(RepositorioDiagnostico repositorioDiagnostico) {
	    this.repositorioDiagnostico = repositorioDiagnostico;	
	}


	@Override
	public Diagnostico buscarDiagnostico(String pregunta1, String pregunta2, String pregunta3, String pregunta4,
			String pregunta5, String pregunta6, String pregunta7, String pregunta8, String pregunta9, String pregunta10,
			String pregunta11, String pregunta12) {
	  	

		 
		ArrayList<String> arrayRespuestas = validarRespuestasCompletas(pregunta1, pregunta2, pregunta3, pregunta4,pregunta5, pregunta6, pregunta7, pregunta8, pregunta9, pregunta10,pregunta11, pregunta12);
		Integer respuestas_a = dameCantidad(arrayRespuestas,"a");
		Integer respuestas_b = dameCantidad(arrayRespuestas,"b");
		Integer respuestas_c = dameCantidad(arrayRespuestas,"c");
		
		
    	if (respuestas_a.equals(respuestas_b)) {
       	     respuestasGanadoras ="a,b";    		
       	}
       	
       	if (respuestas_a.equals(respuestas_c)) {
      	     respuestasGanadoras ="a,c";    		
        }
       	
       	if (respuestas_b.equals(respuestas_c)) {
      	     respuestasGanadoras ="b,c";     
        }
          	
    	if(respuestas_a>respuestas_b  && respuestas_a>respuestas_c  ) {
      	     respuestasGanadoras ="a";    		
    	}
    	
    	if(respuestas_b>respuestas_a && respuestas_b>respuestas_c  ) {
     	     respuestasGanadoras ="b";    		
    	}
    	
    	if(respuestas_c>respuestas_a && respuestas_c>respuestas_b ) {
     	     respuestasGanadoras ="c";    		
    	}
    	
      
    	
    	return repositorioDiagnostico.buscarDiagnostico(respuestasGanadoras);
	}





	private Integer dameCantidad(ArrayList<String> arrayRespuestas, String respuesta) {
		Integer cantidad=0;
		for(int i = 0; i < arrayRespuestas.size(); i++) { 	
		  String e = arrayRespuestas.get(i);
	     	if (e.equals(respuesta)) {
	     		cantidad++;
	    		}  
	    	  }
		
	return cantidad;
	}


	private ArrayList<String> validarRespuestasCompletas(String pregunta1, String pregunta2, String pregunta3, String pregunta4,
			String pregunta5, String pregunta6, String pregunta7, String pregunta8, String pregunta9, String pregunta10,
			String pregunta11, String pregunta12) {
 
		ArrayList<String> respuesta = new ArrayList();
    	respuesta.add(pregunta1); 
    	respuesta.add(pregunta2); 
    	respuesta.add(pregunta3); 
    	respuesta.add(pregunta4); 
    	respuesta.add(pregunta5); 
    	respuesta.add(pregunta6); 
    	respuesta.add(pregunta7); 
    	respuesta.add(pregunta8); 
    	respuesta.add(pregunta9); 
    	respuesta.add(pregunta10); 
    	respuesta.add(pregunta11); 
    	respuesta.add(pregunta12);  
    	
   
    	 Integer respuestas_a= 0;
    	 Integer respuestas_b= 0;
    	 Integer respuestas_c= 0;
    	
    	for(int i = 0; i < respuesta.size(); i++) {
          	if(respuesta.get(i)==null){
    			throw new FaltanRespuestas(); 
        	}
          	
    	}	
          	return respuesta;
 
		
	}

	
     
    
 
  
} 
 