
<%@page import="controlador.DAO"%>
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
                <div class="col s6" style="margin:0px">
                    <h4>Registro De Peliculas</h4>
                </div>
            </div>
            <form action="procesar.do" method="post">
                <div class="row" style="margin:0px">
                    <div class="col s6 input-field" style="margin:0px">
                        <i class="material-icons prefix">vpn_key</i>
                        <input type="number" name="txtcod" id="txtcod" min="1" max="99999"/>
                        <label for="txtcod">Ingrese El Código</label>
                    </div>
                </div>
                <div class="row" style="margin:0px">
                    <div class="col s6 input-field" style="margin:0px">
                        <i class="material-icons prefix">comment</i>
                        <input type="text" name="txttit" id="txttit" maxlength="100"/>
                        <label for="txttit">Ingrese El Titulo</label>
                    </div>
                </div>
                <div class="row" style="margin:0px">
                    <div class="col s6 input-field" style="margin:0px">
                        <i class="material-icons prefix">date_range</i>
                        <input type="number" name="txtyea" id="txtpre" min="1920" max="2021"/>
                        <label for="txtyea">Ingrese El Año</label>
                    </div>
                </div>
                <div class="row" style="margin:0px">
                    <div class="col s1"><i class="material-icons prefix">info</i></div>
                    <div class="col s5">
                        <fieldset>
                            <legend>Formato</legend>
                            <input type="radio" name="opfor" id="opfor1" value="1" checked=""/>
                            <label for="opfor1">Dvd</label>
                            <input type="radio" name="opfor" id="opfor2" value="2"/>
                            <label for="opfor2">Bluray</label>
                        </fieldset>
                    </div>
                </div>
                <div class="row" style="margin:0px">
                    <div class="input-field col s6 input-field">
                        <i class="material-icons prefix">add_box</i>
                        <select id="cboest" name="cbogen">
                            <option value="">Seleccione Un Genero</option>
                            <%
                                DAO d = new DAO();
                                out.println(d.llenarGeneros());
                            %>
                        </select>
                    </div>
                </div>
                <div class="row" style="margin:0px">
                    <div class="col s6" style="margin:0px">
                        <button class="btn waves-effect waves-light" name="btnalm" type="submit">Almacenar
                            <i class="material-icons right">save</i>
                        </button>
                        <button class="btn waves-effect waves-light" name="btnres" type="reset">Restablecer
                            <i class="material-icons right">cloud</i>
                        </button>
                    </div>
                </div>
            </form>
            
            <%
                if (request.getParameter("ok") != null) {
                    String ok = request.getParameter("ok");
                    out.println("<h5><font color='green'>" + ok + "</font></h5>");
                }

                if (request.getAttribute("listaerr") != null) {
                    ArrayList<String> listaerr = (ArrayList<String>) request.getAttribute("listaerr");
                    for (String item : listaerr) {
                        out.println("<h5><font color='red'>" + item + "</font></h5>");
                    }
                }
            %>
        </div>
        
      <!--Import jQuery before materialize.js-->
      <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.min.js"></script>
      
      <script type="text/javascript">
          $(document).ready(function() {
            $('select').material_select();
          });
      </script>
    
    </body>
  </html>