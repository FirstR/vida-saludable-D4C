<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Login</title>
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
		<a class="navbar-brand" href="index.html">Vida Saludable <span> Login </span></a>
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
					<p class="breadcrumbs"><span class="mr-2"><a href="">Login </a></span>  </p>
				</div>
			</div>
		</div>
	</section>
	
	

<body>
<div class = "container">
	<div id="loginbox" style="margin-top:20px; background-image: url('/images/bg_5.jpg');" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<form:form action="validar-login" method="POST" modelAttribute="usuario">

					<p> Email </p><form:input path="email" id="email" type="email" class="form-control" /> <br>
					<p> Clave </p><form:input path="password" type="password" id="password" class="form-control"/> <br>
					<p class="clearfix">
					<button class="float-left read btn btn-primary" type="submit"/> Login </button>
					</p>
				</form:form>
				<br>
				<br>
					<a href="registro">Registrarme</a>
				<%--Bloque que es visible si el elemento error no está vacío	--%>
				<br>
				<br>
				<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>
				${msg}
			</div>
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
