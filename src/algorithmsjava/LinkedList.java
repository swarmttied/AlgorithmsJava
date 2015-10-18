/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmsjava;

/**
 *
 * @author the-r
 */
public class LinkedList {
    
    class Node {     
        Node next;        
        int data;
    }      
    
    private Node _head;   
   
    public LinkedList() {
        this(1);
    }
    
    public LinkedList(int size) {        
        _head = new Node();        
        createList(_head, size);
    }
       
    public int getSize() {
        int size = 0;
        Node current = _head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
    
    private void createList(Node head, int size) {
        Node current = head;
        for (int i=1; i < size; i++)
        {
            current.next = new Node();
            current = current.next;
        }
    }
    
    public int[] toArray() {
        int[] result = new int[getSize()];
        Node current = _head;
        int index = 0;
        while (current != null) {
            result[index++] = current.data;
            current = current.next;
            
        }
        
        return result;
    }   
   
    /**
     * O(N)
     * @param data 
     */
    public void append(int data) {
        Node current = _head;
        while (current.next != null)
            current = current.next;
        
        Node newNode = new Node();
        newNode.data = data;
        current.next = newNode;        
    }
    
    /**
     * O(1)
     * @param data 
     */
    public void prepend(int data) {
        Node temp = _head;
        Node newNode = new Node();
        newNode.data = data;
        _head = newNode;
        _head.next = temp;
    }
    
    public int removeHead(){
        Node toRemove = _head;
        
        if (_head.next != null)
            _head = _head.next;
        else
            _head = null;
        
        return toRemove.data;
    }
    
    public void distinct() {
        Node current = _head;
        Node runner = null;
        while (current != null) {
            runner = current;
            while (runner.next != null) {
                if (current.data == runner.next.data) {                    
                        runner.next = runner.next.next;                             
                }       
                runner = runner.next;
            }
            current = current.next;
        }
    }
}
