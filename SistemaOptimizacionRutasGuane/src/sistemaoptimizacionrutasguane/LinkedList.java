/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaoptimizacionrutasguane;

/**
 *
 * @author Yosbiel A
 */
public class LinkedList<X> implements ILista<X> {
    private Node<X> head;
    private int size;
    
    public LinkedList() {
        head = null;
        size = 0;
    }
    
    @Override
    public void add(X info) {
        Node<X> newNode = new Node<>(info);
        if (head == null) {
            head = newNode;
        } else {
            Node<X> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }
    
    @Override
    public X get(int index) {
        Node<X> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getInfo();
    }
    
    @Override
    public int size() {
        return size;
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
