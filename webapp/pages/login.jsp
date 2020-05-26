			<section class="form-login">
			<div class="jumbotron">
				<h1 class="display-4">LOGIN</h1>
					<div class="alert alert-info" role="alert">
						${msgLogin}
					  <span class="badge badge-secondary">What?</span>¿Aún no tienes una cuenta? <a href="contacto" class="alert-link">Click aquí</a>. para poder obtener una cuenta
					</div>
		        <div class="alert alert-primary" role="alert">
				  <h4 class="alert-heading">Bienvenido!</h4>
				  <p>Debes rellenar los campos para poder conectarte!</p>
				  <hr>
						<form action="Login?action=authentication" method="post">
						  <div class="form-group">
						    <label for="clave">Clave</label>
						    <input type="text" class="form-control" id="clave" name="clave" placeholder="Ingresa tu clave">
						    <small id="claveHelp" class="form-text text-muted">Nunca compartiremos su correo clave con nadie más</small>
						  </div>
						  <div class="form-group">
						    <label for="password">Contraseña</label>
						    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
						  </div>
						  <div align="right">
						  	<button type="submit" class="btn btn-primary">Conectarse</button>
						  </div>
						</form>
						
						  <p>Si tienes dudas sobre nuestros servicios puedes contactarnos pulsando el botón de abajo!</p>
			  <hr class="my-4">
			  <p class="lead">
			    <a class="btn btn-primary btn-lg" href="#" role="button">Ir a soporte</a>
			  </p>
			  </div>
			</div>
			</section>