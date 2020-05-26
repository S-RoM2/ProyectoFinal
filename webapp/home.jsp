<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

       <section class="content-section">
            <div class="inter"></div>
            <h1>Busca un trabajo a tu comodidad...</h1>
            <div class="contenedor-search">
            <section class="search-job">
                <br>
                <form class="needs-validation" novalidate>
                  <div class="form-row">
                    <div class="col-md-4 mb-3">
                      <label for="validationTooltip01">Tipo de Trabajo</label>
                      <input type="text" class="form-control" id="validationTooltip01" placeholder="Tipo de trabajo" required>
                    </div>
                    <div class="col-md-4 mb-3">
                      <label for="validationTooltip02">Horario</label>
                        <select class="custom-select">
                          <option selected>Escoger horario</option>
                          <option value="1">1-2 horas diarias</option>
                          <option value="2">2-3 horas diarias</option>
                          <option value="3">3-5 horas diarias</option>
                          <option value="4">3-8 horas diarias</option>    
                          <option value="4">8 horas Fin de Semana</option>    
                        </select>
                    </div>
                    <div class="col-md-4 mb-3">
                      <label for="validationTooltipUsername">Empresa</label>
                      <div class="input-group">
                        <div class="input-group-prepend">
                          <span class="input-group-text" id="validationTooltipUsernamePrepend">@</span>
                        </div>
                        <input type="text" class="form-control" id="validationTooltipUsername" placeholder="Company" aria-describedby="validationTooltipUsernamePrepend" required>
                      </div>
                    </div>
                  </div>
                  <div class="form-row">
                    <div class="col-md-6 mb-3">
                      <label for="validationTooltip03">Ubicación de Trabajo</label>
                      <input type="text" class="form-control" id="validationTooltip03" placeholder="Ciudad" required>
                    </div>
                    <button class="btn-gradient-porpuse-2" type="submit">Buscar ahora</button>

                  </div>
                </form>
            </section>
                </div>
            <hr>
            <section class="selection-web">
                <br>
                <h1 class="title">¿Por qué elegir nuestra Web?</h1>
                <br>
                <p class="text"> Nuestra Web es muy segura y te proveerá de muchas facilidades con<br>
                    respecto a todas los nuevos empleos existentes en el mercado. Además <br>
                    somos la elección preferida de casi todas las empresas en el país, <br>
                    por lo que si quieres trabajo, nuestra plataforma es la ideal</p>
                <br>
                <button class="btn-gradient-porpuse-radius" type="submit">Registro ahora</button>
            </section>
        </section>