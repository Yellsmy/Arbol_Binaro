
package arbolbinario;

public class Arbol {
    NodoArbol raiz;
    
    public Arbol(){
        this.raiz = null;
    }
     //insertar un nodo
    public void addNodo(int dato){
        NodoArbol nuevo = new NodoArbol(dato);
        if(raiz == null){
            raiz = nuevo;
        }else{
            NodoArbol aux = raiz;
            NodoArbol padre;
            while(true){
                padre=aux;
                if(dato<aux.dato){
                    //va a la izquierda
                    aux= aux.hijoIzquierdo;
                    if(aux==null){
                        padre.hijoIzquierdo = nuevo;
                        return;
                    }
                }else{
                    //va a la derecha
                    aux = aux.hijoDerecho;
                    if(aux == null){
                        padre.hijoDerecho = nuevo;
                        return;
                    }
                }
            }
        }       
    }
    
    //Método para saber si el árbol está vacío
    public boolean vacio(){
        if( raiz == null){
            System.out.println("El árbol está vacío");
            return true;
        }else{
            return false;
        }           
    }
    
    //Método para mostrar los datos en PreOrden
    public void ImprimirPreOrden(NodoArbol r){
        System.out.print(" "+r.dato);     //Mostramos posición actual
        if(r.hijoIzquierdo != null){   //Entra a la posición izquierda del árbol siempre que no sea null
            ImprimirPreOrden(r.hijoIzquierdo);}  //Volvemos a llamar a la función hasta que la posición izquierda sea null
        if(r.hijoDerecho != null){ //Entramos a la posición derecha siempre que sea diferente de null, si es null continua con el resto del código 
            ImprimirPreOrden(r.hijoDerecho); //Si tiene posición derecha se llama a la función nuevamente hasta que la posición derecha sea null
        }                 
    }
    
    //Método para mostrar los datos InOrden
    public void ImprimirInOrden(NodoArbol r){
        if(r.hijoIzquierdo != null){   //Entra a la posición izquierda del árbol siempre que no sea null
            ImprimirInOrden(r.hijoIzquierdo);}  //Volvemos a llamar a la función hasta que la posición izquierda sea null
        System.out.print(" "+r.dato);     //Mostramos posición actual
        if(r.hijoDerecho != null){ //Entramos a la posición derecha siempre que sea diferente de null, si es null continua con el resto del código 
            ImprimirInOrden(r.hijoDerecho); //Si tiene posición derecha se llama a la función nuevamente hasta que la posición derecha sea null
        }         
    }
    
    //Método para mostrar los datos en PostOrden
    public void ImprimirPostOrden(NodoArbol r){
        if(r.hijoIzquierdo != null){   //Entra a la posición izquierda del árbol siempre que no sea null
            ImprimirPostOrden(r.hijoIzquierdo);}  //Volvemos a llamar a la función (recursividad) hasta que la posición izquierda sea null
        if(r.hijoDerecho != null){ //Entramos a la posición derecha siempre que sea diferente de null, si es null continua con el resto del código 
            ImprimirPostOrden(r.hijoDerecho); //Si tiene posición derecha se llama a la función nuevamente hasta que la posición derecha sea null
        }
        System.out.print(" "+r.dato);     //Mostramos posición actual
    }
    
    //Método para mostrar la altura del árbol
    public int alturaArbol(NodoArbol r){     
        if(r != null){
            return 1 + Math.max(alturaArbol(r.hijoIzquierdo), alturaArbol(r.hijoDerecho)); //Compara ambos lados y saca el máximo, a eso se le suma 1 que es el nivel donde está la raíz   
       }   
        return -1;         
    }
    
    //Método para buscar un dato dentro del árbol
    public int Buscar(int dato){
        NodoArbol temp = raiz;
        while(temp.dato != dato){ //Siempre que el dato buscado no sea igual al dato en el árbol, entonces que lo busque
            if( dato < temp.dato){ // si el dato buscado es menor que la raiz es porque el dato buscado está del lado izquierdo
                temp = temp.hijoIzquierdo;
            }else{ //sino es menor a la raiz es porque es mayor, por lo que estará del lado derecho
                temp = temp.hijoDerecho;
            }
            if(temp == null){  //si el nodo llega a null y no ha encontrado el dato buscado, que retorne 0           
                return 0;}                
        }
        return temp.dato; // cuando salga del while es porque encontró el dato, por lo tanto que retorne el dato encontrado    
    }
    
    
    //Método para eliminar un dato   
    public NodoArbol eliminarNodo( NodoArbol nodo, int dato){
        if(nodo != null){ 
            if(dato == nodo.dato){ 
                if(nodo.hijoIzquierdo == null && nodo.hijoDerecho == null){ // si el nodo a eliminar no tiene hijos nodo va apuntar a null
                    return nodo= null;
                }else{
                    //Si el nodo a eliminar solo tiene un hijo
                    if (nodo.hijoIzquierdo == null && nodo.hijoDerecho != null){ // si el nodo a eliminar no tiene hijo izquierdo, se debe retornar el derecho
                        return nodo = nodo.hijoDerecho;
                    }else{
                        if(nodo.hijoIzquierdo != null && nodo.hijoDerecho == null){ // si el nodo a eliminar no tiene hijo derecho, se debe retornar el izquierdo
                            return nodo= nodo.hijoIzquierdo;
                        }else{
                            if(nodo.hijoIzquierdo != null && nodo.hijoDerecho != null){ // si el nodo a eliminar tiene 2 hijos, entonces 
                                NodoArbol derecho = nodo.hijoDerecho;
                                NodoArbol temp = sucesor(derecho); // Llamamos al método auxiliar y le pasamos el nodo derecho como argumento
                                
                                temp.hijoIzquierdo = nodo.hijoIzquierdo; //A temp. izquierdo se añade todos los nodos izquierdos para no perderlos
                                return temp;
                            }
                        }
                    }
                }
            }
            if( dato < nodo.dato){ //Si el dato buscado es menor, que lo busque del lado izquierdo
                nodo.hijoIzquierdo = eliminarNodo(nodo.hijoIzquierdo, dato);
               
            }else{ //sino está en el lado izquierdo, que lo busque en el derecho
                nodo.hijoDerecho = eliminarNodo(nodo.hijoDerecho, dato);
            }
        }
        return nodo;
    }
    
    //Método auxiliar para eliminar
    public NodoArbol sucesor( NodoArbol nodo){ //Tomará el menor de los mayores 
        if( nodo.hijoIzquierdo != null){  //Si existe un nodo menor al que fue pasado como argumento, entonces buscará el menor y lo retornará
            return sucesor(nodo.hijoIzquierdo);
        }
        return nodo; // Si no entra a la condición anterior, retornará el mismo nodo pasado como argumento ya que no existe un nodo menor
    }
    
    //Método que devuelve el nodo reemplazo 
    public NodoArbol obtenerNodoReemplazo(NodoArbol NodoRemp){
        NodoArbol reemplazarAnterior = NodoRemp;
        NodoArbol reemplazo = NodoRemp;
        NodoArbol auxiliar = NodoRemp.hijoDerecho;
        while(auxiliar != null){
            reemplazarAnterior = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.hijoIzquierdo;
        }
        if(reemplazo != NodoRemp.hijoDerecho){
            reemplazarAnterior.hijoIzquierdo = reemplazo.hijoDerecho;
            reemplazo.hijoDerecho = NodoRemp.hijoDerecho;
        }
        System.out.println("El nodo reemplazo es: "+ reemplazo);
        return reemplazo;
    }
    
    //Método para calcular el número de elementos que hay en el árbol
    public int nElementos(NodoArbol r){
        int cont = 1; //El contador inicia en 1 porque inicia contando la raíz
        if(r.hijoIzquierdo != null){  
            cont += nElementos(r.hijoIzquierdo);
        }
        if(r.hijoDerecho != null){
            cont += nElementos(r.hijoDerecho);
        }
        return cont;
    }
}
