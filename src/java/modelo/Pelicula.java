
package modelo;

public class Pelicula {
    private int codigo;
    private String titulo;
    private int año;
    private int codFormato;
    private String nomFormato;
    private int codGenero;
    private String nomGenero;

    public Pelicula() {
    }

    // Constructor para hacer los inserts en la tabla Peliculas.
    public Pelicula(int codigo, String titulo, int año, int codFormato, int codGenero) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.año = año;
        this.codFormato = codFormato;
        this.codGenero = codGenero;
    }

    // Constructor para hacer el listado de peliculas.
    public Pelicula(int codigo, String titulo, int año, String nomFormato, String nomGenero) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.año = año;
        this.nomFormato = nomFormato;
        this.nomGenero = nomGenero;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAño() {
        return año;
    }

    public int getCodFormato() {
        return codFormato;
    }

    public String getNomFormato() {
        return nomFormato;
    }

    public int getCodGenero() {
        return codGenero;
    }

    public String getNomGenero() {
        return nomGenero;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setCodFormato(int codFormato) {
        this.codFormato = codFormato;
    }

    public void setNomFormato(String nomFormato) {
        this.nomFormato = nomFormato;
    }

    public void setCodGenero(int codGenero) {
        this.codGenero = codGenero;
    }

    public void setNomGenero(String nomGenero) {
        this.nomGenero = nomGenero;
    }
    
}
