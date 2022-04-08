/**
 * class Tree
 * Referencia: https://www.youtube.com/watch?v=22AE6WklXBg
 */
public class Tree<K, V> {

    Nodo root;
    public Tree() {
        root=null; 
    }
    
    /** 
     * @param key
     * @param value
     */
    public void insert(String key, String value) {
        Nodo n = new Nodo(key);
        n.valor=value; 
        if (root==null) {
            root=n; 
        } else {
            Nodo tempn=root;
            while (tempn != null) {
                n.root=tempn;
                if (((String) key).compareTo((String) tempn.llave) <= 0) {
                    tempn=tempn.izquierda;
                } else {
                    tempn=tempn.derecha;
                }
            }
            if (((String) key).compareTo((String)n.root.llave)<0) {
                n.root.izquierda=n; 
            }else{
                n.root.derecha=n; 
            }
        }
        
    }

    
    /** 
     * @param n
     */
    public void inOrder(Nodo n) {
        if (n!=null) {
            inOrder(n.izquierda);
            System.out.println(n.llave+" , "+n.valor );
            inOrder(n.derecha);
        } else {
            
        }
    }

    
    /** 
     * @param key
     */
    public V Search(K key) {
        Nodo tempNodo=root;
        while (tempNodo != null) {
            if (((String)key).compareTo((String) tempNodo.llave) == 0) {
            return (V) tempNodo.valor;  
            }else if(((String) key).compareTo((String) tempNodo.llave) < 0){
                tempNodo=tempNodo.izquierda;
            }else{
                tempNodo=tempNodo.derecha; 
            }
        }
        return null; 
    }
    

    
    /** 
     * @param key
     */
    public String Translate(String key) {
        Nodo tempNodo=root;
        String mensaje=""; 
        while (tempNodo != null && !tempNodo.llave.equals(key)) {
            if (((String)key).compareTo((String)tempNodo.llave) < 0) {
                tempNodo = tempNodo.izquierda;
            } else {
                tempNodo = tempNodo.derecha;
            }
        }
        if (tempNodo == null) {
            mensaje= "(" + key + ")"; 
        } else {
            mensaje=(String)tempNodo.valor;
        }
        return mensaje; 
    }
    
}