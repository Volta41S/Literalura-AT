package LiterAlura_AT.com.alura.challege.literalura.principal;

import LiterAlura_AT.com.alura.challege.literalura.model.Datos;
import LiterAlura_AT.com.alura.challege.literalura.model.DatosLibro;
import LiterAlura_AT.com.alura.challege.literalura.service.ConsumoAPI;
import LiterAlura_AT.com.alura.challege.literalura.service.ConvierteDatos;

import java.net.URL;
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
                    buscarLibrosPorFecha();
                    break;
                case 3:
                    selectorDerechosAutor();
                    break;
                case 4:
                    buscarLibrosPorCategoria();
                    break;
                case 5:
                    mostrarLibrosbuscadospornombre();
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
        System.out.println("Ingrese el periodo en el que quiere buscar:");
        System.out.println("Inserte el año inicial");
        var fechaInicial = keyboard.nextInt();
        System.out.println("Inserte el año final");
        var fechaFinal = keyboard.nextInt();
        var json = consumoApi.obtenerDatos(URL_BASE+"?author_year_start="+fechaInicial+"&author_year_end="+fechaFinal);
        var resultadoBusqueda = conversor.obtenerDatos(json, Datos.class);
        System.out.println(resultadoBusqueda);
    }

    private void selectorDerechosAutor(){
        var opcionDerecho = -1;
        var derechoAutor="";
        var menuDos = """
                Seleccione alguna de las siguientes opciones
                1 - Libros con derechos de autor
                2 - Libros sin derecho de autor
                3 - Regresar atras
                """;
        System.out.println(menuDos);
        opcionDerecho = keyboard.nextInt();
        switch(opcionDerecho){
            case 1:
                derechoAutor = "true";
                buscarLibrosPorDerechosDeAutor(derechoAutor);
                break;
            case 2:
                derechoAutor = "false";
                buscarLibrosPorDerechosDeAutor(derechoAutor);
                break;
            case 3:
                verElMenu();
                break;
            default :
                System.out.println("Opcion no valida");
        }
    }

    private void buscarLibrosPorDerechosDeAutor(String busquedaDerecho){
        var json = consumoApi.obtenerDatos(URL_BASE + "?copyright=" + busquedaDerecho);
        var resultadoBusqueda = conversor.obtenerDatos(json, Datos.class);
        System.out.println(resultadoBusqueda);
    }

    private void buscarLibrosPorCategoria(){
        System.out.println("Ingrese la cateogria que desea buscar:");
        var busquedaCategoria = keyboard.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE+"topic"+busquedaCategoria);
        var resultadoBusqueda = conversor.obtenerDatos(json, Datos.class);
        System.out.println(resultadoBusqueda);
    }

    private void mostrarLibrosbuscadospornombre(){
        
    }


}
