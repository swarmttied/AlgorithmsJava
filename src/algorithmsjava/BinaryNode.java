/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmsjava;

/**
 *
 * @author Gio
 */
public class BinaryNode {
    
    Node _root;
    
    public BinaryNode(int value) {   
        _root = new Node();
        _root.value = value;
    }
    
    class Node {
        public int value;
        public Node left;
        public Node right;
    }
    
    public void add(int value){
        if (_root == null){
            _root = new Node();           
        }     
        
         _root.value = value;      
    }
    
    public Boolean isBalanced() {
        return false;
    }
    
    public int getHeight() {
        return getHeight(_root);
    }
    
    int getHeight(Node root) {
        if (root == null)
            return 0;
        
        return Math.max(getHeight(root.left) + 1, getHeight(root.right)+1);
    }
}
