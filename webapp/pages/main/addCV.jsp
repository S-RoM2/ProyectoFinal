<!--Chart-box-->    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
	int iExist = (Integer)session.getAttribute("alumno_cv");

	if (iExist >0){
%>
    <div class="row-fluid">
      <div class="widget-box">
        <div class="widget-title bg_lg"><span class="icon"><i class="icon-signal"></i></span>
          <h5>Agregar CV</h5>
        </div>
        <div class="widget-content" > 
        	${msg}
			<form action="Login?action=AddCV&manage=addEstudios" method="post">
			  <div class="form-group">
					<div align="center">
					<br>
			  		<p> Campo de Nivel de estudios </p>
			  		</div>
			  		<hr />
			  		<br />
					<div class="form-group row">
                        <label for="horario" class="col-sm-2 col-form-label">Nivel de Estudios</label>
                        <div class="col-sm-10">
                        <select class="custom-select" name="nivel_estudios">
                          <option selected value=0>Escoge tu nivel de estudios</option>
                          <option value=1>Técnico Superior</option>
                          <option value=2>Licenciado</option>
                          <option value=3>Maestro</option>
                          <option value=4>Doctor</option>    
                        </select>
                        </div>
                      </div>
			  </div>
			  <div align="right"> 
			  <button type="submit" class="btn btn-primary">Agregar a CV</button>
			  </div>
			</form>
			<hr>
			<form action="Login?action=AddCV&manage=addExpLab" method="post">
			  <div class="form-group">
					<div align="center">
					<br>
			  		<p> Campo de Experiencia Laboral </p>
			  		</div>
			  		<hr />
			  		<br />
					<div class="form-group row">
                        <label for="cursos" class="col-sm-2 col-form-label">Trabajo</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="trabajo" name="trabajo" placeholder="Trabajo...">
                        </div>
                      </div>
					<div class="form-group row">
                        <label for="cursos" class="col-sm-2 col-form-label">Periodo Laboral</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="periodo" name="periodo" placeholder="2020-2020">
                        </div>
                      </div>
 					<div class="form-group row">
                        <label for="cursos" class="col-sm-2 col-form-label">Puesto desempeñado</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="puesto" name="puesto" placeholder="Puesto en...">
                        </div>
                      </div>
			  </div>
			  <div align="right"> 
			  <button type="submit" class="btn btn-primary">Agregar a CV</button>
			  </div>
			</form>
			<form action="Login?action=AddCV&manage=addLanguage" method="post">
			  <div class="form-group">
					<div align="center">
					<br>
			  		<p> Campo de Idioma </p>
			  		</div>
			  		<hr />
			  		<br />
					<div class="form-group row">
                        <label for="cursos" class="col-sm-2 col-form-label">Idioma (que habla o lee)</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="idioma" name="idioma" placeholder="Trabajo...">
                        </div>
                      </div>
			  </div>
			  <div align="right"> 
			  <button type="submit" class="btn btn-primary">Agregar a CV</button>
			  </div>
			</form>
			<form action="Login?action=AddCV&manage=addInformacion" method="post">
			  <div class="form-group">
					<div align="center">
					<br>
			  		<p> Campo de Información adicional </p>
			  		</div>
			  		<hr />
			  		<br />
					<div class="form-group row">
                        <label for="cursos" class="col-sm-2 col-form-label">Información adicional</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="informacion" name="informacion" placeholder="Trabajo...">
                        </div>
                      </div>
			  </div>
			  <div align="right"> 
			  <button type="submit" class="btn btn-primary">Agregar a CV</button>
			  </div>
			</form>
        </div>
      </div>
    </div>
<!--End-Chart-box--> 
    <hr/>
    <% 
    
	}else{
		
   %>
    <div class="row-fluid">
      <div class="widget-box">
        <div class="widget-title bg_lg"><span class="icon"><i class="icon-signal"></i></span>
          <h5>Agregar CV</h5>
        </div>
        <div class="widget-content" >
        		<div class="alert alert-primary" role="alert">
					  Parece que no tienes un CV creado, crea uno dando <a class="badge badge-info" href="Login?action=AddCV&manage=regist">Click Aquí</a>
				</div>
        </div>
      </div>
    </div>
<!--End-Chart-box--> 
    <hr/>    
    <%
	}
    %>