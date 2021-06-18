<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Registrarse</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

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
    </head>

    <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
        <div class="container">
            <a class="navbar-brand" href="index.html">Vida Saludable <span>Registro</span></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="oi oi-menu"></span>
            </button>

            <div class="collapse navbar-collapse" id="ftco-nav">
            </div>
        </div>
    </nav>
    
    	<section class="hero-wrap hero-wrap-2" style="background-image: url('images/bg_5.jpg');" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div class="row no-gutters slider-text justify-content-center" style="    margin-top: 9em;">
				<div class="col-md-9  text-center mb-5">
					<h1 class="mb-2 bread"> Vida Saludable</h1>
					<p class="breadcrumbs"><span class="mr-2"><a href="">Registro </a></span>  </p>
				</div>
			</div>
		</div>
	</section>
	

    <body>
    <div class = "container">
        <div id="loginbox" style="margin-top:120px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <form:form action="registrar" method="POST" modelAttribute="datosDeRegistro">

        <p> Email: </p> <form:input path="email" name="email" id= "email" class="form-control" type="email"/> <br>
        <p> Clave: </p> <form:input path="password" name="password" id= "password" class="form-control" type="password"/> <br>
        <p> Confirmar clave: </p> <form:input path="confirmaPassword" name="repitepassword" id= "repitepassword" class="form-control" type="password"/> <br>

        <button class="float-left read btn btn-primary" type="submit"/> Registrarse </button>

    </form:form>

            <br>
            <br>

            <c:if test="${not empty error}">
                <h4><span>${error}</span></h4>
                <br>
            </c:if>

        </div>
    </div>


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
