<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	
	<link href="/proyecto-limpio-spring/css/bootstrap.min.css" rel="stylesheet" >
	<link href="/proyecto-limpio-spring/css/bootstrap-theme.min.css" rel="stylesheet">
	<link rel="stylesheet" href="/proyecto-limpio-spring/css/animate.css">
	<link rel="stylesheet" href="/proyecto-limpio-spring/css/owl.carousel.min.css">
	<link rel="stylesheet" href="/proyecto-limpio-spring/css/owl.theme.default.min.css">
	<link rel="stylesheet" href="/proyecto-limpio-spring/css/magnific-popup.css">

	<link rel="stylesheet" href="/proyecto-limpio-spring/css/bootstrap-datepicker.css">
	<link rel="stylesheet" href="/proyecto-limpio-spring/css/jquery.timepicker.css">

	
	<link rel="stylesheet" href="/proyecto-limpio-spring/css/flaticon.css">
	<link rel="stylesheet" href="/proyecto-limpio-spring/css/style.css?v5.3">
	<title>Vida Saludable</title>
	<style>
	.imagenPlato{
	width: 190px;
    height: 156px;
    margin-bottom: 1em;
	}
	
	.mb-4, .my-4 {
    height: 52px;
    }
    
    .ftco-animate { 
    height: 350px;
    }
	</style>
	</head>
	<body>
	
 

		
	<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
		<div class="container">
			<a class="navbar-brand" href="/proyecto-limpio-spring/index">Vida<span> Saludable</span></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="oi oi-menu"></span> Menu
			</button>

			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
 					<li class="nav-item"><a href="/proyecto-limpio-spring/seleccionar-ingrediente" class="nav-link">¿Qué puedo cocinar?</a></li> 
 					<li class="nav-item"><a href="/proyecto-limpio-spring/hacer-evaluacion" class="nav-link">¿Estoy comiendo sano?</a></li> 
				</ul>
			</div>
		</div>
	</nav>
	<!-- END nav -->
	
	<section class="hero-wrap hero-wrap-2" style="background-image: url('/proyecto-limpio-spring/images/bg_5.jpg');" data-stellar-background-ratio="0.5">
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
	
  <c:set  value='<%= session.getAttribute("idUsuario") %>' var="idUsuario"  /> 
  <c:if test="${empty idUsuario}">
  <c:set  value="0" var="idUsuario"  />
  </c:if>		
	
	
		<section class="ftco-section bg-light">
		<div class="container">
			<div class="row justify-content-center mb-5 pb-2">
				<div class="col-md-7 text-center heading-section ">
 					<h2 class="mb-4">Listado de platos</h2>
				</div>
			</div>	
			<div class="row">
 			  <div class="col-md-12">
			  
			 <c:if test="${not empty msj}">
                <div class="alert alert-warning" role="alert">
                    <p>${msj}</p>
                </div>
            </c:if>	
     
			 <div class="col-md-8">     
			 <form action="/proyecto-limpio-spring/buscar-platos/${idUsuario}">
			   <div class="col-md-6">
			 <input type="text" name="nombre" placeholder="Ingrese el nombre del plato a buscar" class="form-control">
			 </div>
			 
			  <div class="col-md-6">
			 <input type="submit" value="Buscar" class="btn btn-success"> 
			  </div>
			 </form>
			 </div>
			  <div class="col-md-4">
			
			  <a href="/proyecto-limpio-spring/ver-resultado-comparacion/${idUsuario}"  class="btn btn-info"> Ver Comparacion</a>
			 </div>
			
			 </div>
 				${error}
 
 
 


<section class="ftco-section ftco-no-pt ftco-no-pb" style="    margin-bottom: 1em;">
 <div class="container">
  <div class="row d-flex">
<form action="/proyecto-limpio-spring/agregar-a-la-comparacion/${idUsuario}">


 <c:forEach var="platos" items="${platos}">

<c:set  value="0" var="bandera"  />

   <div class="col-md-3 ftco-animate makereservation p-4 p-md-5">
     <div class="heading-section ftco-animate mb-5">

      <h3 class="mb-4">${platos.nombre} </h3> 

<img src="/proyecto-limpio-spring/images/breakfast-${platos.id_plato}.jpg" class="imagenPlato">
     
  <c:forEach var="platosAgregados" items="${platosAgregados}">
  
  <c:if test="${platos.id_plato==platosAgregados.plato.id_plato}">
  <p><a href="/proyecto-limpio-spring/quitar-plato/${platosAgregados.id_comparar}" class="btn btn-primary">Quitar</a></p>

<c:set  value="1" var="bandera"  />
  </c:if>
  
  </c:forEach> 
  
      <c:if test="${ bandera==0}">
   <p>Comparar<input type="checkbox" value="${platos.id_plato} " name="platos[]" /> <p>
    </c:if>
    </div>
  </div>
  
   
</c:forEach> 
			 <c:if test="${not empty platos}">
			 <div class="col-md-12" style="    text-align: center;    margin-top: 2em;">
			 <input type="submit" value="Agregar al Comparador" class="btn btn-primary"> 
			 </div>
			 </c:if>	
</form>
 
</div>
</div>
</section>



 

 					<div class="col-md-12 text-center" style="text-algin:center;">
 

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
							<p>Introducción a la App.</p>
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

						<p class="mb-0">Sitio diseñado y desarrollado por Alumnos de Taller 1</p>
						</div>
					</div>
				</div>
			</footer>
			

			<!-- loader -->
			<div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


			<script src="/proyecto-limpio-spring/js/jquery.min.js"></script>
			<script src="/proyecto-limpio-spring/js/jquery-migrate-3.0.1.min.js"></script>
			<script src="/proyecto-limpio-spring/js/popper.min.js"></script>
			<script src="/proyecto-limpio-spring/js/bootstrap.min.js"></script>
			<script src="/proyecto-limpio-spring/js/jquery.easing.1.3.js"></script>
			<script src="/proyecto-limpio-spring/js/jquery.waypoints.min.js"></script>
			<script src="/proyecto-limpio-spring/js/jquery.stellar.min.js"></script>
			<script src="/proyecto-limpio-spring/js/owl.carousel.min.js"></script>
			<script src="/proyecto-limpio-spring/js/jquery.magnific-popup.min.js"></script>
			<script src="/proyecto-limpio-spring/js/jquery.animateNumber.min.js"></script>
			<script src="/proyecto-limpio-spring/js/bootstrap-datepicker.js"></script>
			<script src="/proyecto-limpio-spring/js/jquery.timepicker.min.js"></script>
			<script src="/proyecto-limpio-spring/js/scrollax.min.js"></script>
			<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
			<script src="/proyecto-limpio-spring/js/google-map.js"></script>
			<script src="/proyecto-limpio-spring/js/main.js"></script>
			
		</body>
		</html>