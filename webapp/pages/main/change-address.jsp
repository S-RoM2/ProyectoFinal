<!--Chart-box-->    
    <div class="row-fluid">
      <div class="widget-box">
        <div class="widget-title bg_lg"><span class="icon"><i class="icon-signal"></i></span>
          <h5>Cambiar Direcci�n</h5>
        </div>
        ${msg}
        <div class="widget-content" >
			<form action="Login?action=ChangeAddress" method="post">
			  <div class="form-group">
                        <div class="form-row">
                          <div class="col-md-6 mb-3">
                            <label for="ciudadoestado">Calle</label>
                            <input type="text" class="form-control" id="Calle" name="Calle" value="${dataAccount.GetCalle()}" required>
                          </div>
                          <div class="col-md-6 mb-3">
                            <label for="ciudadoestado">Ciudad/Estado</label>
                            <input type="text" class="form-control" id="Ciudad" name="Ciudad" value="${dataAccount.GetCiudad()}" required>
                          </div>
                          <div class="col-md-3 mb-3">
                            <label for="delomun">Delegacion o municipio</label>
                            <input type="text" class="form-control" id="DeloMun" name="DeloMun" value="${dataAccount.GetDeloMun()}" required>
                          </div>
                          <div class="col-md-3 mb-3">
                            <label for="cp">C�digo Postal</label>
                            <input type="text" class="form-control" id="CP" name="CP" value="${dataAccount.GetCP()}" required>
                          </div>
                          <div class="col-md-3 mb-3">
                            <label for="numero_exterior">N�mero Exterior</label>
                            <input type="text" class="form-control" id="numero_ext" name="numero_ext" value="${dataAccount.GetNumero_Int()}" required>
                          </div>
                          <div class="col-md-3 mb-3">
                            <label for="numero_interior">N�mero Interior</label>
                            <input type="text" class="form-control" id="numero_int" name="numero_int" value="${dataAccount.GetNumero_Ext()}" required>
                          </div>
                        </div>
			  </div>
			  <button type="submit" class="btn btn-primary">Cambiar Direcci�n</button>
			</form>
        </div>
      </div>
    </div>
<!--End-Chart-box--> 
    <hr/>