<jsp:include page="home_header.jsp" /> 
        <div id="slider" class="slider-big">            
            <h1>Bienvenido a Clinica San Marcos</h1>            
            <!--<a href="#" class="btn-white">Iniciar Sesión</a>-->
        </div>

        <div class="center">
            <section id="content">
                <h2 class="subheader" >Lista de Pacientes en Espera</h2>
                
                <%
                for(int i = 1; i <= 5; i++){
                %>
                <!--Listado articulos-->
                <div id="articles">
                    <article class="article-item" id="article-template">
                        <div class="image-wrap">
                            <img src="assets/images/texto.jpg" alt="Artículo" />
                        </div>
    
                        <h2>Nombre de Paciente <%=i%></h2>
                        <span class="date">
                            Hace <%=i+10%> minutos
                        </span>
                        <a href="historial.jsp">Ver historia</a>

                        <div class="clearfix"></div>
                    </article>                

                </div>
                <%
                }
                %>
            </section>

            <aside id="sidebar">

                <div id="search" class="sidebar-item">
                        <h3>Buscador</h3>
                        <p>Ingresa nombre del Paciente </p>
                        <form>
                            <input type="text" name="search" />
                            <input type="submit" name="submit" value="Buscar" class="btn" />
                        </form>
                </div>
            </aside>

            <div class="clearfix"></div>
        </div>

        <jsp:include page="home_footer.jsp" /> 