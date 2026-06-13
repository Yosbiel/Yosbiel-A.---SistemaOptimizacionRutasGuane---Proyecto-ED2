/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaoptimizacionrutasguane;

/**
 *
 * @author Yosbiel A
 */public class NodoGeneral<X> {
    protected X info;
    protected NodoGeneral<X> primerHijo;
    protected NodoGeneral<X> siguienteHermano;
    
    public NodoGeneral(X info) {
        this.info = info;
        this.primerHijo = null;
        this.siguienteHermano = null;
    }
    
    public X getInfo() {
        return info;
    }
    
    public void setInfo(X info) {
        this.info = info;
    }
    
    public NodoGeneral<X> getPrimerHijo() {
        return primerHijo;
    }
    
    public void setPrimerHijo(NodoGeneral<X> primerHijo) {
        this.primerHijo = primerHijo;
    }
    
    public NodoGeneral<X> getSiguienteHermano() {
        return siguienteHermano;
    }
    
    public void setSiguienteHermano(NodoGeneral<X> siguienteHermano) {
        this.siguienteHermano = siguienteHermano;
    }
    
    public boolean esHoja() {
        return primerHijo == null;
    }
}
