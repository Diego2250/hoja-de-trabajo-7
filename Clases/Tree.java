/**
 * class Tree
 * Referencia: https://www.youtube.com/watch?v=22AE6WklXBg
 */
public class Tree {

    Nodo raiz;
    public Tree() {
        raiz=null; 
    }
    
    /** 
     * @param key
     * @param value
     */
    public void insert(String key, String value) {
        Nodo n = new Nodo(key, value);
        if (raiz==null) {
            raiz=n; 
        } else {
            Nodo tempn=raiz;
            while (tempn != null) {
                n.padre=tempn;
                if (n.llave.compareTo(tempn.llave)==0||n.llave.compareTo(tempn.llave)>0) {
                    tempn=tempn.derecha;
                } else {
                    tempn=tempn.izquierda;
                }
            }
            if (n.llave.compareTo(n.padre.llave)<0) {
                n.padre.izquierda=n; 
            }else{
                n.padre.derecha=n; 
            }
        }
        
    }

    
    /** 
     * @param llave
     */
    public void delete(String llave) {
        String Mensaje="";
        Nodo tempNodo=raiz;
        Nodo padre=null; 
        while (tempNodo!=null&&!tempNodo.llave.equals(llave)) {
            padre=tempNodo;
            if (llave.compareTo(tempNodo.llave)<0) {
                tempNodo=tempNodo.izquierda;
            } else {
                tempNodo=tempNodo.derecha;
            }
        }
        if (tempNodo==null) {
            System.out.println("No se ha encontrado el nodo");
        } else {
            if (tempNodo==raiz){
                if (tempNodo.izquierda == null && tempNodo.derecha == null) {
                    raiz=null;
                } else if(tempNodo.izquierda == null){
                    raiz = tempNodo.derecha;
                } else if (tempNodo.derecha == null) {
                    raiz = tempNodo.izquierda;
                } else { 
                    Nodo tempNodo2=tempNodo.izquierda;
                    Nodo padre2=tempNodo; 
                    while (tempNodo2.derecha!=null) {
                        padre2=tempNodo2;
                        tempNodo2=tempNodo2.derecha;
                    }
                    tempNodo.llave=tempNodo2.llave;
                    tempNodo2.llave=llave; 
                    if (padre2.derecha==tempNodo2) {
                        padre2.derecha=tempNodo2.izquierda;
                    } else {
                        padre2.izquierda=tempNodo2.izquierda;
                    }
                } 
            } else{
                if (tempNodo.izquierda == null && tempNodo.derecha == null) {
                    if (tempNodo.llave.compareTo(padre.llave) < 0) {
                        padre.izquierda = null;
                    } else {
                        padre.derecha = null;
                    }
                } else if (tempNodo.izquierda == null) {
                    if (tempNodo.llave.compareTo(padre.llave) < 0) {
                        padre.izquierda = tempNodo.derecha;
                    } else {
                        padre.derecha = tempNodo.derecha;
                    }
                } else if (tempNodo.derecha == null) {
                    if (tempNodo.llave.compareTo(padre.llave) < 0) {
                        padre.izquierda = tempNodo.izquierda;
                    } else {
                        padre.derecha = tempNodo.izquierda;
                    }
                } else {
                    Nodo tempNodo2 = tempNodo.izquierda;
                    Nodo padre2 = tempNodo;
                    while (tempNodo2.derecha != null) {
                        padre2 = tempNodo2;
                        tempNodo = tempNodo2.derecha;
                    }
                    tempNodo2.llave = tempNodo2.llave;
                    tempNodo2.llave = llave;
                    if (padre2.derecha == tempNodo2) {
                        padre2.derecha = tempNodo2.izquierda;
                    } else {
                        padre2.izquierda = tempNodo2.izquierda;
                    }
                }
            }   
            System.out.println("Se ha elimidado el nodo "+llave);
        }
    }

    
    /** 
     * @param n
     */
    public void Order(Nodo n) {
        if (n!=null) {
            Order(n.izquierda);
            System.out.println(n.llave+" , "+n.valor );
            Order(n.derecha);
        } else {
            
        }
    }

    
    /** 
     * @param key
     */
    public void Search(String key) {
        Nodo tempNodo=raiz;
        while (tempNodo != null && !tempNodo.llave.equals(key)) {
            if (key.compareTo(tempNodo.llave) < 0) {
                tempNodo = tempNodo.izquierda;
            } else {
                tempNodo = tempNodo.derecha;
            }
        }
        if (tempNodo == null) {
            System.out.println("null");
        } else {
            System.out.println(key);
        }
    }

    
    /** 
     * @param key
     */
    public void Translate(String key) {
        Nodo tempNodo=raiz;
        while (tempNodo != null && !tempNodo.llave.equals(key)) {
            if (key.compareTo(tempNodo.llave) < 0) {
                tempNodo = tempNodo.izquierda;
            } else {
                tempNodo = tempNodo.derecha;
            }
        }
        if (tempNodo == null) {
            System.out.println("(" + key + ")");
        } else {
            System.out.println(tempNodo.valor);
        }
    }
    
}