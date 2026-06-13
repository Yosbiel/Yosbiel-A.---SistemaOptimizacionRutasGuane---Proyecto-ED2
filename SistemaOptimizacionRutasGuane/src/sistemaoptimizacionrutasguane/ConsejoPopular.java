/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaoptimizacionrutasguane;

/**
 *
 * @author Yosbiel A
 */
public class ConsejoPopular {
    private String nombre;
    private double poblacion;
    private double area;
    
    public ConsejoPopular(String nombre, double poblacion, double area) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.area = area;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public double getPoblacion() {
        return poblacion;
    }
    
    public double getArea() {
        return area;
    }
    
    @Override
    public String toString() {
        return "Consejo Popular: " + nombre + " (Población: " + poblacion + ", Área: " + area + " km²)";
    }
}
