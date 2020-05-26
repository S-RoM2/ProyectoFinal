<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	int iType = (Integer)session.getAttribute("type");
%>
<!--Chart-box-->    

    <div class="row-fluid">
      <div class="widget-box">
        <div class="widget-title bg_lg"><span class="icon"><i class="icon-signal"></i></span>
          <h5>Estado de la Cuenta</h5>
        </div>
        <div class="widget-content" >
          <div class="row-fluid">
            <div class="span9">
            <p>Datos de contacto: </p>
            <hr/>
            <br>
            <%
            	if (iType == 2) { 
            %>
				<table>
				  <tr>
				    <th>Nombre: </th>
				    <td>${dataAccount.GetNombre()}</td>
				  </tr>
				  <tr>
				    <th>RFC: </th>
				    <td>${dataAccount.GetRFC()}</td>
				  </tr>
				  <tr>
				    <th>Teléfono: </th>
				    <td>${dataAccount.GetTelefono()}</td>
				  </tr>
				  <tr>
				    <th>FAX: </th>
				    <td>${dataAccount.GetFAX()}</td>
				  </tr>
				  <tr>
				    <th>Giro: </th>
				    <td>${dataAccount.Getgiro()}</td>
				  </tr>
				  <tr>
				    <th>Descripción: </th>
				    <td>${dataAccount.Getdescripcion()}</td>
				  </tr>
				  <tr>
				    <th>EMAIL: </th>
				    <td>${dataAccount.GetEmail()}</td>
				  </tr>
				  <tr>
				    <th>EMAIL: </th>
				    <td>${dataAccount.Getpaginaweb()}</td>
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
				    <td>${dataAccount.GetCalle()}</td>
				  </tr>
				  <tr>
				    <th>Delegación o Municipio: </th>
				    <td>${dataAccount.GetDeloMun()}</td>
				  </tr>
				  <tr>
				    <th>Número Interior: </th>
				    <td>${dataAccount.GetNumero_Int()}</td>
				  </tr>
				  <tr>
				    <th>Número Exterior: </th>
				    <td>${dataAccount.GetNumero_Ext()}</td>
				  </tr>
				  <tr>
				    <th>Código Postal: </th>
				    <td>${dataAccount.GetCP()}</td>
				  </tr>
				  <tr>
				    <th>Ciudad: </th>
				    <td>${dataAccount.GetCiudad()}</td>
				  </tr>
				</table>
				<% 
					} else { 
				%>
					<table>
					  <tr>
					    <th>Nombre: </th>
					    <td>${dataAccount.GetNombre()}</td>
					  </tr>
					  <tr>
					    <th>Apellido Paterno: </th>
					    <td>${dataAccount.GetApellidoP()}</td>
					  </tr>
					  <tr>
					    <th>Apellido Materno: </th>
					    <td>${dataAccount.GetApellidoM()}</td>
					  </tr>
					  <tr>
					    <th>Teléfono: </th>
					    <td>${dataAccount.GetTelefono()}</td>
					  </tr>
					  <tr>
					    <th>EMAIL: </th>
					    <td>${dataAccount.GetEmail()}</td>
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
					    <td>${dataAccount.GetCalle()}</td>
					  </tr>
					  <tr>
					    <th>Delegación o Municipio: </th>
					    <td>${dataAccount.GetDeloMun()}</td>
					  </tr>
					  <tr>
					    <th>Número Interior: </th>
					    <td>${dataAccount.GetNumero_Int()}</td>
					  </tr>
					  <tr>
					    <th>Número Exterior: </th>
					    <td>${dataAccount.GetNumero_Ext()}</td>
					  </tr>
					  <tr>
					    <th>Código Postal: </th>
					    <td>${dataAccount.GetCP()}</td>
					  </tr>
					  <tr>
					    <th>Ciudad: </th>
					    <td>${dataAccount.GetCiudad()}</td>
					  </tr>
					</table>				
				<%
					} 
				%>
            </div>
            <%
            	if (iType == 2) { 
            %>
            <div class="span3">
              <ul class="site-stats">
                <li class="bg_lh"><i class="icon-user"></i> <strong>25</strong> <small>Total de solicitudes</small></li>
                <li class="bg_lh"><i class="icon-plus"></i> <strong>10</strong> <small>Nuevas solicitudes </small></li>
                <li class="bg_lh"><i class="icon-repeat"></i> <strong>10</strong> <small>Solicitudes leídas</small></li>
                <li class="bg_lh"><i class="icon-globe"></i> <strong>8540</strong> <small>Total de estudiantes</small></li>
              </ul>
            </div>
            <%
            	}
            %>
          </div>
        </div>
      </div>
    </div>
<!--End-Chart-box--> 