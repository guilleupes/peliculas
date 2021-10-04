
package controlador;
import modelo.Pelicula;
import java.util.ArrayList;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletProcesar", urlPatterns = {"/procesar.do"})
public class ServletProcesar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        ArrayList<String> listaerr = new ArrayList<String> ();
        
        try{
            request.setCharacterEncoding("UTF-8");
            if(request.getParameter("btnalm") != null){
                String codt   = request.getParameter("txtcod");
                String tit = request.getParameter("txttit");
                String yeat   = request.getParameter("txtyea");
                String fort   = request.getParameter("opfor");
                String gent   = request.getParameter("cbogen");
                int cod = 0;
                int yea = 0;
                int forn  = 0;
                int gen = 0;
                DAO d = new DAO();
                
                try{
                    if(codt.isEmpty()){
                        listaerr.add("El Codigo No Debe Quedar En Blanco.");
                    }else{
                        cod = Integer.parseInt(codt);
                        if(cod<1 || cod>99999){
                            listaerr.add("El Codigo Debe Tener Entre 1 y 5 Numeros.");
                        }else if(d.comprobarCodigo(cod)){
                            listaerr.add("El Codigo "+cod+" Ya Existe.");
                        }
                    }
                }catch(Exception e1){
                    listaerr.add("El Codigo Debe Tener Hasta 5 Numeros.");
                }
                
                
                try{
                    if(tit.trim().isEmpty()){
                        listaerr.add("El Titulo No Debe Quedar En Blanco.");
                    }else if(tit.length()>100){
                        listaerr.add("El Titulo No Debe Superar Los 100 Caracteres.");
                    }
                }catch(Exception e1){
                    listaerr.add("El Titulo Es Requerido.");
                }
                    
                    
                try{
                    if(yeat.trim().isEmpty()){
                        listaerr.add("El Año No Debe Quedar En Blanco.");
                    }else{
                        yea = Integer.parseInt(yeat);
                        if(yea<1920 || yea>2021){
                            listaerr.add("El Año Debe Estar Entre 1920 y 2021.");
                        }
                    }
                }catch(Exception e1){
                    listaerr.add("El Año Debe Estar Entre 1920 y 2021 (Solo Numeros).");
                }
                
                
                
                try{
                    if(fort.trim().isEmpty()){
                        listaerr.add("El Formato No Debe Quedar En Blanco.");
                    }else{
                        forn = Integer.parseInt(fort);
                        if(forn!=1 && forn!=2){
                            listaerr.add("Error De Opcion En El Formato (1 o 2).");
                        }
                    }
                }catch(Exception e1){
                    listaerr.add("El Formato Es Requerido (1 o 2).");
                }
                
                
                
                try{
                    if(gent.trim().isEmpty()){
                        listaerr.add("Seleccione Una Opcion De Genero.");
                    }else{
                        gen = Integer.parseInt(gent);
                    }
                }catch(Exception e1){
                    listaerr.add("El Genero Es Requerido.");
                }
                
                
                if(listaerr.isEmpty()){
                    //Pelicula p = new Pelicula(cod,tit,yea,fo,gen);
                    Pelicula p = new Pelicula();
                    p.setCodigo(cod);
                    p.setTitulo(tit);
                    p.setAño(yea);
                    p.setCodFormato(forn);
                    p.setCodGenero(gen);
                    d.agregarPelicula(p);
                    String ok = "Pelicula "+cod+" Agregada Correctamente.";
                    response.sendRedirect("Form_Agregar.jsp?ok="+ok);
                }else{
                    request.setAttribute("listaerr", listaerr);
                    request.getRequestDispatcher("Form_Agregar.jsp").forward(request, response);
                }
                
                
            }else{
                listaerr.add("Debe Presionar El Boton Del Formulario.");
                request.setAttribute("listaerr", listaerr);
                request.getRequestDispatcher("Form_Agregar.jsp").forward(request, response);
            }
        }catch(Exception e1){
            listaerr.add(e1.getMessage());
            request.setAttribute("listaerr", listaerr);
            request.getRequestDispatcher("Form_Agregar.jsp").forward(request, response);
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
