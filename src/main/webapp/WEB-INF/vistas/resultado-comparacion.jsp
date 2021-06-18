<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	
	
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    
	 <link rel="stylesheet" href="css/animate.css">
	
	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">
	<link rel="stylesheet" href="css/magnific-popup.css">

	<link rel="stylesheet" href="css/bootstrap-datepicker.css">
	<link rel="stylesheet" href="css/jquery.timepicker.css">

	
	<link rel="stylesheet" href="css/flaticon.css">
	<link rel="stylesheet" href="css/style.css?v5.3">
	<title>Vida Saludable</title>
	
	</head>
	<body>
	
 
		
	<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
		<div class="container">
			<a class="navbar-brand" href="index">Vida<span> Saludable</span></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="oi oi-menu"></span> Menu
			</button>

			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
 					<li class="nav-item"><a href="seleccionar-ingrediente" class="nav-link">�Qu� puedo cocinar?</a></li> 
 					<li class="nav-item"><a href="hacer-evaluacion" class="nav-link">�Estoy comiendo sano?</a></li> 
				</ul>
			</div>
		</div>
	</nav>
	<!-- END nav -->
	
	<section class="hero-wrap hero-wrap-2" style="background-image: url('images/bg_5.jpg');" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div class="row no-gutters slider-text justify-content-center" style="    margin-top: 9em;">
				<div class="col-md-9 ftco-animate text-center mb-5">
					<h1 class="mb-2 bread"> Vida Saludable</h1>
					<p class="breadcrumbs"><span class="mr-2"><a href="">Platos </a></span>  </p>
				</div>
			</div>
		</div>
	</section>
	
	
	
		<section class="ftco-section bg-light">
		<div class="container">
			<div class="row justify-content-center mb-5 pb-2">
				<div class="col-md-7 text-center heading-section ftco-animate">
 					<h3 class="mb-4">Listado de platos</h2>
				</div>
			</div>	
			<div class="row">
			 
 ${error}
 
  
<section class="ftco-section ftco-no-pt ftco-no-pb" style="width: 100%; margin-bottom: 1em;">
 <div class="container">
  <div class="row d-flex">
 
 <c:forEach var="platos" items="${platos}">


   <div class="col-md-3 ftco-animate makereservation p-4 p-md-5">
     <div class="heading-section ftco-animate mb-5">

 <h3 class="mb-4">${platos.plato.nombre} </h3> 

<img src="images/breakfast-${platos.id_plato}.jpg" class="imagenPlato" style="height: 200px;">

  
  <h3 class="mb-4"><label>Calorias:</label>${platos.plato.calorias} </h3> 
  <h3 class="mb-4"><label>Grasas Trans:</label>${platos.plato.grasastrans} </h3> 
  <h3 class="mb-4"><label>Grasas Saturadas:</label>${platos.plato.grasassaturadas} </h3> 
  <h3 class="mb-4"><label>Carbohidratos Complejos:</label>${platos.plato.carbohidratoscomplejo} </h3> 
  <h3 class="mb-4"><label>Proteinas Magras</label>${platos.plato.proteinasmagras} </h3> 
  <h3 class="mb-4"><label>Grasas Insaturadas</label>${platos.plato.grasasinsaturadas}</h3> 
  <h3 class="mb-4"><label>Fibras</label>${platos.plato.fibras} </h3> 
  <h3 class="mb-4"><label>Carbohidratos Refinados:</label>${platos.plato.carbohidratosrefinado} </h3> 
  <h3 class="mb-4"><label>Proteinas No Magras:</label>${platos.plato.proteinasnomagras} </h3>  
 
 
     
 
    </div>
  </div>
  
   
</c:forEach> 
  
</div>
</div>
</section>



 

 					<div class="col-md-12 text-center" style="text-algin:center;">
 
 <br>
				<p><a href="seleccionar-ingrediente" class="btn btn-success">Volver</a></p>
				</div>
			</div>
		</div>
			</section>
	
		<footer class="ftco-footer ftco-no-pb ftco-section">
			<div class="container">
				<div class="row mb-5">
					<div class="col-md-6 col-lg-3">
						<div class="ftco-footer-widget mb-4">
							<h2 class="ftco-heading-2">APP UNLAM</h2>
							<p>Introducci�n a la App.</p>
							<ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-3">
								<li class="ftco-animate"><a href="#"><span class="fa fa-twitter"></span></a></li>
								<li class="ftco-animate"><a href="#"><span class="fa fa-facebook"></span></a></li>
								<li class="ftco-animate"><a href="#"><span class="fa fa-instagram"></span></a></li>
							</ul>
						</div>
					</div>
					<div class="col-md-6 col-lg-3">
						<div class="ftco-footer-widget mb-4">
							<h2 class="ftco-heading-2">Pasos</h2>
							<ul class="list-unstyled open-hours">
								<li class="d-flex"><span>1 Seleccionar Ingrediente</span></li> 
								<li class="d-flex"><span>2 Seleccionar Plato</span></li> 
								<li class="d-flex"><span>3 Ver Receta</span></li> 
							</ul>
						</div>
					</div>
					<div class="col-md-6 col-lg-3">
						<div class="ftco-footer-widget mb-4">
							<h2 class="ftco-heading-2">Platos</h2>
							<div class="thumb d-sm-flex">
								<a href="#" class="thumb-menu img" style="background-image: url(images/insta-1.jpg);">
								</a>
								<a href="#" class="thumb-menu img" style="background-image: url(images/insta-2.jpg);">
								</a>
								<a href="#" class="thumb-menu img" style="background-image: url(images/insta-3.jpg);">
								</a>
							</div>
							<div class="thumb d-flex">
								<a href="#" class="thumb-menu img" style="background-image: url(images/insta-4.jpg);">
								</a>
								<a href="#" class="thumb-menu img" style="background-image: url(images/insta-5.jpg);">
								</a>
								<a href="#" class="thumb-menu img" style="background-image: url(images/insta-6.jpg);">
								</a>
							</div>
						</div>
					</div>
					<div class="col-md-6 col-lg-3">
						<div class="ftco-footer-widget mb-4">
							<h2 class="ftco-heading-2">Comentarios</h2>
							<p>Calcular Indice Masa Moscular</p>
							<form action="#" class="subscribe-form">
								<div class="form-group">
									<input type="text" class="form-control mb-2 text-center" placeholder="Peso/Medida">
									<input type="submit" value="Calcular" class="form-control submit px-3">
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="container-fluid px-0 bg-primary py-3">
				<div class="row no-gutters">
					<div class="col-md-12 text-center">

						<p class="mb-0">Sitio dise�ado y desarrollado por Alumnos de Taller 1</p>
						</div>
					</div>
				</div>
			</footer>
			

			<!-- loader -->
			<div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


			<script src="js/jquery.min.js"></script>
			<script src="js/jquery-migrate-3.0.1.min.js"></script>
			<script src="js/popper.min.js"></script>
			<script src="js/bootstrap.min.js"></script>
			<script src="js/jquery.easing.1.3.js"></script>
			<script src="js/jquery.waypoints.min.js"></script>
			<script src="js/jquery.stellar.min.js"></script>
			<script src="js/owl.carousel.min.js"></script>
			<script src="js/jquery.magnific-popup.min.js"></script>
			<script src="js/jquery.animateNumber.min.js"></script>
			<script src="js/bootstrap-datepicker.js"></script>
			<script src="js/jquery.timepicker.min.js"></script>
			<script src="js/scrollax.min.js"></script>
			<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
			<script src="js/google-map.js"></script>
			<script src="js/main.js"></script>
			
		</body>
		</html>
		
 
		
 