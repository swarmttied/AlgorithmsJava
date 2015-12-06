/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmsjava;

import java.util.Queue;
import java.util.Vector;

/**
 *
 * @author Gio
 */
public class MultiStack {  
    
    class Node {
        Node previous;
        Node next;
        int value;
    }
    
    class HeadNode {        
        Node value;
        HeadNode next;   
        HeadNode previous;
    }
    
    int _sizeOfEachQueue;
    Node _mainHead;
    HeadNode _headOfHeads;
    
    public MultiStack(int sizeOfEachQueue) {
        _sizeOfEachQueue = sizeOfEachQueue;
    }
    
    public void push(int value) {
        Node newNode = new Node();
        newNode.value = value;        
               
        if (getLength() != 0) {
            Node current = _mainHead;
            while (current.next != null) {
                current = current.next;
            }            
            current.next = newNode;
            newNode.previous = current;
            
            if (getLength() % _sizeOfEachQueue == 1) {
                HeadNode currentHead = _headOfHeads;
                while (currentHead.next != null) {
                    currentHead = currentHead.next;
                }
                HeadNode newHead = new HeadNode();
                newHead.value = newNode;
                currentHead.next = newHead;
                newHead.previous = currentHead;
            }
        }
        else {
            _mainHead = newNode;
            _headOfHeads = new HeadNode();
            _headOfHeads.value = newNode;
        }    
    }  
    
    public int pop() {
        return pop(_headOfHeads);
    }
    
    public int pop(int stackNo) {
        HeadNode current = _headOfHeads;
        int index = 0;
        while(index < stackNo && current != null) {
            current = current.next;
            index++;
        }
        
        if (current == null)
            return -1;
        
        return pop(current);
    }
        
    int pop(HeadNode head) {
        
        Node temp = head.value;
        
        if (temp.next == null){
            temp = null;
            _headOfHeads = null;            
            return temp.value;
        }
        
        // Advance each head one position forward
        HeadNode currentHead = head;   
        HeadNode previousHead = null;
        while (currentHead != null) {        
            currentHead.value = currentHead.value.next;    
            previousHead = currentHead;
            currentHead = currentHead.next;
        }    
                
        if (previousHead.value == null) {
            previousHead.previous.next = null;
        }
        
        if (temp.previous != null) {
            temp.previous.next = temp.next;
        }
        else {            
            _mainHead = temp.next;
            temp.next.previous = null;
                       
        }
        return temp.value;    
    }
    
    public int getLength() {
        int length = 0;
        Node current = _mainHead;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
    
    public int[] toArray() {
        Node current = _mainHead;
        int[] values = new int[getLength()];
        int index = 0;
        while (current!=null) {
            values[index] = current.value;
            current = current.next;
            index++;
        }
        
        return values;
    }
    
    public int[] headsToArray() {
        HeadNode current = _headOfHeads;
        
        int length = 0;
        while (current != null)
        {
            length++;
            current = current.next;
        }
        
        current = _headOfHeads;
        
        int[] values = new int[length];
        int index = 0;
        while (current != null) {
            values[index] = current.value.value;
            index++;
            current = current.next;
        }
        
        return values;
    }
}
