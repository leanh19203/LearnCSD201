/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.LinkedList;

/**
 *
 * @author Admin
 */
public class Queue {
    LinkedList<Integer> Q = new LinkedList<Integer>();
    public boolean isEmpty(){
        return Q.isEmpty();
    }
    public void enQueue(Integer p){//them vao hang doi 1 node
        if(p!=null) Q.addFirst(p);
    }
    public Integer deQueue(){//lay 1 phan tu ra khoi ham doi
        Integer p=null;
        if(!isEmpty()) {
            p=Q.getLast();
            Q.removeLast();
    }
        return p;
}
    public Integer visit(){
         Integer p=null;
        if(!isEmpty()) {
            p=Q.getLast();
            
    }
        return p;
    }
                   
}