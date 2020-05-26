<%-- 
    Document   : registro
    Created on : 31 mar. 2020, 20:32:58
    Author     : rober
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/home.css">
        <link rel="stylesheet" type="text/css" href="css/main-sup.css">
        <title>Bolsa de Trabajo</title>
    </head>
    <body>
        <jsp:include page="pages/navindex.jsp"></jsp:include>
        <section class="content-section">
                <section class="form-register">
                    <h3>Registra tu cuenta</h3>
					  ${msg}
                    <br>
                    <form action="manageRegister?action=registerStudent" method="post">
                        <hr>
                                                <br>
                        <p>Campos de Personales</p>
                        <hr>
                                                <br>
                      <div class="form-group row">
                        <label for="clave" class="col-sm-2 col-form-label">Clave</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="clave" name="clave" placeholder="Clave">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="password" class="col-sm-2 col-form-label">Password</label>
                        <div class="col-sm-10">
                          <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="apellido_p" class="col-sm-2 col-form-label">Apellido Paterno</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="apellido_p" name="apellido_p" placeholder="Apellido Paterno">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="apellido_m" class="col-sm-2 col-form-label">Apellido Materno</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="apellido_m" name="apellido_m" placeholder="Apellido Materno">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="telefono" class="col-sm-2 col-form-label">Telefono</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="telefono" name="telefono" placeholder="55 12 34 35 67">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="email" class="col-sm-2 col-form-label">Email</label>
                        <div class="col-sm-10">
                          <input type="email" class="form-control" id="email" name="email" placeholder="email@ejemplo.com">
                        </div>
                      </div>
                        <hr>
                                                <br>
                        <p>Campos de Dirección</p>
                        <hr>
                        <br>
                        <div class="form-row">
                          <div class="col-md-6 mb-3">
                            <label for="ciudadoestado">Calle</label>
                            <input type="text" class="form-control" id="calle" name="calle" placeholder="Calle" required>
                          </div>
                          <div class="col-md-6 mb-3">
                            <label for="ciudadoestado">Ciudad/Estado</label>
                            <input type="text" class="form-control" id="ciudad" name="ciudad" placeholder="Ciudad" required>
                          </div>
                          <div class="col-md-3 mb-3">
                            <label for="delomun">Delegacion o municipio</label>
                            <input type="text" class="form-control" id="delomun" name="delomun" placeholder="Del o Mun" required>
                          </div>
                          <div class="col-md-3 mb-3">
                            <label for="cp">Código Postal</label>
                            <input type="text" class="form-control" id="cp" name="cp" placeholder="CP" required>
                          </div>
                          <div class="col-md-3 mb-3">
                            <label for="numero_interior">Número Interior</label>
                            <input type="text" class="form-control" id="numero_interior" name="numero_interior" placeholder="12" required>
                          </div>
                          <div class="col-md-3 mb-3">
                            <label for="numero_exterior">Número Exterior</label>
                            <input type="text" class="form-control" id="numero_exterior" name="numero_exterior" placeholder="11" required>
                          </div>
                        </div>
                      <div class="form-group row">
                        <div class="col-sm-10">
                            <div class="centrado">
                            <button type="submit" class="btn-gradient-porpuse-register">Registrarse</button>
                            </div>
                        </div>
                      </div>
                   </form>
              </section>
        </section>
        <jsp:include page="pages/footer.jsp"></jsp:include>
    </body>
</html>
