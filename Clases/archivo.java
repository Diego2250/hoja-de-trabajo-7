/**
 * archivo
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class archivo {

    public archivo() {
    }
    public ArrayList<String> LeerArchivo(String nombre) throws IOException{
            ArrayList<String> lines = new ArrayList<String>();
            try {
                FileReader fr = new FileReader(nombre);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
        return lines; 
      }

}