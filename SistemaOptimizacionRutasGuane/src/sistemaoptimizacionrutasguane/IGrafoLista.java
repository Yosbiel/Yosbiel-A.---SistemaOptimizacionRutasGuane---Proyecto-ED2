/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaoptimizacionrutasguane;

/**
 *
 * @author Yosbiel A
 */
public interface IGrafoLista {
    void agregarVertice(String v);
    void agregarArista(int i, int j);
    void agregarArista(int i, int j, double peso);
    void bfs(int inicio);
    void dfs(int inicio);
    void mostrar();
    int grado(int vertice);
    int cantidadVertices();
    String obtenerVertice(int pos);
    boolean esVacio();
    boolean esDirigido();
    boolean esPonderado();
    void dijkstra(int origen);
}
