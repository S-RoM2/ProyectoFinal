<!--Chart-box-->    
    <div class="row-fluid">
      <div class="widget-box">
        <div class="widget-title bg_lg"><span class="icon"><i class="icon-signal"></i></span>
          <h5>Cambiar Teléfono</h5>
        </div>
        ${msg}
        <div class="widget-content" >
			<form action="Login?action=Changephone" method="post">
			  <div class="form-group">
			    <label for="telefono">Teléfono</label>
			    <input type="text" class="form-control" id="telefono" name="telefono" placeholder="5589678545">
			  </div>
			  <button type="submit" class="btn btn-primary">Cambiar Teléfono</button>
			</form>
        </div>
      </div>
    </div>
<!--End-Chart-box--> 
    <hr/>