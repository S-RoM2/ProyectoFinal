<%-- 
    Document   : navindex
    Created on : 11 abr. 2020, 13:17:11
    Author     : rober
--%>
<% String texto = "", texto2 = "", url = "", url2 = ""; %>
<% if (session.getAttribute("clave") == null){
	texto = "Crear cuenta";
	texto2 = "Iniciar Sesión";
	url = "user-login";
	url2 = "user-register";
	}else{
		texto = "Bienvenido" + " " + (String)session.getAttribute("clave");
		texto2 = "Desconectarse";
		url = "Logout";
		url2 = "Login?action=Home";
	}
%>
        <section class="navbar-sup">
        <div class="navsup">
               <nav>
                 <img src="img/logo.png" alt="FreySoft" height="50" width="100">
                 <ul>
                   <li><a href="index">Inicio</a></li>  
                   <li><a href="contacto">Solicitar cuenta</a></li>
                   <li><a class="active" href="recomend">Recomendaciones</a></li>
                   <li><a href="search_job">Buscar empleo</a></li>
                   <li><a href="about_us">About Us</a></li>
	               <li><a href="<%=url %>"><%=texto2 %></a></li>
	               <li><a href="<%=url2 %>"><%=texto %></a></li>
                 </ul>
               </nav>
               </div>
        </section>