/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmsjava;

import java.util.Vector;

/**
 *
 * @author Gio
 */
public class TowerOfHanoi {
    private SinglyLinkedNode[] _towers = new SinglyLinkedNode[3];
    private int _noOfDisks;
    
    public TowerOfHanoi(int noOfDisks) {
        _noOfDisks = noOfDisks;
        _towers[0] = new SinglyLinkedNode();
       
        SinglyLinkedNode firstTower = _towers[0];
        firstTower.value = 0;
        for (int i=1; i<noOfDisks; i++) {
            SinglyLinkedNode temp = new SinglyLinkedNode();
            temp.value = i;
            firstTower.next = temp;
            firstTower = firstTower.next;
         }        
    }
    
    public Boolean isMovePossible(int sourceTower, int targetTower) {
        // Check skipped
        
        if (_towers[sourceTower] == null)
            return false;
        
        if (_towers[targetTower] != null && _towers[targetTower].value <
                _towers[sourceTower].value)
            return false;        
        
        return true;
    }
    
    public void moveDisk(int sourceTower, int targetTower) throws Exception {
        if (!isMovePossible(sourceTower,targetTower))
            throw new Exception("Move not possible");
        
        SinglyLinkedNode diskToMove = _towers[sourceTower];
        
        if (_towers[sourceTower].next == null) 
            _towers[sourceTower] = null;
        else
            _towers[sourceTower] = _towers[sourceTower].next;
                
        SinglyLinkedNode target = _towers[targetTower];        
        if (target == null) {
            _towers[targetTower] = diskToMove;
            _towers[targetTower].next = null;
        }
        else {
            target.next = _towers[targetTower];
            _towers[targetTower] = target;            
        }            
    }
    
    public Integer[] getTower0Disks() {
        return getDisks(0);
    }
    
    public Integer[] getTower1Disks() {
        return getDisks(1);
    }
    
    public Integer[] getTower2Disks() {
        return getDisks(2);
    }
    
    Integer[] getDisks(int towerNo) {
        Vector<Integer> diskValues = new Vector();
        SinglyLinkedNode temp = _towers[towerNo];
        while (temp != null) {
            diskValues.add(temp.value);
            temp = temp.next;
        }
        
        return diskValues.toArray(new Integer[diskValues.size()]);
    }
}
