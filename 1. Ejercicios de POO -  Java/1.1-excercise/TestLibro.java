import java.util.ArrayList;
import java.util.Arrays;

public class Libro{
    private String nombre;
    private int fecha_publicacion;
    private String editorial;
    private String [] autores;
    
    public Libro(String nombre, int fecha_publicacion, String editorial, String[] autores) {
        this.nombre = nombre;
        this.fecha_publicacion = fecha_publicacion;
        this.editorial = editorial;
        this.autores = autores;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getFecha_publicacion() {
        return fecha_publicacion;
    }
    public void setFecha_publicacion(int fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }
    public String getEditorial() {
        return editorial;
    }
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    public String[] getAutores() {
        return autores;
    }
    public void setAutores(String[] autores) {
        this.autores = autores;
    }
}

public class TestLibro {
    public static void main(String[] args) throws Exception {
        String autores1 [] = {"Carlos Ruiz Zafon"};
        Libro libro1 = new Libro("Marina", 2000 , "bucklet", autores1);
        String autores2 [] = {"Isaac Asimov","Joshua"};
        Libro libro2 = new Libro("Hombre bicentenario", 1980 , "de bolsillo", autores2);
        String autores3 [] = {"Gabriel Marquez","Isabella", "Juan"};
        Libro libro3 = new Libro("100 años de soledad", 1975 , "gran colombiano", autores3);
        String autores4 [] = {"Carlos Ruiz Zafon"};
        Libro libro4 = new Libro("Principito", 1950 , "alemana big", autores4);
        String autores5 [] = {"Carlos Ruiz Zafon"};
        Libro libro5 = new Libro("Juego del angel", 1980 , "dragon", autores5);

        //Si hay dos libros con un mismo autor
        boolean mismoAutor = false; 
        ArrayList <String> librosIguales = new ArrayList<String>();                           
        Libro lista [] = {libro1,libro2,libro3,libro4,libro5};
        for(int i = 0 ; i < lista.length - 1; i++){
            for(int j = i+1 ; j < lista.length ; j++){
                for(String autor: lista[i].getAutores()){
                    for(String autor2: lista[j].getAutores()){
                        System.out.println(autor + " comparar con " + autor2);
                        if (autor == autor2){
                            mismoAutor = true;
                            librosIguales.add(lista[i].getNombre() + " tiene el mismo autor que " + lista[j].getNombre());
                        }
                    }
                }
            }
        }
        System.out.println(mismoAutor? "verdad": "mentira");
        System.out.println(Arrays.toString(librosIguales.toArray()));

        //DIFERENCIA AÑOS
        boolean diferencia = false;
        for(int i = 0 ; i < lista.length - 1; i++){
            for(int j = i+1 ; j < lista.length ; j++){
                if(Math.abs(lista[i].getFecha_publicacion()-lista[j].getFecha_publicacion()) > 10){
                    diferencia = true;
                }
            }
        }

        System.out.println(diferencia? "mucha": "poquita");

        //ultimo caracter
        for(int i = 0 ; i < lista.length; i++){
            String primeraFecha = lista[i].getFecha_publicacion() +"";
            char ultimoDigito1 = primeraFecha.toCharArray()[primeraFecha.length()-1];            
            System.out.println(ultimoDigito1);
        }

    }
}
