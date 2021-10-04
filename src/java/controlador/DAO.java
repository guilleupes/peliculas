
package controlador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import modelo.Pelicula;
import java.util.ArrayList;

public class DAO {
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;
    
    private void conectar(){
        try{
            String parametros = "com.mysql.jdbc.Driver";
            Class.forName(parametros);
            String url = "jdbc:mysql://localhost:3306/bd4";
            con = DriverManager.getConnection(url,"root","");
        }catch(Exception e1){
            System.out.println("Error Al Conectar: " + e1.getMessage());
            System.exit(0);
        }
    }
    


    private void desconectar(){
        try{
            st.close();
            con.close();
        }catch(Exception e1){
            System.out.println("Error Al Desconectar: " + e1.getMessage());
            System.exit(0);
        }
    }
    
    
    public ArrayList<Pelicula> obtenerPeliculas(){
        ArrayList<Pelicula> listapel = null;
        try{
            conectar();
            st = con.createStatement();
            String sql = "select cod_pel, tit_pel, año_pel, nom_for, nom_gen from peliculas, formatos, generos where peliculas.cod_for=formatos.cod_for and peliculas.cod_gen=generos.cod_gen order by peliculas.cod_pel asc";
            rs = st.executeQuery(sql);
            listapel = new ArrayList <Pelicula>();
            while(rs.next()){
                Pelicula p = new Pelicula();
                p.setCodigo(rs.getInt("cod_pel"));
                p.setTitulo(rs.getString("tit_pel"));
                p.setAño(rs.getInt("año_pel"));
                p.setNomFormato(rs.getString("nom_for"));
                p.setNomGenero(rs.getString("nom_gen"));
                listapel.add(p);
            }
            desconectar();
        }catch(Exception e1){
            System.out.println("Error Obtener: " + e1.getMessage());
            System.exit(0);
        }
        return listapel;
    } // Cierra el metodo obtenerPeliculas.
    
    
    
    public boolean comprobarCodigo(int cod){
        try{
            conectar();
            st = con.createStatement();
            String sql = "select cod_pel from peliculas where cod_pel="+cod;
            rs = st.executeQuery(sql);
            if(rs.next()){
                desconectar();
                return true;
            }
            st.close();
            desconectar();
        }catch(Exception e1){
            System.out.println("Error Al Comprobar: " + e1.getMessage());
            System.exit(0);
        }
        return false;
    } // Cierra el metodo comprobarCodigo.
    
    
    
    public void eliminar(int cod){
        try{
            conectar();
            st = con.createStatement();
            String sql = "delete from peliculas where cod_pel="+cod;
            st.execute(sql);
            desconectar();
        }catch(Exception e1){
            System.out.println("Error Al Eliminar: " + e1.getMessage());
            System.exit(0);
        }
    } // Cierra el metodo eliminar.



    public String llenarGeneros(){
        String elementos = "";
        try{
            conectar();
            st = con.createStatement();
            String sql = "select * from generos order by nom_gen asc";
            rs = st.executeQuery(sql);
            while(rs.next()){
                int cod = rs.getInt("cod_gen");
                String nom = rs.getString("nom_gen");
                elementos += "<option value='"+cod+"'>"+nom+"</option>";
            }
            desconectar();
        }catch(Exception e1){
            System.out.println("Error Obtener Generos: " + e1.getMessage());
            System.exit(0);
        }
        return elementos;
    } // Cierra el metodo obtener Generos.
    
    
    public void agregarPelicula(Pelicula p){
        try{
            conectar();
            st = con.createStatement();
            String sql = "insert into peliculas values ("+p.getCodigo()+",'"+p.getTitulo()+"',"+p.getAño()+","+p.getCodFormato()+","+p.getCodGenero()+")";
            st.execute(sql);
            desconectar();
        }catch(Exception e1){
            System.out.println("Error Al Agregar: " + e1.getMessage());
            System.exit(0);
        }
    } // Cierra el metodo agregarPelicula.
    
    
    
} // Cierra la clase DAO.
