<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn" %>
<%
int total_page = (Integer)session.getAttribute("paginateAlumnos");
int actual_page = (Integer)session.getAttribute("actual_page");	
int iType2 = (Integer)session.getAttribute("type");
int listaVacia = (Integer)session.getAttribute("listaVacia");
%>
<% 
	if(total_page > 0)
	{
	if (actual_page == 1) {
%>
			
			<a href="Login?action=ViewAllExplicitVacant&vacant=${vacante_id}&page=<%=actual_page+1 %>" type="button" class="btn btn-info text-white">Next</a>
<%
	}else if(actual_page >= total_page){
%>

			<a href="Login?action=ViewAllExplicitVacant&vacant=${vacante_id}&page=<%=actual_page-1 %>" type="button" class="btn btn-info text-white">Prev</a>		
<%
	}else{
%>
			<a href="Login?action=ViewAllExplicitVacant&vacant=${vacante_id}&page=<%=actual_page-1 %>" type="button" class="btn btn-info text-white">Prev</a>
			<a href="Login?action=ViewAllExplicitVacant&vacant=${vacante_id}&page=<%=actual_page+1 %>" type="button" class="btn btn-info text-white">Next</a>
<%
	}
	}
%>
<%
	if(listaVacia == 0){
%>
    <div class="row-fluid">
      <div class="widget-box">
        <div class="widget-title bg_lg"><span class="icon"><i class="icon-signal"></i></span>
          <h5>Vacante</h5>
        </div>
        <div class="widget-content" >
        <div class="semi-center">
          <div class="row-fluid">
            <div class="span9">
            <br>
            <hr />
            <br>
				<div class="alert alert-danger" role="alert">
				  No hay alumnos postulados en esta vacante.!
				</div>
            <hr/>
            <br>
		
            </div>
          </div>
          </div>
         
                
                
                   
         </div>           
        </div>
      </div>
<%
	}else{
%>
<c:forEach var="listaAlumnos" items="${listaAlumnos}">
    <div class="row-fluid">
      <div class="widget-box">
        <div class="widget-title bg_lg"><span class="icon"><i class="icon-signal"></i></span>
          <h5>Vacante</h5>
        </div>
        <div class="widget-content" >
        <div class="semi-center">
          <div class="row-fluid">
            <div class="span9">
            ${msg}
            <br>
			<div class="alert alert-dark" role="alert">
			 En la sección de ver todas las vacantes no puedes aceptar denegar solicitudes, solo observar.
			</div>
            <br>
            <hr />
            <br>
            <p>Datos de contacto: </p>
            <hr/>
            <br>
					<table>
					  <tr>
					    <th>Nombre: </th>
					    <td>${listaAlumnos.GetNombre()}</td>
					  </tr>
					  <tr>
					    <th>Apellido Paterno: </th>
					    <td>${listaAlumnos.GetApellidoP()}</td>
					  </tr>
					  <tr>
					    <th>Apellido Materno: </th>
					    <td>${listaAlumnos.GetApellidoM()}</td>
					  </tr>
					  <tr>
					    <th>Teléfono: </th>
					    <td>${listaAlumnos.GetTelefono()}</td>
					  </tr>
					  <tr>
					    <th>EMAIL: </th>
					    <td>${listaAlumnos.GetEmail()}</td>
					  </tr>
					</table>
					<br>
					<hr />
					<br>
		            <p>Campos de Dirección: </p>
		            <hr/>
		            <br>
		            <table>
					  <tr>
					    <th>Calle: </th>
					    <td>${listaAlumnos.GetCalle()}</td>
					  </tr>
					  <tr>
					    <th>Delegación o Municipio: </th>
					    <td>${listaAlumnos.GetDeloMun()}</td>
					  </tr>
					  <tr>
					    <th>Número Interior: </th>
					    <td>${listaAlumnos.GetNumero_Int()}</td>
					  </tr>
					  <tr>
					    <th>Número Exterior: </th>
					    <td>${listaAlumnos.GetNumero_Ext()}</td>
					  </tr>
					  <tr>
					    <th>Código Postal: </th>
					    <td>${listaAlumnos.GetCP()}</td>
					  </tr>
					  <tr>
					    <th>Ciudad: </th>
					    <td>${listaAlumnos.GetCiudad()}</td>
					  </tr>
					  
					</table>				
            </div>
          </div>
          </div>
          
          
		        <div class="centrar">  
				<div class="card text-center">
				  <div class="card-header">
				    Currículum Vitae
				  </div>
				    <div class="card-body">
				    	<p class="font-weight-normal">Cursos: Curso en ...</p>
				    	<p class="font-weight-normal">Nivel de estudios: Universidad</p>
				    	<p class="font-weight-normal">Periodo Laboral: 2020 a 2030</p>
				    	<p class="font-weight-normal">Puesto: Desarrollador de Software</p>
		                <table class="table table-bordered">
		                    <thead>
		                        <tr>
		                            <th>IDIOMAS</th>
		                        </tr>
		                    </thead>
		                    <tbody>
		                        <tr>
		                            <td class="col-md-9">Inglés</td>
		                        </tr>
		                        <tr>
		                            <td class="col-md-9">Francés</td>
		                        </tr>
		                        <tr>
		                            <td class="col-md-9">Español</td>
		                        </tr>
		                    </tbody>
		                </table>
		                <table class="table table-bordered">
		                    <thead>
		                        <tr>
		                            <th>INFORMACIÓN ADICIONAL</th>
		                        </tr>
		                    </thead>
		                    <tbody>
		                        <tr>
		                            <td class="col-md-9">Payment for August 2016</td>
		                        </tr>
		                        <tr>
		                            <td class="col-md-9">Payment for June 2016</td>
		                        </tr>
		                        <tr>
		                            <td class="col-md-9">Payment for May 2016</td>
		                        </tr>
		                    </tbody>
		                </table>				
				  	</div>
				</div>
		        </div>
                
                
                
                   
         </div>           
        </div>
      </div>
    
    
 </c:forEach>
<%
	}
%>