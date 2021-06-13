<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
 	<head>
    <title>Informacion Ejercicio</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="css/animate.css">

    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">

    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/style.css">
</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
   		 <div class="container">
        <a class="navbar-brand" href="index.html">Vida Saludable <span>Indicacion de tipo de ejercicio</span></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span>
        </button>
        <div class="collapse navbar-collapse" id="ftco-nav">
        </div>
   		 </div>
		</nav>
		      <div class="modal-header">
		        <h3 class="modal-title" id="exampleModalLabel">Seleccione las opciones de acuerdo al tipo de ejercicio que desea seguir</h3>
		      </div>
		      <div class="modal-body">
		        <form:form action="validarInfoEjercicio" method="GET" modelAttribute="ejercicio">
		          <div class="dropdown">
					  <!--<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">-->
					   <span> Seleccione duracion </span>
					   <br>
					  <!--</button>-->
					  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
					   <form:select path="duracion" id="duracion">			<!--Obtener informacion de la base-->    
					        <form:option value="3 meses" label="3 meses"/>  
					        <form:option value="6 meses" label="6 meses"/>  
					        <form:option value="9 meses" label="9 meses"/>  
				        </form:select>
					  </div>
				 </div>
		         <br/><br/>
		         <div class="dropdown">
					 <!--<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">-->
					    Seleccione dificultad
					  <!--</button>-->
					  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
					  	<form:select path="dificultad" id="dificultad">  
					        <form:option value="Novato" label="Novato"/>  
					        <form:option value="Moderado" label="Moderado"/>  
					        <form:option value="Avanzado" label="Avanzado"/>  
				        </form:select> 
					  </div>
				 </div>
				 <br/><br/>
		          <div class="form-group">
		            <label for="altura" class="col-form-label">Cual es su estado fisico actual?</label>
		            <br>
		            	<form:select path="estadoFisico" id="estado">  
					        <form:option value="Excelente estado fisico" label="Excelente estado fisico"/>  
					        <form:option value="Hago actividad fisica casualmente" label="Hago actividad fisica casualmente"/>  
					        <form:option value="No ejercito hace un tiempo" label="No ejercito hace un tiempo"/>
					        <form:option value="Me encuentro en un mal estado fisico" label="Me encuentro en un mal estado fisico"/>
					        <form:option value="Ejercicio? Que es eso? Se come?" label="Ejercicio? Que es eso? Se come?"/>
				        </form:select>
		          </div>		          
		          
		        
		        
		        <c:if test="${not empty mensaje}">
           		 <h4><span>${mensaje}</span></h4>
            		<br>
       			 </c:if>	
		        
		      </div>
		      <div class="modal-footer">
		      <button type="submit" class="btn btn-primary">Guardar</button>
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
		        
		      </div>
		      </form:form>
		    </div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>