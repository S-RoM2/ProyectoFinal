<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
int iLista = (Integer)session.getAttribute("listaContactoVacia");
%>
<table id="dtBasicExample" class="table table-striped table-bordered">
    <thead>
      <tr>
        <th class="th-sm">
        	Nombre
        </th>
        <th class="th-sm">
        	Asunto
        </th>
        <th class="th-sm">
        	Email
        </th>
        <th class="th-sm">
        	Mensaje
        </th>
      </tr>
    </thead>
    <tbody>
		<c:forEach var="contactos" items="${listaContactos}">
		      <tr>
		        <td>${contactos.GetNombre()}</td>
		        <td>${contactos.GetEmail()}</td>
		        <td>${contactos.GetAsunto()}</td>
		        <td>${contactos.GetMensaje()}</td>
		        <td>
		        <a type="button" class="btn btn-outline-success" href="Login?action=ApplyForContact&contact=${contactos.GetID()}"> Marcar como Leído </a>
		        <br>
		        </td>
		 
		      </tr>
		</c:forEach>
    </tbody>
  </table>	
 <%
	if (iLista == 0){
%>
	<div class="alert alert-danger" role="alert">
  		No hay mensajes en estos momentos!
	</div>	
	<%
	}
%>