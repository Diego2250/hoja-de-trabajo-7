public class Nodo<K, V> {
    public Nodo root; 
    public Nodo izquierda;
    public Nodo derecha; 
    public V valor;
    public K llave;
    
    /** 
     * @param key
     * @param value
     */
    public Nodo(K key) {
        llave=key; 
        root=null;
        derecha=null;
        izquierda=null; 
        valor=null; 
    }        
}
