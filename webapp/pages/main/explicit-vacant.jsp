<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
			
			<a href="Login?action=ViewExplicitVacant&vacant=${vacante_id}&page=<%=actual_page+1 %>" type="button" class="btn btn-info text-white">Next</a>
<%
	}else if(actual_page >= total_page){
%>

			<a href="Login?action=ViewExplicitVacant&vacant=${vacante_id}&page=<%=actual_page-1 %>" type="button" class="btn btn-info text-white">Prev</a>		
<%
	}else{
%>
			<a href="Login?action=ViewExplicitVacant&vacant=${vacante_id}&page=<%=actual_page-1 %>" type="button" class="btn btn-info text-white">Prev</a>
			<a href="Login?action=ViewExplicitVacant&vacant=${vacante_id}&page=<%=actual_page+1 %>" type="button" class="btn btn-info text-white">Next</a>
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
            <%
	if(listaVacia != 0){
%>
            <a type="button" class="btn btn-success text-white" href="Login?action=ViewExplicitVacant&vacant=${vacante_id}&read=accept&alumno_id=${listaAlumnos.GetId()}">Aceptar</a>
            <a type="button" class="btn btn-danger text-white" href="Login?action=ViewExplicitVacant&vacant=${vacante_id}&read=dene&alumno_id=${listaAlumnos.GetId()}">Denegar</a>
<% 	} %>
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
<c:if test="${view_cv == 0}">

	<div class="content_cv alert alert-dark" role="alert">
		Ver Curriculum Vitae <a class="badge badge-dark" href="Login?action=ViewExplicitVacant&vacant=${vacante_id}&read=view_cv&alumno_id=${listaAlumnos.GetId()}">Click Aquí</a>
	</div>
</c:if>          
<div class="content_cv border border-success rounded">
 <div class="content_cv-sub">               
	<div class="row">
	  <div class="col-md-4"><img src="img/29213224-hombre-foto-de-perfil-silueta-avatar.jpg" width="40%" height="40"></div>
	  <div class="col-md-4"><h2>${listaAlumnos.GetNombre()} ${listaAlumnos.GetApellidoP()} ${listaAlumnos.GetApellidoM()}</h2>
	  	<p class="font-italic">Nivel de Estudios:
<c:if test="${nivelEstudios == 1}">	  	
	  	Técnico Superior
</c:if>
<c:if test="${nivelEstudios == 2}">	  	
	  	Licenciado
</c:if>
<c:if test="${nivelEstudios == 3}">	  	
	  	Maestro
</c:if>
<c:if test="${nivelEstudios == 4}">	  	
	  	Doctor
</c:if>
	  	</p>
	  <br>
	  
	  </div>
		<div class=" col-md-4">
			<p class="font-italic text-muted">Teléfono: ${listaAlumnos.GetTelefono()}</p>
			<p class="font-italic text-muted">Direccción: ${listaAlumnos.GetCalle()} ${listaAlumnos.GetDeloMun()} ${listaAlumnos.GetNumero_Int()}
			${listaAlumnos.GetNumero_Ext()} ${listaAlumnos.GetCP()} ${listaAlumnos.GetCiudad()}</p>
		</div>
	</div>
 	 <hr/>
	 <br> 
	 <div class="centrado"><h3>Experiencia Laboral</h3></div> 
<table id="dtBasicExample" class="table table-striped table-bordered">
    <thead>
      <tr>
        <th class="th-sm">
        	Trabajo
        </th>
        <th class="th-sm">
        	Periodo
        </th>
        <th class="th-sm">
        	Puesto
        </th>
      </tr>
    </thead>
    <tbody>  
	   <c:forEach var="trabajos" items="${listaTrabajos}">
		      <tr>
		        <td>${trabajos.GetTrabajo()}</td>
		        <td>${trabajos.GetPeriodo()}</td>
		        <td>${trabajos.GetPuesto()}</td>
		       </tr>	   		  
	   </c:forEach>
    </tbody>
</table>
 	 <hr/>
	 <br> 
	 <div class="centrado"><h3>Cursos</h3></div> 
<table id="dtBasicExample" class="table table-striped table-bordered">
    <thead>
      <tr>
        <th class="th-sm">
        	Curso
        </th>
      </tr>
    </thead>
    <tbody>  
	   <c:forEach var="cursos" items="${listaCurso}">
		      <tr>
		        <td>${cursos}</td>
		       </tr>	   		  
	   </c:forEach>
    </tbody>
</table>	
 	 <hr/>
	 <br>  
	 <div class="centrado"><h3>Información Adicional</h3></div> 
<table id="dtBasicExample" class="table table-striped table-bordered">
    <thead>
      <tr>
        <th class="th-sm">
        	Información adicional
        </th>
      </tr>
    </thead>
    <tbody>  
	   <c:forEach var="informacion" items="${listaInformacion}">
		      <tr>
		        <td>${informacion}</td>
		       </tr>	   		  
	   </c:forEach>
    </tbody>
</table>
 	 <hr/>
	 <br>	
	 <div class="centrado"><h3>Lista de Idiomas</h3></div> 
<table id="dtBasicExample" class="table table-striped table-bordered">
    <thead>
      <tr>
        <th class="th-sm">
        	Idiomas que lee o escribe
        </th>
      </tr>
    </thead>
    <tbody>  
	   <c:forEach var="idiomas" items="${listaIdiomas}">
		      <tr>
		        <td>${idiomas}</td>
		       </tr>	   		  
	   </c:forEach>
    </tbody>
</table>
 	 <hr/>
	 <br>	
	 <p class="centrado"> Curriculum Vitae generado por Bolsa de Trabajo Frey Soft<p>
	 <p class="centrado"> Cualquier aclaración no dude contactar al soporte.<p>
</div>    
</div> 
                      
                   
         </div>           
        </div>
      </div>
    
    
 </c:forEach>
<%
	}
%>