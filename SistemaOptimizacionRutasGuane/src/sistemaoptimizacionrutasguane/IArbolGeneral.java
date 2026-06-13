/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaoptimizacionrutasguane;

/**
 *
 * @author Yosbiel A
 */
public interface IArbolGeneral<X> {
    void establecerRaiz(NodoGeneral<X> raiz);
    NodoGeneral<X> obtenerRaiz();
    boolean isEmpty();
    void bfs();
    void dfs();
    int altura();
    int contarNodos();
    boolean buscar(X elemento);
    int gradoArbol();
}

