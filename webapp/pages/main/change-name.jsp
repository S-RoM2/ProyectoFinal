<!--Chart-box-->    
    <div class="row-fluid">
      <div class="widget-box">
        <div class="widget-title bg_lg"><span class="icon"><i class="icon-signal"></i></span>
          <h5>Nombre</h5>
        </div>
        ${msg}
        <div class="widget-content" >
			<form action="Login?action=Changename" method="post">
			  <div class="form-group">
			    <label for="nombre">Nombre</label>
			    <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Jefferson Gutierritos">
			  </div>
			  <button type="submit" class="btn btn-primary">Cambiar Nombre</button>
			</form>
        </div>
      </div>
    </div>
<!--End-Chart-box--> 
    <hr/>