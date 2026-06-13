/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaoptimizacionrutasguane;

/**
 *
 * @author Yosbiel A
 */
public class ArbolGeneral<X> implements IArbolGeneral<X> {
    private NodoGeneral<X> raiz;
    
    public ArbolGeneral() {
        this.raiz = null;
    }
    
    @Override
    public void establecerRaiz(NodoGeneral<X> raiz) {
        this.raiz = raiz;
    }
    
    @Override
    public NodoGeneral<X> obtenerRaiz() {
        return raiz;
    }
    
    @Override
    public boolean isEmpty() {
        return raiz == null;
    }
    
    // Método para construir el árbol
    public void agregarHijo(NodoGeneral<X> padre, NodoGeneral<X> hijo) {
        if (padre == null) return;
        
        if (padre.getPrimerHijo() == null) {
            padre.setPrimerHijo(hijo);
        } else {
            NodoGeneral<X> actual = padre.getPrimerHijo();
            while (actual.getSiguienteHermano() != null) {
                actual = actual.getSiguienteHermano();
            }
            actual.setSiguienteHermano(hijo);
        }
    }
    
    @Override
    public void bfs() {
        if (isEmpty()) {
            System.out.println("El árbol está vacío");
            return;
        }
        
        System.out.print("BFS: ");
        LinkedQueue<NodoGeneral<X>> cola = new LinkedQueue<>();
        cola.add(raiz);
        
        while (!cola.isEmpty()) {
            NodoGeneral<X> actual = cola.poll();
            System.out.print(actual.getInfo() + " ");
            
            NodoGeneral<X> hijo = actual.getPrimerHijo();
            while (hijo != null) {
                cola.add(hijo);
                hijo = hijo.getSiguienteHermano();
            }
        }
        System.out.println();
    }
    
    @Override
    public void dfs() {
        if (isEmpty()) {
            System.out.println("El árbol está vacío");
            return;
        }
        
        System.out.print("DFS: ");
        dfsRecursivo(raiz);
        System.out.println();
    }
    
    private void dfsRecursivo(NodoGeneral<X> actual) {
        if (actual == null) return;
        
        System.out.print(actual.getInfo() + " ");
        
        NodoGeneral<X> hijo = actual.getPrimerHijo();
        while (hijo != null) {
            dfsRecursivo(hijo);
            hijo = hijo.getSiguienteHermano();
        }
    }
    
    @Override
    public int altura() {
        return alturaRecursivo(raiz);
    }
    
    private int alturaRecursivo(NodoGeneral<X> actual) {
        if (actual == null) return 0;
        
        int maxAltura = 0;
        NodoGeneral<X> hijo = actual.getPrimerHijo();
        
        while (hijo != null) {
            int alturaHijo = alturaRecursivo(hijo) + 1;
            if (alturaHijo > maxAltura) {
                maxAltura = alturaHijo;
            }
            hijo = hijo.getSiguienteHermano();
        }
        
        return maxAltura;
    }
    
    @Override
    public int contarNodos() {
        return contarNodosRecursivo(raiz);
    }
    
    private int contarNodosRecursivo(NodoGeneral<X> actual) {
        if (actual == null) return 0;
        
        int total = 1;
        NodoGeneral<X> hijo = actual.getPrimerHijo();
        
        while (hijo != null) {
            total += contarNodosRecursivo(hijo);
            hijo = hijo.getSiguienteHermano();
        }
        
        return total;
    }
    
    @Override
    public boolean buscar(X elemento) {
        return buscarRecursivo(raiz, elemento);
    }
    
    private boolean buscarRecursivo(NodoGeneral<X> actual, X elemento) {
        if (actual == null) return false;
        
        if (actual.getInfo().equals(elemento)) {
            return true;
        }
        
        NodoGeneral<X> hijo = actual.getPrimerHijo();
        while (hijo != null) {
            if (buscarRecursivo(hijo, elemento)) {
                return true;
            }
            hijo = hijo.getSiguienteHermano();
        }
        
        return false;
    }
    
    @Override
    public int gradoArbol() {
        return gradoRecursivo(raiz);
    }
    
    private int gradoRecursivo(NodoGeneral<X> actual) {
        if (actual == null) return 0;
        
        int gradoActual = 0;
        NodoGeneral<X> hijo = actual.getPrimerHijo();
        while (hijo != null) {
            gradoActual++;
            hijo = hijo.getSiguienteHermano();
        }
        
        int gradoMaximo = gradoActual;
        hijo = actual.getPrimerHijo();
        while (hijo != null) {
            int gradoHijo = gradoRecursivo(hijo);
            if (gradoHijo > gradoMaximo) {
                gradoMaximo = gradoHijo;
            }
            hijo = hijo.getSiguienteHermano();
        }
        
        return gradoMaximo;
    }
}


