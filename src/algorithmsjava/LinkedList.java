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
    
    private Node getNthNodeFromEnd(int posFromEnd) {
        Node front = _head;
        for (int i=0; i<posFromEnd; i++) {
            front = front.next;
        }
        Node back = _head;        
        while (front.next != null) {
            front = front.next;
            back = back.next;
        }
        return back;
    }
    
    public int getNthFromEnd(int posFromEnd) {        
        Node node = getNthNodeFromEnd(posFromEnd);
        return node.next.data;              
    }
    
    public void deleteNthFromEnd(int posFromEnd) {
        Node node = getNthNodeFromEnd(posFromEnd);
        if (node.next.next != null)
            node.next = node.next.next;
        else
            node.next = null;
    }
    
    public void deleteFirstNNodes(int nNodes) {
        int i = 0;
        while (i<nNodes && _head != null)
        {
            _head = _head.next;
            i++;
        }
    }
    
    public void deleteEnd(){ 
        
        if (_head == null)
            return;
        
        if (_head.next == null)
        {
            _head = null;
            return;
        }
        
        Node current = _head;      
        while (current.next.next != null)
            current = current.next;
        current.next = null;
    }       
    
    public int itemAt(int index) throws Exception{
        Node current = _head;
        int i = 0;
        while (current != null && i < index)
        {
            current = current.next;
        }
        if (current == null)            
            throw new Exception();
        
        return current.data;
        
    }
    
}
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
    
    public class Node {     
        int data;
        Node next;        
    }      
    
    private Node _head;   
   
    public LinkedList() {
        this(1);
    }
    
    public void setInitialValue(int value) {
        _head.data = value;
    }
    
    public Node getHead() {
        return _head;
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
    
    private Node getNthNodeFromEnd(int posFromEnd) {
        Node front = _head;
        for (int i=0; i<posFromEnd; i++) {
            front = front.next;
        }
        Node back = _head;        
        while (front.next != null) {
            front = front.next;
            back = back.next;
        }
        return back;
    }
    
    public int getNthFromEnd(int posFromEnd) {        
        Node node = getNthNodeFromEnd(posFromEnd);
        return node.next.data;              
    }
    
    public void deleteNthFromEnd(int posFromEnd) {
        Node node = getNthNodeFromEnd(posFromEnd);
        if (node.next.next != null)
            node.next = node.next.next;
        else
            node.next = null;
    }
    
    public void deleteFirstNNodes(int nNodes) {
        int i = 0;
        while (i<nNodes && _head != null)
        {
            _head = _head.next;
            i++;
        }
    }
    
    public void deleteEnd(){ 
        
        if (_head == null)
            return;
        
        if (_head.next == null)
        {
            _head = null;
            return;
        }
        
        Node current = _head;      
        while (current.next.next != null)
            current = current.next;
        current.next = null;
    }       
    
    public int itemAt(int index) throws Exception{
        Node current = _head;
        int i = 0;
        while (current != null && i < index)
        {
            current = current.next;
        }
        if (current == null)            
            throw new Exception();
        
        return current.data;
        
    }
    
    public void pivotAt(int value) {
       Node pivotNode = putPivotNodeToEnd(value);
        
       while (_head.data > pivotNode.data) {
           Node temp = _head;
           _head = _head.next;
           moveToEnd(pivotNode, temp);
       }
       
       Node prev = _head;
       Node curr = _head.next;
       while (curr != null && curr.data != value) {
           if (curr.data > value) {
               Node temp = curr;
               prev.next = curr.next;
               temp.next = null; // sever link;
               moveToEnd(pivotNode, temp);
               curr = prev.next;
           }
           else {
               prev = curr;
               curr = curr.next;
           }
       }             
    }
    
    private void moveToEnd(Node head, Node node) {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        node.next = null;
    }
    
    public Node putPivotNodeToEnd(int value) {
        Node current = _head;
        Node pivotNode = _head;
        while (current.next != null) {
            if (current.next.data == value) {
                pivotNode = current.next;
            }
            current = current.next;
        }
        
        // No check if the pivot doesn't exist
        if (pivotNode == null)
        {
            // Throw
        }
            
        Node temp = pivotNode.next;
        pivotNode.next = null;
      
        current.next = _head;
        _head = temp;
        
        return pivotNode;      
    }
    
    public Node addReverse(Node otherNode) {
        double a = convertToNumberReverse(_head);
        double b = convertToNumberReverse(otherNode);
        double sum = a + b;
        
        return convertToLinkedListReverse(sum);
    }
    
   
    
    private double convertToNumberReverse(Node node) {
        double total = 0;
        double power = 0;
        Node curr = node;
        while (curr != null) {
            total += curr.data * Math.pow(10, power);
            power++;
            curr = curr.next;            
        }       
        return total;
    }
    
    private double convertToNumberInOrder(Node node) {
        double total = 0;
        double power = 0;
        Node curr = node;
        while (curr != null) {
            total = (total* Math.pow(10, power) + curr.data);
            curr = curr.next;
        }
                
        return total;
    }
    
    private Node convertToLinkedListReverse(double value) {
       double power = 0;
       double total = value;
       Node head = new Node();
       
       Node curr = head;
       while (total > 0) {
           int num = (int)(total % Math.pow(10, power+1));
           int digit = (int)(num / Math.pow(10, power));
           total -= digit * Math.pow(10, power);
           power++;          
           curr.data = digit;
           if (total > 0) {
                curr.next = new Node();
                curr = curr.next;
           }
       }
       return head;
    }
}
