<!--Chart-box-->    
    <div class="row-fluid">
      <div class="widget-box">
        <div class="widget-title bg_lg"><span class="icon"><i class="icon-signal"></i></span>
          <h5>Cambiar Descripci�n</h5>
        </div>
        ${msg}
        <div class="widget-content" >
			<form action="Login?action=Changedescription" method="post">
			  <div class="form-group">
			    <label for="descripcion">Descripci�n</label>
			    <input type="text" class="form-control" id="descripcion" name="descripcion" placeholder="La empresa es...">
			  </div>
			  <button type="submit" class="btn btn-primary">Cambiar Descripci�n</button>
			</form>
        </div>
      </div>
    </div>
<!--End-Chart-box--> 
    <hr/>