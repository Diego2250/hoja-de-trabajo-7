/**
 * Main
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan= new Scanner(System.in);
        Actions a =new Actions(); 
        a.separar();
        a.createArboles();
        byte opcion=0; 
        boolean salir=false; 
        while (salir!=true){
            String s="\nIngrese la opción que desea utilizar: \n" +
            "1. Traducir un archivo\n" +
            "2. Agregar una palabra\n" +
            "3. Imprimir diccionario frances\n"+
            "4. Imprimir diccionario ingles\n"+
            "5. Salir";
            System.out.println(s);
            opcion=scan.nextByte(); 
            scan.nextLine(); 
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del archivo para traducir");
                    String nombre=scan.nextLine(); 
                    a.Translate(nombre);
                    break;
                case 2: 
                    System.out.println("Ingrese la palabra en el idioma Inglés");
                    String palabra_ingles=scan.nextLine(); 
                    System.out.println("Ingrese la palabra en el idioma Español");
                    String palabra_espanol=scan.nextLine(); 
                    System.out.println("Ingrese la palabra en el idioma Frances"); 
                    String palabra_frances=scan.nextLine(); 
                    a.agreagar(palabra_ingles, palabra_espanol, palabra_frances);
                    break; 
                case 3:
                    break;  
                case 4:
                    break;
                case 5:
                    System.out.println("Gracias por utilizar este porgrama, adios");
                    break;          
                default:
                    System.out.println("opcion invalida");
                    break;
            }
        }
    }
    
}