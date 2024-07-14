package LiterAlura_AT.com.alura.challege.literalura.model;

public enum CategoriaLibros {
    ACCION("Action"),
    ROMANCE("Romance"),
    COMEDIA("Comedy"),
    DRAMA("Drama"),
    CRIMEN("Crime"),
    NIÑOS("Childen");

    private String categoriaBook;
    CategoriaLibros(String categoriaBook){
        this.categoriaBook = categoriaBook;
    }

    public static CategoriaLibros fromString(String text){
        for(CategoriaLibros categoria : CategoriaLibros.values()){
            if(categoria.categoriaBook.equalsIgnoreCase(text)){
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: "+text);
    }
}
