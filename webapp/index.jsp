<%-- 
    Document   : index
    Created on : 31 mar. 2020, 11:21:50
    Author     : rober
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
        <link rel="stylesheet" type="text/css" href="css/main-sup.css">
        <link rel="stylesheet" type="text/css" href="css/home.css">
		<link rel="stylesheet" type="text/css" href="css/dash.css">
        <title>Bolsa de Trabajo</title>
    </head>
    <body>
        <jsp:include page="/pages/navindex.jsp"></jsp:include>
       <section class="content-section">
       <div class="view">
       		<div class="index">
            <div class="inter"></div>
            <h1>Busca un trabajo a tu comodidad...</h1>
            <div class="contenedor-search">
            <section class="search-job">
                <br>
                <form class="needs-validation" novalidate>
                  <div class="form-row">
                    <div class="col-md-4 mb-3">
                      <label for="validationTooltip01">Tipo de Trabajo</label>
                      <input type="text" class="form-control" id="validationTooltip01" placeholder="Tipo de trabajo" required>
                    </div>
                    <div class="col-md-4 mb-3">
                      <label for="validationTooltip02">Horario</label>
                        <select class="custom-select">
                          <option selected>Escoger horario</option>
                          <option value="1">1-2 horas diarias</option>
                          <option value="2">2-3 horas diarias</option>
                          <option value="3">3-5 horas diarias</option>
                          <option value="4">3-8 horas diarias</option>    
                          <option value="4">8 horas Fin de Semana</option>    
                        </select>
                    </div>
                    <div class="col-md-4 mb-3">
                      <label for="validationTooltipUsername">Empresa</label>
                      <div class="input-group">
                        <div class="input-group-prepend">
                          <span class="input-group-text" id="validationTooltipUsernamePrepend">@</span>
                        </div>
                        <input type="text" class="form-control" id="validationTooltipUsername" placeholder="Company" aria-describedby="validationTooltipUsernamePrepend" required>
                      </div>
                    </div>
                  </div>
                  <div class="form-row">
                    <div class="col-md-6 mb-3">
                      <label for="validationTooltip03">Ubicación de Trabajo</label>
                      <input type="text" class="form-control" id="validationTooltip03" placeholder="Ciudad" required>
                    </div>
                    <button class="btn-gradient-porpuse-2" type="submit">Buscar ahora</button>

                  </div>
                </form>
            </section>
                </div>
               
            <hr>
            </div>
            </div> 
            <section class="selection-web">
   
			<div class="container my-5 p-5 z-depth-1">
			
			
			  <!--Section: Content-->
			  <section class="dark-grey-text">
			
			    <!-- Section heading -->
			    <h2 class="text-center font-weight-bold mb-4 pb-2">¿Por qué es tan genial nuestra Bolsa?</h2>
			    <!-- Section description -->
			    <p class="text-center lead grey-text mx-auto mb-5">Trabajamos durante años para poder brindar la mejor atención al cliente, junto a tres aspectos importantes</p>
			
			    <!-- Grid row -->
			    <div class="row">
			
			      <!-- Grid column -->
			      <div class="col-lg-5 text-center text-lg-left">
			        <img class="img-fluid" src="https://mdbootstrap.com/img/Photos/Others/screens-section.jpg" alt="Sample image">
			      </div>
			      <!-- Grid column -->
			
			      <!-- Grid column -->
			      <div class="col-lg-7">
			
			        <!-- Grid row -->
			        <div class="row mb-3">
			
			          <!-- Grid column -->
			          <div class="col-1">
			            <i class="fas fa-share fa-lg indigo-text"></i>
			          </div>
			          <!-- Grid column -->
			
			          <!-- Grid column -->
			          <div class="col-xl-10 col-md-11 col-10">
			            <h5 class="font-weight-bold mb-3">Seguridad</h5>
			            <p class="grey-text">Todos los datos que guardamos son cifrados en la base de datos por lo que tu información siempre se encuentra segura con nosotros.</p>
			          </div>
			          <!-- Grid column -->
			
			        </div>
			        <!-- Grid row -->
			
			        <!-- Grid row -->
			        <div class="row mb-3">
			
			          <!-- Grid column -->
			          <div class="col-1">
			            <i class="fas fa-share fa-lg indigo-text"></i>
			          </div>
			          <!-- Grid column -->
			
			          <!-- Grid column -->
			          <div class="col-xl-10 col-md-11 col-10">
			            <h5 class="font-weight-bold mb-3">Tecnología</h5>
			            <p class="grey-text">Contamos con la mejor tecnología en nuestros servidores, por lo que nunca habrán fallas de operación.</p>
			          </div>
			          <!-- Grid column -->
			
			        </div>
			        <!-- Grid row -->
			
			        <!--Grid row-->
			        <div class="row">
			
			          <!-- Grid column -->
			          <div class="col-1">
			            <i class="fas fa-share fa-lg indigo-text"></i>
			          </div>
			          <!-- Grid column -->
			
			          <!-- Grid column -->
			          <div class="col-xl-10 col-md-11 col-10">
			            <h5 class="font-weight-bold mb-3">Políticas</h5>
			            <p class="grey-text mb-0">Todos nuestros clientes (empresas) se encuentran dispuestos a brindar una excelente oferta para los intereses económicos..</p>
			          </div>
			          <!-- Grid column -->
			
			        </div>
			        <!--Grid row-->
			
			      </div>
			      <!--Grid column-->
			
			    </div>
			    <!-- Grid row -->
			
			  </section>
			  <!--Section: Content-->
			
			
			</div>        
            	<div class="background-tec">
	                <br>
	                <h1 class="title">¿Por qué elegir nuestra Web?</h1>
	                <br>
	                <p class="text"> Nuestra Web es muy segura y te proveerá de muchas facilidades con<br>
	                    respecto a todas los nuevos empleos existentes en el mercado. Además <br>
	                    somos la elección preferida de casi todas las empresas en el país, <br>
	                    por lo que si quieres trabajo, nuestra plataforma es la ideal</p>
	                <br>
	                <button class="btn-gradient-porpuse-radius" type="submit">Registro ahora</button>
                </div>
                
            </section>
            
            
        </section>
        <jsp:include page="/pages/footer.jsp"></jsp:include>

    </body>
</html>
