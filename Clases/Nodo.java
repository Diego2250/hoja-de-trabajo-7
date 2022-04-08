public class Nodo {
    public Nodo padre; 
    public Nodo izquierda;
    public Nodo derecha; 
    public String valor;
    public String llave;
    
    /** 
     * @param key
     * @param value
     */
    public Nodo(String key, String value) {
        llave=key; 
        valor=value; 
        padre=null;
        derecha=null;
        izquierda=null; 
    }        
}
