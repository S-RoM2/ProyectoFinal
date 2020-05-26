<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
int total_page = (Integer)session.getAttribute("paginateVacantes");
int actual_page = (Integer)session.getAttribute("actual_page");	
int iType2 = (Integer)session.getAttribute("type");
int iLista = (Integer)session.getAttribute("listaVacia");
if (iType2 == 1){
%>
<nav class="navbar navbar-light bg-light">
  <form class="form-inline" action="Login?action=ViewVacant" method="post">
    <input class="form-control mr-sm-2" type="search" placeholder="Nombre de la empresa" name="nombre_empresa" aria-label="Search">
    <select class="custom-select" name="horario">
	    <option selected value=0>Escoger horario</option>
	    <option value=1>1-2 horas diarias</option>
	    <option value=2>2-3 horas diarias</option>
	    <option value=3>3-5 horas diarias</option>
	    <option value=4>3-8 horas diarias</option>    
	    <option value=5>8 horas Fin de Semana</option>    
    </select>
    <select class="custom-select" name="tipo_contratacion">
		<option selected value=0>Escoger tipo de contratación</option>
		<option value=1>Por horas</option>
		<option value=2>Tiempo Completo</option>
		<option value=3>Días no hábiles</option>    
	</select>
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Filtrar datos</button>
  </form>
</nav>
 <%
}
	if(total_page > 0)
	{
	if (actual_page == 1) {
%>

			<a href="Login?action=ViewVacant&page=<%=actual_page+1 %>" type="button" class="btn btn-warning">Next</a>

<%
	}else if((total_page % 5 != 0) && (actual_page > total_page)){
%>
			<a href="Login?action=ViewVacant&page=<%=actual_page-1 %>" type="button" class="btn btn-warning">Prev</a>	
<%
	}else if((total_page % 5 == 0) && (actual_page == total_page)){
%>

			<a href="Login?action=ViewVacant&page=<%=actual_page-1 %>" type="button" class="btn btn-warning">Prev</a>			
<%
	}else{
%>
			<a href="Login?action=ViewVacant&page=<%=actual_page-1 %>" type="button" class="btn btn-warning">Prev</a>
			<a href="Login?action=ViewVacant&page=<%=actual_page+1 %>" type="button" class="btn btn-warning">Next</a>
<%
	}
	}
%>		
<hr>
<br>
${msg}
<table id="dtBasicExample" class="table table-striped table-bordered">
    <thead>
      <tr>
        <th class="th-sm">
        	Nombre
        </th>
        <th class="th-sm">
        	Requisitos
        </th>
        <th class="th-sm">
        	Descripción
        </th>
        <th class="th-sm">
        	Sueldo
        </th>
        <th class="th-sm">
        	Horario
        </th>
        <th class="th-sm">
        	Tipo de contratación
        </th>
        <th class="th-sm">
        	Empresa
        </th>
        <th class="th-sm">
        	Status
        </th>
        <th class="th-sm">
        	Datos de Contacto
        </th>
      </tr>
    </thead>
    <tbody>
		<c:forEach var="vacantes" items="${listarVacantes}">
		      <tr>
		        <td>${vacantes.Getnombrevacante()}</td>
		        <td>${vacantes.Getrequisitos()}</td>
		        <td>${vacantes.Getdescripcion()}</td>
		        <td>${vacantes.GetSueldo()}</td>
		        <td>
		        	<c:if test="${vacantes.Gethorario() == 5}">
		        		8 horas Fin de Semana
		        	</c:if>		        	
		        	<c:if test="${vacantes.Gethorario() == 4}">
		        		3-8 horas diarias
		        	</c:if>		 
		        	<c:if test="${vacantes.Gethorario() == 3}">
		        		3-5 horas diarias
		        	</c:if>
		        	<c:if test="${vacantes.Gethorario() == 2}">
		        		2-3 horas diarias
		        	</c:if>		        	
		        	<c:if test="${vacantes.Gethorario() == 1}">
		        		1-2 horas diarias
		        	</c:if>		        
		        </td>
		        <td>
		        	<c:if test="${vacantes.Gettipocontratacion() == 3}">
		        		Dias no habiles
		        	</c:if>
		        	<c:if test="${vacantes.Gettipocontratacion() == 2}">
		        		Tiempo completo
		        	</c:if>		        	
		        	<c:if test="${vacantes.Gettipocontratacion() == 1}">
		        		Por horas
		        	</c:if>
		        </td>
		        <td>${vacantes.Getnombre_empresa()}</td>
		        <td>
		        	<c:if test="${vacantes.Getstatus() == 'OK'}">
		        		<span class="badge badge-success">OK</span>
		        	</c:if>	
		        	<c:if test="${vacantes.Getstatus() != 'OK'}">
		        		<span class="badge badge-danger">NOT</span>
		        	</c:if>	
		        </td>
		        <td>
		        	<hr>
		        	<p>Nombre:</p>
		        	<hr>
					<p>${vacantes.Getnombre_contacto()}</p>
		        	<hr>
		        	<p>Apellido paterno: </p>
		        	<hr>
		        	<p>${vacantes.Getapellido_p_contacto()}</p>
		        	<hr>
		        	<p>Apellido materno: </p>
		        	<hr>
		        	<p>${vacantes.Getapellido_m_contacto()}</p>
		        </td>
		        <td>
 		<%
              if (iType2 == 2){ 
   		%>
		        <a type="button" class="btn btn-outline-success" href="Login?action=ViewExplicitVacant&vacant=${vacantes.Getid()}"> Revisar </a>
		        <br>
		        <hr>
		        <br>
				<a type="button" class="btn btn-outline-danger" href="Login?action=DeleteVacant&vacant=${vacantes.Getid()}">Borrar</a>
				<br>
				<hr>
				<br>
				<a type="button" class="btn btn-outline-success" href="Login?action=ViewAllExplicitVacant&vacant=${vacantes.Getid()}&view_all=all"> Todas </a>
				
		<% }else{ %>
		
		        <a type="button" class="btn btn-outline-success" href="Login?action=ApplyForVacant&vacant=${vacantes.Getid()}"> Solicitar </a>
		        <br>		
		<% } %> 

		        </td>
		 
		      </tr>
		</c:forEach>
    </tbody>
  </table>	
 <%
	if (iLista == 0){
%>
	<div class="alert alert-danger" role="alert">
  		No hay vacantes disponibles!
	</div>	
	<%
	}
%>