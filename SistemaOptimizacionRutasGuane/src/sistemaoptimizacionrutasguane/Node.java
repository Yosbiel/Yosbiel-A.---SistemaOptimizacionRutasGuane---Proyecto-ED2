/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaoptimizacionrutasguane;

/**
 *
 * @author Yosbiel A
 */
public class Node<X> {
    protected X info;
    protected Node<X> next;
    
    public Node(X info){
        this.info = info;
        this.next = null;
    }
    
    public Node(X info, Node<X> next){
        this.info=info;
        this.next=next;
    }
    
    public X getInfo(){
        return info;
    }
    
    public void setInfo(X info){
        this.info = info;
    }
    
    public Node<X> getNext(){
        return next;
    }
    
    public void setNext(Node<X> next){
        this.next = next;
    }
    
}
