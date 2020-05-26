<%-- 
    Document   : registro_empresas
    Created on : 2 abr. 2020, 14:14:44
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
                    <form action="manageRegister?action=registerBusiness" method="post">
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
                        <label for="RFC" class="col-sm-2 col-form-label">RFC</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="RFC" name="RFC" placeholder="RFC">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="FAX" class="col-sm-2 col-form-label">FAX</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="FAX" name="FAX" placeholder="FAX">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="giro" class="col-sm-2 col-form-label">Giro</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="giro" name="giro" placeholder="Giro">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="descripcion" class="col-sm-2 col-form-label">Descripción</label>
                        <div class="col-sm-10">
                          <textarea class="form-control" id="descripcion" name="descripcion" placeholder="Esta empresa es..." rows="3"></textarea>
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="telefono" class="col-sm-2 col-form-label">Teléfono</label>
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
                      <div class="form-group row">
                        <label for="email" class="col-sm-2 col-form-label">Página Web</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="paginaweb" name="paginaweb" placeholder="https://wwww.example.com/">
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
                            <input type="text" class="form-control" id="Calle" name="Calle" placeholder="Calle" required>
                          </div>
                          <div class="col-md-6 mb-3">
                            <label for="ciudadoestado">Ciudad/Estado</label>
                            <input type="text" class="form-control" id="Ciudad" name="Ciudad" placeholder="Ciudad" required>
                          </div>
                          <div class="col-md-3 mb-3">
                            <label for="delomun">Delegacion o municipio</label>
                            <input type="text" class="form-control" id="DeloMun" name="DeloMun" placeholder="Del o Mun" required>
                          </div>
                          <div class="col-md-3 mb-3">
                            <label for="cp">Código Postal</label>
                            <input type="text" class="form-control" id="CP" name="CP" placeholder="CP" required>
                          </div>
                          <div class="col-md-3 mb-3">
                            <label for="numero_exterior">Número Exterior</label>
                            <input type="text" class="form-control" id="numero_ext" name="numero_ext" placeholder="11" required>
                          </div>
                          <div class="col-md-3 mb-3">
                            <label for="numero_interior">Número Interior</label>
                            <input type="text" class="form-control" id="numero_int" name="numero_int" placeholder="12" required>
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