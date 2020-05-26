<!--Chart-box-->    
    <div class="row-fluid">
      <div class="widget-box">
        <div class="widget-title bg_lg"><span class="icon"><i class="icon-signal"></i></span>
          <h5>Cambiar contraseña</h5>
        </div>
        ${msg}
        <div class="widget-content" >
			<form action="Login?action=ChangePassword" method="post">
			  <div class="form-group">
			    <label for="password">Password</label>
			    <input type="password" class="form-control" id="password" name="password" placeholder="password">
			  </div>
			  <button type="submit" class="btn btn-primary">Cambiar contraseña</button>
			</form>
        </div>
      </div>
    </div>
<!--End-Chart-box--> 
    <hr/>