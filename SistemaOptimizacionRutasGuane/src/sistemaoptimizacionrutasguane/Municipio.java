/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaoptimizacionrutasguane;

/**
 *
 * @author Yosbiel A
 */
public class Municipio {
    private String nombre;
    
    public Municipio(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    @Override
    public String toString() {
        return "Municipio: " + nombre;
    }
}

