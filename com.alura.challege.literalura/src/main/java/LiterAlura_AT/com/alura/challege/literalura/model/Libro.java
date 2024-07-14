package LiterAlura_AT.com.alura.challege.literalura.model;

import java.util.ArrayList;
import java.util.List;

public class Libro {
    private String titulo;
    private String derechosDeAutor;
    private Double descargas;
    private List<Autor> autor = new ArrayList<>();
   // private List<String> idiomas;

    public Libro(DatosLibro datosLibro){
        this.titulo = datosLibro.titulo();

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }

    public String getDerechosDeAutor() {
        return derechosDeAutor;
    }

    public void setDerechosDeAutor(String derechosDeAutor) {
        this.derechosDeAutor = derechosDeAutor;
    }

    public Double getDescargas() {
        return descargas;
    }

    public void setDescargas(Double descargas) {
        this.descargas = descargas;
    }
}
