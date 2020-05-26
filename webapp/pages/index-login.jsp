<%
	int iType = (Integer)session.getAttribute("type");
	int IsAdmin = (Integer)session.getAttribute("IsAdmin");
	String main = "";
	String action = String.valueOf(session.getAttribute("page"));
	if (session.getAttribute("clave") == null){
		main = "pages/login.jsp";
	} else{
		switch (action){
			case "change-password":
				main = "main/change-password.jsp";
				break;
			case "change-address":
				main = "main/change-address.jsp";
				break;
			case "change-description":
				main = "main/change-description.jsp";
				break;
			case "change-email":
				main = "main/change-email.jsp";
				break;
			case "change-name":
				main = "main/change-name.jsp";
				break;
			case "change-phone":
				main = "main/change-phone.jsp";
				break;
			case "add-vacant":
				main = "main/add-vacant.jsp";
				break;
			case "view-vacant":
				main = "main/view-vacant.jsp";
				break;
			case "view-explicit-vacant":
				main = "main/explicit-vacant.jsp";
				break;
			case "view-all-explicit-vacant":
				main = "main/explicit-vacant-all.jsp";
				break;
			case "add-cv":
				main = "main/addCV.jsp";
				break;
			case "adminVacant":
				main = "main/admin-vacante.jsp";
				break;
			case "adminAccount":
				main = "main/admin-Account.jsp";
				break;
			case "adminContact":
				main = "main/admin-Contact.jsp";
				break;
			default:
				main = "main/index.jsp";
				break;
		}
	}
%>
<section class="content-section-login">
<!--Header-part-->
<div id="header">
</div>
<!--close-Header-part--> 
<!--sidebar-menu-->
<div id="sidebar"><a href="Login?action=Home" class="visible-phone"><i class="icon icon-home"></i> Dashboard</a>
  <ul>
    <li class="active"><a href="Login?action=Home"><i class="icon icon-home"></i> <span>Home</span></a> </li>
    <%
      if (iType == 2){ 
    %>
    <li> <a href="Login?action=AddVacant"><i class="icon icon-signal"></i> <span>Crear vacante</span></a> </li>
    <%
      }else{
    %>
    <li> <a href="Login?action=ViewVacant"><i class="icon icon-signal"></i> <span>Consultar vacantes</span></a> </li>
    <li> <a href="Login?action=AddCV"><i class="icon icon-signal"></i> <span>Subir CV</span></a> </li>
    <%
      }
    %>
    <%
      if (iType == 2){ 
    %>
    <li><a href="Login?action=ViewVacant"><i class="icon icon-fullscreen"></i> <span>Ver Vacante</span></a></li>
    <%
      }
    %>
                <%
      if (iType == 2){ 
    %>
    <li class="submenu"> <a href="#"><i class="icon icon-pencil"></i> <span>Ajustes de cuenta</span> <span class="label label-important">6</span></a>
             <%
      }else{
    %>
        <li class="submenu"> <a href="#"><i class="icon icon-pencil"></i> <span>Ajustes de cuenta</span> <span class="label label-important">5</span></a>
             <%
      }
    %>
      <ul>
        <li><a href="Login?action=accountPassword">Cambiar contraseña</a></li>
        <li><a href="Login?action=Accountemail">Cambiar Email</a></li>
        <li><a href="Login?action=Accountname">Cambiar Nombre</a></li>
        <li><a href="Login?action=Accountphone">Cambiar Teléfono</a></li>
            <%
      if (iType == 2){ 
    %>
        <li><a href="Login?action=Accountdescription">Cambiar Descripción</a></li>
            <%
      }
    %>
        <li><a href="Login?action=Accountaddress">Cambiar Dirección</a></li>
      </ul>
    </li>
    <li class="submenu"> <a href="#"><i class="icon icon-info-sign"></i> <span>Administrar cuenta</span> <span class="label label-important">3</span></a>
      <ul>
        <li><a href="Login?action=SuspendAccount">Suspender cuenta</a></li>
        <li><a href="">Reportar un error</a></li>
        <li><a href="">Ir a soporte</a></li>
      </ul>
    </li>
    <%
      if (IsAdmin > 1){ 
    %>
    <li><a href="Login?action=AdminContact"><i class="icon icon-fullscreen"></i> <span>Ver contacto</span></a></li>
    <li><a href="Login?action=AdminVacant"><i class="icon icon-fullscreen"></i> <span>Administrar Vacantes</span></a></li>
    <li><a href="Login?action=AdminAccount"><i class="icon icon-fullscreen"></i> <span>Administrar Cuentas</span></a></li>
    <%
      if (iType == 2){ 
    %>
    <li> <a href="Login?action=ChangeToStudent"><i class="icon icon-signal"></i> <span>Cambiar a cuenta tipo Estudiante</span></a> </li>
    <%
      }else{
    %>
    <li> <a href="Login?action=ChangeToBusiness"><i class="icon icon-signal"></i> <span>Cambiar a cuenta tipo Empresa</span></a> </li>
    <%
      }
    }
    %>
  </ul>
</div>
<!--sidebar-menu-->
<!--main-container-part-->
<div id="content">
<!--breadcrumbs-->
  <div id="content-header">
    <div id="breadcrumb"> <a href="" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
  </div>
<!--End-breadcrumbs-->

<!--Action boxes-->
  <div class="container-fluid">
    <div class="quick-actions_homepage">
      <ul class="quick-actions">
        <li class="bg_lb"> <a href="Login?action="> <i class="icon-dashboard"></i> <span class="label label-important">20</span> My Dashboard </a> </li>
 		<%
              if (iType == 2){ 
   		%>
        <li class="bg_lg span3"> <a href="Login?action=AddVacant"> <i class="icon-signal"></i> Crear Vacante</a> </li>
        <%
              }else{
        %>
        <li class="bg_lg span3"> <a href="Login?action=ViewVacant"> <i class="icon-signal"></i> Consultar Vacantes</a> </li>        
        <%
              }
        %>
        <li class="bg_lo"> <a href="#"> <i class="icon-exchange"></i> Convertirse en Socio</a> </li>
 		<%
              if (iType == 2){ 
   		%>
        <li class="bg_ls"> <a href="Login?action=ViewVacant"> <i class="icon-pencil"></i> Ver Vacante </a> </li>
        <%
              }
        %>
        <li class="bg_lb"> <a href="Login?action=Contact"> <i class="icon-info-sign"></i>Soporte</a> </li>

      </ul>
    </div>
<!--End-Action boxes-->    
	<jsp:include page="<%=main%>"></jsp:include>
	
	  </div>
</div>
</section>