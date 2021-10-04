
<%@page import="controlador.DAO"%>
<%@page import="modelo.Pelicula"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <html>
    <head>
      <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>

    <body>
        
        
        <div class="container">
            <h4><a href="index.jsp">Volver Al Index</a></h4>
            
            <div class="row" style="margin:0px">
                <div class="col s8" style="margin:0px">
                    <h4>Listado De Peliculas</h4>
                </div>
            </div>
            <div class="row" style="margin:0px">
                <div class="col s8" style="margin:0px">
                    <table class="bordered highlight">
                        <thead>
                            <tr>
                                <th>CODIGO</th>
                                <th>TITULO</th>
                                <th>AÑO</th>
                                <th>FORMATO</th>
                                <th>GENERO</th>
                                <th>ELIMINAR</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                DAO d = new DAO();
                                ArrayList <Pelicula> listapel = d.obtenerPeliculas();
                                for (Pelicula p : listapel) {
                                    out.println("<tr>");
                                        out.println("<td>"+p.getCodigo()+"</td>");
                                        out.println("<td>"+p.getTitulo()+"</td>");
                                        out.println("<td>"+p.getAño()+"</td>");
                                        out.println("<td>"+p.getNomFormato()+"</td>");
                                        out.println("<td>"+p.getNomGenero()+"</td>");
                                        out.println("<td><a href='eliminar.do?cod="+p.getCodigo()+"'>Click Aqui</a></td>");
                                    out.println("</tr>");
                                }
                            %>
                        </tbody>
                    </table>
                    
                    <%
                        if(request.getParameter("ok") != null){
                            String ok = request.getParameter("ok");
                            out.println("<h5><font color='green'>"+ok+"</font></h5>");
                        }
                        
                        if(request.getParameter("error") != null){
                            String error = request.getParameter("error");
                            out.println("<h5><font color='red'>"+error+"</font></h5>");
                        }
                    %>
                </div>
            </div>
        </div>
        
      <!--Import jQuery before materialize.js-->
      <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.min.js"></script>
    </body>
  </html>