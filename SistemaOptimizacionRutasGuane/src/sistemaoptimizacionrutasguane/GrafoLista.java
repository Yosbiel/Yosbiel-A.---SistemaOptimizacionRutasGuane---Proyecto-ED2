/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaoptimizacionrutasguane;

/**
 *
 * @author Yosbiel A
 */
public class GrafoLista implements IGrafoLista {
    private String[] vertices;
    private LinkedList<Integer>[] listaAdyacencia;
    private double[][] pesos;
    private int size;
    private int max;
    private boolean dirigido;
    private boolean ponderado;
    
    public GrafoLista(int maxVertices, boolean dirigido, boolean ponderado) {
        this.max = maxVertices;
        this.dirigido = dirigido;
        this.ponderado = ponderado;
        this.vertices = new String[maxVertices];
        this.listaAdyacencia = new LinkedList[maxVertices];
        this.pesos = new double[maxVertices][maxVertices];
        this.size = 0;
        
        for (int i = 0; i < maxVertices; i++) {
            listaAdyacencia[i] = new LinkedList<>();
        }
    }
    
    @Override
    public void agregarVertice(String v) {
        if (size < max) {
            vertices[size] = v;
            size++;
        }
    }
    
    @Override
    public void agregarArista(int i, int j) {
        agregarArista(i, j, 1);
    }
    
    @Override
    public void agregarArista(int i, int j, double peso) {
        if (i < size && j < size) {
            listaAdyacencia[i].add(j);
            pesos[i][j] = peso;
            
            if (!dirigido) {
                listaAdyacencia[j].add(i);
                pesos[j][i] = peso;
            }
        }
    }
    
    @Override
    public void bfs(int inicio) {
        if (esVacio()) {
            System.out.println("El grafo está vacío");
            return;
        }
        
        boolean[] visitado = new boolean[size];
        LinkedQueue<Integer> cola = new LinkedQueue<>();
        
        System.out.print("BFS: ");
        visitado[inicio] = true;
        cola.add(inicio);
        
        while (!cola.isEmpty()) {
            int v = cola.poll();
            System.out.print(vertices[v] + " ");
            
            for (int i = 0; i < listaAdyacencia[v].size(); i++) {
                int ady = listaAdyacencia[v].get(i);
                if (!visitado[ady]) {
                    visitado[ady] = true;
                    cola.add(ady);
                }
            }
        }
        System.out.println();
    }
    
    @Override
    public void dfs(int inicio) {
        if (esVacio()) {
            System.out.println("El grafo está vacío");
            return;
        }
        
        boolean[] visitado = new boolean[size];
        System.out.print("DFS: ");
        dfsRecursivo(inicio, visitado);
        System.out.println();
    }
    
    private void dfsRecursivo(int v, boolean[] visitado) {
        visitado[v] = true;
        System.out.print(vertices[v] + " ");
        
        for (int i = 0; i < listaAdyacencia[v].size(); i++) {
            int ady = listaAdyacencia[v].get(i);
            if (!visitado[ady]) {
                dfsRecursivo(ady, visitado);
            }
        }
    }
    
    @Override
    public void mostrar() {
        System.out.println("\nGRAFO: " + (dirigido ? "DIRIGIDO" : "NO DIRIGIDO") + 
                           " | " + (ponderado ? "PONDERADO" : "NO PONDERADO") + ":");
        
        for (int i = 0; i < size; i++) {
            System.out.print(vertices[i] + ": ");
            for (int j = 0; j < listaAdyacencia[i].size(); j++) {
                int ady = listaAdyacencia[i].get(j);
                if (ponderado) {
                    System.out.print(vertices[ady] + "(" + pesos[i][ady] + ") ");
                } else {
                    System.out.print(vertices[ady] + " ");
                }
            }
            System.out.println();
        }
    }
    
    @Override
    public int grado(int vertice) {
        return listaAdyacencia[vertice].size();
    }
    
    @Override
    public int cantidadVertices() {
        return size;
    }
    
    @Override
    public String obtenerVertice(int pos) {
        if (pos < 0 || pos >= size) return null;
        return vertices[pos];
    }
    
    @Override
    public boolean esVacio() {
        return size == 0;
    }
    
    @Override
    public boolean esDirigido() {
        return dirigido;
    }
    
    @Override
    public boolean esPonderado() {
        return ponderado;
    }
    
    // ::::::::: DIJKSTRA:::::::::
    @Override
    public void dijkstra(int origen) {
        int n = size;
        double[] dist = new double[n];
        boolean[] visitado = new boolean[n];
        int[] previo = new int[n];  // Guarda el vértice anterior en el camino mínimo
        
        for (int i = 0; i < n; i++) {
            dist[i] = Double.POSITIVE_INFINITY;
            previo[i] = -1;  // -1 significa que no tiene predecesor
        }
        dist[origen] = 0;
        
        for (int i = 0; i < n; i++) {
            int u = -1;
            double minDist = Double.POSITIVE_INFINITY;
            for (int j = 0; j < n; j++) {
                if (!visitado[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    u = j;
                }
            }
            
            if (u == -1) break;
            
            visitado[u] = true;
            
            for (int v = 0; v < listaAdyacencia[u].size(); v++) {
                int ady = listaAdyacencia[u].get(v);
                double peso = pesos[u][ady];
                if (!visitado[ady] && dist[u] + peso < dist[ady]) {
                    dist[ady] = dist[u] + peso;
                    previo[ady] = u;  // Se guarda por dónde se llegó a 'ady'
                }
            }
        }
        
        // Mostrar resultados con los caminos
        System.out.println("\n:::: DISTANCIAS MÍNIMAS DESDE " + vertices[origen] + " ::::");
        for (int i = 0; i < n; i++) {
            if (dist[i] == Double.POSITIVE_INFINITY) {
                System.out.println(vertices[i] + ": No alcanzable");
            } else {
                String camino = construirCamino(previo, origen, i);
                System.out.println(vertices[i] + ": " + dist[i] + " km" + "  |  Ruta: " + camino);
            }
        }
    }
    
    // Método auxiliar para construir el camino desde el origen hasta el destino
    private String construirCamino(int[] previo, int origen, int destino) {
        if (destino == origen) {
            return vertices[origen];
        }
        if (previo[destino] == -1) {
            return "No hay ruta";
        }
        return construirCamino(previo, origen, previo[destino]) + " → " + vertices[destino];
    }
}
