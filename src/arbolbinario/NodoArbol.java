
package arbolbinario;

public class NodoArbol {
    int dato;
    NodoArbol hijoIzquierdo;
    NodoArbol hijoDerecho;
    
    public NodoArbol(int dato){
        this.dato = dato;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }   
}