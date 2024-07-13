package LiterAlura_AT.com.alura.challege.literalura.principal;

import LiterAlura_AT.com.alura.challege.literalura.model.Datos;
import LiterAlura_AT.com.alura.challege.literalura.model.DatosLibro;
import LiterAlura_AT.com.alura.challege.literalura.service.ConsumoAPI;
import LiterAlura_AT.com.alura.challege.literalura.service.ConvierteDatos;

import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner keyboard = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/";
    private ConvierteDatos conversor = new ConvierteDatos();

    public void verElMenu(){

        var opcion = -1;
        while (opcion !=0){
            var menu = """
                    Bienvenido/a, ¿Qué te gustaria realizar hoy?
                    1 - Buscar libros por nombre
                    2 - Buscar libros por fecha de inicio y fin
                    3 - Buscar libros por derechos de autor
                    4 - Buscar libros por categoria
                    5 - Mostrar libros buscados
                    
                    0 - Salir de la aplicación
                    """;
            System.out.println(menu);
            opcion = keyboard.nextInt();
            keyboard.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibrosPorNombre();
                    //pruebaAPI();
                    break;
                case 2:

                    break;
                case 0:
                    System.out.println("Cerrando la aplicación, hasta luego :D");
                    break;
                default:
                    System.out.println("La opción seleccionada no es valida");
            }
        }
    }

    private void pruebaAPI(){
        System.out.println("Prueba API");
        var json = consumoApi.obtenerDatos(URL_BASE);
        System.out.println(json);
    }

    private void buscarLibrosPorNombre(){
        System.out.println("Ingrese el nombre del libro que desee buscar");
        var nombreLibro = keyboard.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE+"?search="+nombreLibro.replace(" ", "+"));
        var resultadoBusqueda = conversor.obtenerDatos(json, Datos.class);
        //System.out.println(resultadoBusqueda);
        Optional<DatosLibro> libroBuscado = resultadoBusqueda.resultados().stream()
                .filter(l->l.titulo().toUpperCase().contains(nombreLibro.toUpperCase()))
                .findFirst();
        if(libroBuscado.isPresent()){
            System.out.println("Libro encontrado");
            System.out.println(libroBuscado.get());
        }else{
            System.out.println("No se encontro el libro");
        }

    }

    private void buscarLibrosPorFecha(){

    }

    private void buscarLibrosPorDerechosDeAutor(){

    }

    private void buscarLibrosPorCategoria(){

    }

    private void mostrarLibrosPorCategoria(){
        
    }


}
