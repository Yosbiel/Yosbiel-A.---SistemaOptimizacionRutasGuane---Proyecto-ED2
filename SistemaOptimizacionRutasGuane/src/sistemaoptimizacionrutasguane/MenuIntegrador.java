/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaoptimizacionrutasguane;

/**
 *
 * @author Yosbiel A
 */
import java.util.Scanner;

public class MenuIntegrador {
    private ArbolGeneral<Object> arbol;
    private GrafoLista grafo;
    private Scanner scanner;
    private int origenSeleccionado;
    private String[] consejosPopulares;
    
    public MenuIntegrador() {
        arbol = new ArbolGeneral<>();
        scanner = new Scanner(System.in);
        origenSeleccionado = -1;
        inicializarArbol();
        inicializarGrafo();
    }
    
    private void inicializarArbol() {
        NodoGeneral<Object> nodoCuba = new NodoGeneral<>(new Pais("Cuba"));
        NodoGeneral<Object> nodoPinarRio = new NodoGeneral<>(new Provincia("Pinar del Río"));
        NodoGeneral<Object> nodoGuane = new NodoGeneral<>(new Municipio("Guane"));
        
        arbol.agregarHijo(nodoCuba, nodoPinarRio);
        arbol.agregarHijo(nodoPinarRio, nodoGuane);
        
        consejosPopulares = new String[]{
            "Guane 1", "Guane 2", "Isabel Rubio", "Molina - El Valle",
            "Sábalo", "Combate de las Tenerías", "Los Portales", "Punta de la Sierra"
        };
        
        agregarConsejoPopular(nodoGuane, "Guane 1", 6429, 19.70);
        agregarConsejoPopular(nodoGuane, "Guane 2", 7004, 60.30);
        agregarConsejoPopular(nodoGuane, "Isabel Rubio", 7049, 29.92);
        agregarConsejoPopular(nodoGuane, "Molina - El Valle", 3358, 105.50);
        agregarConsejoPopular(nodoGuane, "Sábalo", 3390, 61.50);
        agregarConsejoPopular(nodoGuane, "Combate de las Tenerías", 2132, 77.00);
        agregarConsejoPopular(nodoGuane, "Los Portales", 3306, 125.00);
        agregarConsejoPopular(nodoGuane, "Punta de la Sierra", 3050, 238.37);
        
        arbol.establecerRaiz(nodoCuba);
    }
    
    private void agregarConsejoPopular(NodoGeneral<Object> nodoMunicipio, String nombre, double poblacion, double area) {
        ConsejoPopular cp = new ConsejoPopular(nombre, poblacion, area);
        NodoGeneral<Object> nodoCP = new NodoGeneral<>(cp);
        arbol.agregarHijo(nodoMunicipio, nodoCP);
    }
    
    private void inicializarGrafo() {
        grafo = new GrafoLista(10, false, true);
        
        for (String cp : consejosPopulares) {
            grafo.agregarVertice(cp);
        }
        
        grafo.agregarArista(0, 1, 1);    // Guane 1 - Guane 2
        grafo.agregarArista(0, 6, 7);    // Guane 1 - Los Portales
        grafo.agregarArista(0, 2, 5);    // Guane 1 - Isabel Rubio
        grafo.agregarArista(2, 3, 7.5);  // Isabel Rubio - Molina - El Valle
        grafo.agregarArista(3, 4, 9.6);  // Molina - El Valle - Sábalo
        grafo.agregarArista(1, 5, 9.6);  // Guane 2 - Combate de las Tenerías
        grafo.agregarArista(6, 7, 15);   // Los Portales - Punta de la Sierra
        grafo.agregarArista(4, 7, 32);   // Sábalo - Punta de la Sierra
        grafo.agregarArista(2, 5, 13);   // Isabel Rubio - Combate de las Tenerías
        grafo.agregarArista(4, 5, 28);   // Sábalo - Combate de las Tenerías
    }
    
    private void mostrarArbol() {
        System.out.println("\n::::: ÁRBOL GEOGRÁFICO :::::");
        mostrarArbolRecursivo(arbol.obtenerRaiz(), "");
    }
    
    private void mostrarArbolRecursivo(NodoGeneral<Object> actual, String prefijo) {
        if (actual == null) return;
        System.out.println(prefijo + actual.getInfo().toString());
        NodoGeneral<Object> hijo = actual.getPrimerHijo();
        while (hijo != null) {
            mostrarArbolRecursivo(hijo, prefijo + "   ");
            hijo = hijo.getSiguienteHermano();
        }
    }
    
    private void mostrarGrafo() {
        grafo.mostrar();
    }
    
    private void seleccionarOrigen() {
        System.out.println("\n::::: CONSEJOS POPULARES :::::");
        for (int i = 0; i < consejosPopulares.length; i++) {
            System.out.println(i + ". " + consejosPopulares[i]);
        }
        System.out.print("Seleccione el número del origen: ");
        int origen = scanner.nextInt();
        if (origen >= 0 && origen < consejosPopulares.length) {
            origenSeleccionado = origen;
            System.out.println("Origen seleccionado: " + consejosPopulares[origen]);
        } else {
            System.out.println("Opción no válida");
        }
    }
    
    private void calcularRutas() {
        if (origenSeleccionado == -1) {
            System.out.println("Primero seleccione un origen en la opción 3");
            return;
        }
        System.out.println("\nCalculando rutas mínimas desde " + consejosPopulares[origenSeleccionado] + "...");
        grafo.dijkstra(origenSeleccionado);
    }
    
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n::::: SISTEMA DE RUTAS DE DISTRIBUCIÓN :::::");
            System.out.println("1- Mostrar árbol geográfico");
            System.out.println("2- Mostrar grafo de rutas");
            System.out.println("3- Seleccionar Consejo Popular origen");
            System.out.println("4- Calcular rutas mínimas (Dijkstra)");
            System.out.println("5- Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1: mostrarArbol(); break;
                case 2: mostrarGrafo(); break;
                case 3: seleccionarOrigen(); break;
                case 4: calcularRutas(); break;
                case 5: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción no válida");
            }
        } while (opcion != 5);
    }
}
