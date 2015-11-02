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
public class MultiStack {
    
     Object[] _multiStack;
     int[] _heads;
     int _sizeEach;
    
    public MultiStack(int nStacks, int sizeEach) {
        // TODO: Check params
        _sizeEach = sizeEach;
        _multiStack = new Object[nStacks*sizeEach];
        _heads = new int[nStacks];
        for (int i=0; i<sizeEach; i++) {
            _heads[i]=-1;
        }
    }
    
    public void push(int whichStack, Object value) {
        _heads[whichStack]++;        
        int index = getArrIndex(whichStack);        
        _multiStack[index] = value;        
    }

    private int getArrIndex(int whichStack) {
        // Check out of range here        
        
        int head = _heads[whichStack];
        int index = head * _heads.length + whichStack;
        return index;
    }
    
    public Object pop(int whichStack) {
        // Check for empty
        if (isEmpty(whichStack))
            return null;
        
        int index = getArrIndex(whichStack);
        Object returnValue = _multiStack[index];
        _multiStack[index] = null;       
        _heads[whichStack]--;
        
        return returnValue;        
    }
    
    public Boolean isFull(int whichStack) {
        return _heads[whichStack] == _sizeEach - 1;
    }
    
    public Boolean isEmpty(int whichStack) {
        return _heads[whichStack] == -1;
    }
    
    
}
