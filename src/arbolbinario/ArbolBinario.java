
package arbolbinario;

import java.util.Scanner;

public class ArbolBinario {
    Scanner op = new Scanner(System.in);
    Arbol ArbolB = new Arbol();
    
    public void menu(){
        boolean salir = false;
        int opcion;
        
        while(!salir){
           System.out.println("");
           System.out.println("|-------**BIENVENIDO**-------|"); 
           System.out.println("|     **ÁRBOL BINARIO**      |");
           System.out.println("|  1. Agregar datos          |"); 
           System.out.println("|  2. Mostrar árbol PreOrden |");
           System.out.println("|  3. Mostrar árbol InOrden  |");
           System.out.println("|  4. Mostrar árbol PostOrden|");
           System.out.println("|  5. Buscar un dato         |");
           System.out.println("|  6. Eliminar dato          |");
           System.out.println("|  7. Obtener la raíz        |");
           System.out.println("|  8. Altura del árbol       |");
           System.out.println("|  9. Número de elementos    |");
           System.out.println("|  0. SALIR                  |");
           System.out.println("| ---Selecciona la opción--- |");
           opcion = op.nextInt();
           op.nextLine();
           switch(opcion){
            case 1:
                System.out.println("Ingrese dato: ");
                ArbolB.addNodo(op.nextInt());
                break;
            case 2:
                System.out.println("--------PREORDEN---------");
                if( ArbolB.vacio()== false){
                    ArbolB.ImprimirPreOrden(ArbolB.raiz);
                }                    
                break;             
            case 3:
                System.out.println("--------INORDEN---------");
                if( ArbolB.vacio()== false){
                    ArbolB.ImprimirInOrden(ArbolB.raiz);
                }         
                break;
            case 4:
                System.out.println("--------POSTORDEN---------");
               if( ArbolB.vacio()== false){
                    ArbolB.ImprimirPostOrden(ArbolB.raiz);
                }
                break;
            case 5:
                System.out.println("Ingrese búsqueda: ");
                int busqueda = ArbolB.Buscar(op.nextInt());
                if( busqueda == 0){
                    System.out.println("El dato buscado no existe en el árbol");
                }else{
                    System.out.println("El dato " +busqueda+ " ha sido encontrado");
                }
                
                break;
            case 6:
                if( ArbolB.vacio() == false){
                    System.out.println("Ingrese dato a eliminar: ");
                //ArbolB.Delete(op.nextInt());
                    ArbolB.eliminarNodo(ArbolB.raiz,op.nextInt());
                }               
                break;
            case 7:
                System.out.println("La raíz es: "+ ArbolB.raiz.dato);
                break;
                
            case 8:
                if(ArbolB.vacio() == false){
                    System.out.println("La altura del árbol es: "+ ArbolB.alturaArbol(ArbolB.raiz));
                }              
                break;
            case 9:
                if( ArbolB.vacio()== false){
                    System.out.println("El total de elementos dentro del árbol es: "+ ArbolB.nElementos(ArbolB.raiz));
                }      
                break;
            case 0:
                salir = true;               
                break;
            default:
                System.out.println("La opción ingresada es incorrecta");          
            }
        }
    }
    
    
    public static void main(String[] args) {
        ArbolBinario objeto = new ArbolBinario();
        objeto.menu();
                
    }
    
}