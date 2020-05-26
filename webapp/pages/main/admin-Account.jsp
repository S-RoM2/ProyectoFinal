		${msg}
						<form action="Login?action=RegistAccount" method="post">
						  <div class="form-group">
						    <label for="clave">Clave</label>
						    <input type="text" class="form-control" id="clave" name="clave" placeholder="Ingresa la clave">
						    <small id="claveHelp" class="form-text text-muted">Nunca compartiremos su correo clave con nadie más</small>
						  </div>
						  <div class="form-group">
						    <label for="password">Contraseña</label>
						    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
						  </div>
                     <div class="form-group row">
                        <label for="nivel_estudios" class="col-sm-2 col-form-label">Tipo de Cuenta</label>
                        <div class="col-sm-10">
                        <select class="custom-select" name="tipo">
                          <option selected value=0>Selecciona el tipo</option>
                          <option value=1>Estudiante</option>
                          <option value=2>Empresa</option>
                        </select>
                        </div>
                      </div> 
						  <div align="right">
						  	<button type="submit" class="btn btn-primary">Registrar Cuenta</button>
						  </div>
						</form>