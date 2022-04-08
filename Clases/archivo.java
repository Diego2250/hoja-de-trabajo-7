/**
 * archivo
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
public class archivo {

    public archivo() {

    }
    
    public ArrayList LeerDiccionario(){
        ArrayList<String> data= new ArrayList<>();
        try {
          File myObj = new File("diccionario.txt");
          Scanner myReader = new Scanner(myObj);
          while (myReader.hasNextLine()) {
            String linea = myReader.nextLine();
            data.add(linea);

          }
          myReader.close();
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
        return data; 
      }

      public ArrayList LeerArchivo(String nombre){
        ArrayList<String> data= new ArrayList<>();
        try {
          File myObj = new File(nombre+".txt");
          Scanner myReader = new Scanner(myObj);
          while (myReader.hasNextLine()) {
            String linea = myReader.nextLine();
            data.add(linea);

          }
          myReader.close();
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
        return data; 
      }

}