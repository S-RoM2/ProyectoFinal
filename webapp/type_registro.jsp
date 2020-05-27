<%-- 
    Document   : type_registro
    Created on : 31 mar. 2020, 21:17:16
    Author     : rober
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/home.css">
        <link rel="stylesheet" type="text/css" href="css/main-sup.css">
        <title>Bolsa de Trabajo</title>
    </head>
    <body>
        <jsp:include page="pages/navindex.jsp"></jsp:include>
        <section class="content-section">
			<div class="index">
            <div class="inter"></div>
            <h1>Selecciona tu forma de Registro</h1>

                <button type="submit" class="btn-gradient-porpuse-radius-2" onclick="location.href='user-register-business'">Empresa</button>
                <button type="submit" class="btn-gradient-porpuse-radius-2" onclick="location.href='user-register-student'">Alumnos / Egresados</button>
            
            <hr>
            </div>
            <section class="selection-web">
            	<div class="background-tec">
	                <br>
	                <h1 class="title">¿Por qué elegir nuestra Web?</h1>
	                <br>
	                <p class="text"> Nuestra Web es muy segura y te proveerá de muchas facilidades con<br>
	                    respecto a todas los nuevos empleos existentes en el mercado. Además <br>
	                    somos la elección preferida de casi todas las empresas en el país, <br>
	                    por lo que si quieres trabajo, nuestra plataforma es la ideal</p>
	                <br>
	                <a class="btn-gradient-porpuse-radius" href="#">Registro ahora</a>
	             </div>
            </section>
        </section>
        <jsp:include page="pages/footer.jsp"></jsp:include>
    </body>
</html>
