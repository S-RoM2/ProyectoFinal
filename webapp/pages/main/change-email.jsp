<!--Chart-box-->    
    <div class="row-fluid">
      <div class="widget-box">
        <div class="widget-title bg_lg"><span class="icon"><i class="icon-signal"></i></span>
          <h5>Cambiar Email</h5>
        </div>
        ${msg}
        <div class="widget-content" >
			<form action="Login?action=Changeemail" method="post">
			  <div class="form-group">
			    <label for="email">Email</label>
			    <input type="text" class="form-control" id="email" name="email" placeholder="example@example.com">
			  </div>
			  <button type="submit" class="btn btn-primary">Cambiar Email</button>
			</form>
        </div>
      </div>
    </div>
<!--End-Chart-box--> 
    <hr/>