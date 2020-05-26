<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
int total_page = (Integer)session.getAttribute("paginateVacantes");
int actual_page = (Integer)session.getAttribute("actual_page");	
int iLista = (Integer)session.getAttribute("listaVacia");
%>
 <%
	if(total_page > 0 && total_page > 1)
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
		        <td>${vacantes.Gethorario()}</td>
		        <td>${vacantes.Gettipocontratacion()}</td>
		        <td>${vacantes.GetidEmpresa()}</td>
		        <td>${vacantes.Getstatus()}</td>
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
		        <a type="button" class="btn btn-outline-success" href="Login?action=AdminVacant&vacant=${vacantes.Getid()}&method=1"> Activar </a>
		        <br>
		        <hr>
		        <br>
				<a type="button" class="btn btn-outline-danger" href="Login?action=AdminVacant&vacant=${vacantes.Getid()}&method=2">Borrar</a>
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