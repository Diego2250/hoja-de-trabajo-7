/**
 * Actions
 */
import java.io.IOException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;
public class Actions {
    archivo arch=new archivo();
    ArrayList<String> datos=new ArrayList<>();

    Tree arbolingles=new Tree();
    Tree arbolfrances=new Tree();

    public void separar() {
        ArrayList <String> Datos = new ArrayList<>();   
        try {
            Datos=arch.LeerArchivo("diccionario.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < Datos.size(); i++) {
            String[] palabras = Datos.get(i).split(",");
            for (int j = 0; j < palabras.length; j++) {
                palabras[j]=palabras[j].toLowerCase();
                datos.add(palabras[j]);
            }
        }
    }

    public void createArboles() {
        ArrayList <String> Ingles = new ArrayList<>();
        ArrayList <String> Espanol = new ArrayList<>();
        ArrayList <String> Frances = new ArrayList<>();
        
        for (int i = 0; i < datos.size(); i++) {
            Ingles.add(datos.get(i));
            i+=1;
            Espanol.add(datos.get(i));
            i+=1;
            Frances.add(datos.get(i));
        }

        for (int i = 0; i < Ingles.size(); i++) {
            arbolingles.insert(Ingles.get(i), Espanol.get(i));
        }

        for (int i = 0; i < Frances.size(); i++) {
            arbolfrances.insert(Frances.get(i), Espanol.get(i));
        }
        System.out.println("Diccionario Ingles: ");
        arbolingles.inOrder(arbolingles.root);
        System.out.println("Diccionario Frances: ");
        arbolingles.inOrder(arbolfrances.root);
    }

    public void agreagar(String key, String español, String frances) {
        arbolingles.insert(key, español);
        arbolfrances.insert(frances, español);
        System.out.println("Se han agregado las palabras correctamente");
    }

    public void Translate(String nombre) {
        String mensaje="";
        ArrayList<String> palabras=new ArrayList<>();
        ArrayList<String> data=new ArrayList<>();
        byte idioma=0; 
        try {
            data=arch.LeerArchivo(nombre);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            for (int i = 0; i < data.size(); i++) {
                String[] palabrasseparadas = data.get(i).split(" ");
                for (int j = 0; j < palabrasseparadas.length; j++) {
                    palabrasseparadas[j]=palabrasseparadas[j].toLowerCase();
                    palabras.add(palabrasseparadas[j]);
                }
            }
            for (int i = 0; i < palabras.size(); i++) {
                if (arbolingles.Search(palabras.get(i))!=null) {
                    idioma=1; 
                    break;
                } else if(arbolfrances.Search(palabras.get(i))!=null){
                    idioma=2;
                    break; 
                }else{
                    idioma=3; 
                }
            }
            switch (idioma) {
                case 1:
                    for (int i = 0; i < palabras.size(); i++) {
                        mensaje = mensaje + " " + arbolingles.Translate(palabras.get(i)) + " ";
                    }  
                    break;
                case 2:
                    for (int i = 0; i < palabras.size(); i++) {
                        mensaje = mensaje + " " + arbolfrances.Translate(palabras.get(i)) + " ";
                    }  
                    break;
                default:
                    System.out.println("No se encontró la palabra");
                    break;
            }
            System.out.println(mensaje);
            System.out.println("Las palabras que estan entre parentesis no se han encontrado en el diccionario");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}