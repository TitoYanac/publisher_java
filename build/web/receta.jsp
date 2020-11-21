<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<jsp:include page="home_header.jsp" /> 

        <div class="center">
            <section id="content">

                   <h1 class="subheader">Receta Digital</h1>

                   <form class="mid-form" id="formulario"  action="Servlet_mensajes">
                        <div class="form-group">
                            <label for="fecha">Fecha de Prescripción</label>
                            <input type="text" name="fecha" id="campo_fecha" />
                        </div>
                        <div class="form-group">
                            <label for="med">Nombre del Médico</label>
                            <input type="text" name="med" id="campo-med" />
                        </div>
                        <div class="form-group">
                            <label for="nombre">Nombre Paciente</label>
                            <input type="text" name="nombre" id="campo-nombre" />
                        </div>

                        <div class="form-group">
                            <label for="apellidos">Apellido Paciente</label>
                            <input type="text" name="apellido" id="campo-apellido" />
                        </div>
                        <div class="form-group">
                            <label for="email">DNI Paciente</label>
                            <input type="text" name="dni" id="campo-dni" />
                        </div>
                        <div class="form-group">
                            <label for="medicamento">Medicamento</label>
                            <input type="text" name="medicamento" id="campo-medicamento" />
                        </div>
                        <div class="form-group">
                            <label for="cantidad">Cantidad</label>
                            <input type="text" name="cantidad" id="campo-cantidad" />
                        </div>                        
                       <div class="form-group">
                            <label for="Indicaciones">Indicaciones</label>
                            <textarea name="indicaciones" id="indicaciones"></textarea>
                        </div>                        

                        <div class="clearfix"></div>

                        <button type="submit" name="enviar" class="btn btn-success">ENVIAR</button>
                   </form>
                
            </section>
            <aside id="sidebar">               
                    <img src="assets/images/logo.svg" class="app-img" alt="img-aside" id="img1" />                
                
            </aside>
            <div class="clearfix"></div>
        </div>        
        <jsp:include page="home_footer.jsp" /> 