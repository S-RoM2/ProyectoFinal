<!--Chart-box-->    
    <div class="row-fluid">
      <div class="widget-box">
        <div class="widget-title bg_lg"><span class="icon"><i class="icon-signal"></i></span>
          <h5>Agregar Vacante</h5>
        </div>
        <div class="widget-content" >
			<form action="Login?action=AddVacant-add" method="post">
			  <div class="form-group">
					<div align="center">
					${msg}
			  		<p> Campos de Vacante </p>
			  		</div>
			  		<hr />
			  		<br />
					<div class="form-group row">
                        <label for="nombre" class="col-sm-2 col-form-label">Nombre de Vacante</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="requisitos" class="col-sm-2 col-form-label">Requisitos</label>
                        <div class="col-sm-10">
                          <textarea class="form-control" id="requisitos" name="requisitos" placeholder="Ingresa los requisitos" rows="3"></textarea>
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="descripcion" class="col-sm-2 col-form-label">Descripción</label>
                        <div class="col-sm-10">
                          <textarea class="form-control" id="descripcion" name="descripcion" placeholder="Ingresa una descripción" rows="3"></textarea>
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="sueldo" class="col-sm-2 col-form-label">Sueldo</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="sueldo" name="sueldo" placeholder="Sueldo">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="horario" class="col-sm-2 col-form-label">Horario</label>
                        <div class="col-sm-10">
                        <select class="custom-select" name="horario">
                          <option selected>Escoger horario</option>
                          <option value=1>1-2 horas diarias</option>
                          <option value=2>2-3 horas diarias</option>
                          <option value=3>3-5 horas diarias</option>
                          <option value=4>3-8 horas diarias</option>    
                          <option value=5>8 horas Fin de Semana</option>    
                        </select>
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="tipo_de_contratacion" class="col-sm-2 col-form-label">Tipo de Contratación</label>
                        <div class="col-sm-10">
                        <select class="custom-select" name="tipo_contratacion">
                          <option selected>Escoger tipo de contratación</option>
                          <option value=1>Por horas</option>
                          <option value=2>Tiempo Completo</option>
                          <option value=3>Días no hábiles</option>    
                        </select>
                        </div>
                      </div>
                      <hr/>
                      <br/>
                      <div align="center">
                      	<p> Datos de Contacto </p>
                      </div>
                      <hr />
                      <br />
                      <div class="form-group row">
                        <label for="nombre_contacto" class="col-sm-2 col-form-label">Nombre</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="nombre_contacto" name="nombre_contacto" placeholder="Jefferson">
                        </div>
                      </div>  
                      <div class="form-group row">
                        <label for="apellido_p_contacto" class="col-sm-2 col-form-label">Apellido Paterno</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="apellido_p_contacto" name="apellido_p_contacto" placeholder="Apellido Paterno">
                        </div>
                      </div>   
                      <div class="form-group row">
                        <label for="apellido_m_contacto" class="col-sm-2 col-form-label">Apellido Materno</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="apellido_m_contacto" name=apellido_m_contacto placeholder="Apellido Paterno">
                        </div>
                      </div>                 
			  </div>
			  <div align="right"> 
			  <button type="submit" class="btn btn-primary">Agregar Vacante</button>
			  </div>
			</form>
        </div>
      </div>
    </div>
<!--End-Chart-box--> 
    <hr/>